package com.toto.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.toto.resp.Resp;
import com.toto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("index")
public class IndexController {

    //1.使用restTemplate去获取其它服务的数据
    @Autowired
    private RestTemplate restTemplate;
    String url = "http://ORDER-SERVICE";
    //2编写一个service接口指向服务名，然后调用其中的接口
    @Resource
    private OrderService orderService;

    /**
     * 假设这是用户信息类
     * @return
     */
    @GetMapping("userinfo")
    public Resp getUserInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("username","张三");
        map.put("email","xxx@163.com");
        map.put("age","16");
        return Resp.OK(map);
    }

    @GetMapping("getOrder")
    @HystrixCommand(fallbackMethod = "getOrderError")
    public Resp getOrder(){
        return Resp.OK(restTemplate.getForObject(url+"/getOrder",Map.class));
    }

    @GetMapping("getOrderByService")
    @HystrixCommand(fallbackMethod = "getOrderError") //如果出错会自动走fallback的方法
    public Resp getOrderByService(){
        return Resp.OK(orderService.getOrder());
    }

    /**
     * 限流：hystrix 通过线程词的方式来管理你的微服务调用，它默认是10个线程（大小）管理你的微服务
     * 你可以给某个微服务开辟新的线程池
     * coreSize 表示并发最大线程数，value表示值 相当于key-value
     * maxQueueSize 表示队列数，当设置为-1时，会使用SynchronousQueue 默认-1
     * @return
     */
    @GetMapping("getOrderByService2")
    @HystrixCommand(fallbackMethod = "getOrderError",
    threadPoolKey = "order",threadPoolProperties = {
            @HystrixProperty(name ="coreSize",value = "2"),
            @HystrixProperty(name="maxQueueSize",value = "1")
    })
    public Resp getOrderByxl(){
        return Resp.OK(orderService.getOrder());
    }

    /**
     * 降级方法
     * @return
     */
    public Resp getOrderError(){
        return Resp.error("服务器连接异常");
    }
}

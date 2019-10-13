package com.toto.controller;

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
    public Resp getOrder(){
        return Resp.OK(restTemplate.getForObject(url+"/getOrder",Map.class));
    }

    @GetMapping("getOrderByService")
    public Resp getOrderByService(){
        return Resp.OK(orderService.getOrder());
    }
}

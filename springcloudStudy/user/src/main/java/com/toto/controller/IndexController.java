package com.toto.controller;

import com.toto.resp.Resp;
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

    @Resource
    private RestTemplate restTemplate;
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
        return Resp.OK(restTemplate.getForObject("http://localhost:8082/getOrder",Map.class));
    }
}

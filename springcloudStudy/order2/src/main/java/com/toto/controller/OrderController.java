package com.toto.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {


    @RequestMapping("getOrder")
    public Map<String,String> getOrder(){
        Map<String,String> order = new HashMap<>();
        order.put("orderId","1");
        order.put("orderName","服务器1年服务");
        return order;
    }
}

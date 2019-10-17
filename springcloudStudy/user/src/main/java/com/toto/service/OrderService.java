package com.toto.service;

import com.toto.service.impl.OrderServiceFallBack;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ORDER-SERVICE",fallback = OrderServiceFallBack.class)
public interface OrderService {

    @RequestMapping("/getOrder")
    public Object getOrder();
}

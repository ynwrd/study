package com.toto.service.impl;

import com.toto.resp.Resp;
import com.toto.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallBack implements OrderService {

    @Override
    public Object getOrder() {
        return Resp.error("方法降级，服务器异常...");
    }
}

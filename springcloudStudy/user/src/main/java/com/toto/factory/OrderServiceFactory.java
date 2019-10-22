package com.toto.factory;

import com.toto.resp.Resp;
import com.toto.service.OrderService;
import com.toto.service.impl.OrderServiceFallBack;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 如果你需要拿到order服务的错误异常信息，你可以创建一个错误回调工厂来获取错误信息返回
 */
@Component
public class OrderServiceFactory implements FallbackFactory<OrderService> {
    @Override
    public OrderService create(Throwable cause) {
        return new OrderService(){
            @Override
            public Object getOrder() {
                System.out.println(cause.getMessage());
                return Resp.error("你调的订单接口出错了");
            }
        };
    }
}

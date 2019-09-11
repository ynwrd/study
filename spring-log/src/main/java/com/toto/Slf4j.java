package com.toto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * slf4j也不会提供log的具体实现，但它可以绑定一种日志结构
 * 在maven中导入对应版本的slf4j-jdk14 或者slf4j-log4j12(每个版本都有对应的日志实现)
 * 就能使用对应的log信息，在实际的项目中也能进行灵活的配置，而且版本仍然在更新
 */
public class Slf4j {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("slf4j");
        logger.info("slf4j 日志打印");
    }
}

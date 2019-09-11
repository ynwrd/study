package com.toto;

import org.apache.log4j.Logger;

public class Log4j {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("log4j");
        log.info("log4j 日志打印");
    }
}

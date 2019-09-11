package com.toto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * jcl 是抽像的,使用中间键，从for循环下依次往下找
 * new String[]{"org.apache.commons.logging.impl.Log4JLogger", "org.apache.commons.logging.impl.Jdk14Logger", "org.apache.commons.logging.impl.Jdk13LumberjackLogger", "org.apache.commons.logging.impl.SimpleLog"};
 * 通过类名进行依次for循环 class.forName(str[i]) 然后newInstance实例这个日志类，所以使用JCL会根据数组列表依次获取log，它自己没有实现log
 * 在项目中使用jcl可以在混乱的日志体系中选择自己当前有使用的日志,但这个版本已经非常久没有更新了
 */
public class JCL {
    public static void main(String[] args) {
        Log log = LogFactory.getLog("jcl");
        log.info("jcl 日志打印");
    }
}

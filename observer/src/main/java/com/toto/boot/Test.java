package com.toto.boot;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import java.io.File;

/**
 * 模仿一个spring boot启动
 */
public class Test {
    public static void main(String[] args) throws Exception {
        ToToApplication.run();
    }
}

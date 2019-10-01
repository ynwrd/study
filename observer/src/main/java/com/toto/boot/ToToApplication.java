package com.toto.boot;

import org.apache.catalina.Context;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class ToToApplication {
    /**
     * 模仿spring boot 的SpringbootApplication 的run方法
     * 使用spring mvc
     * @throws Exception
     */
    public static void run()throws Exception{
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context ctx = tomcat.addWebapp("/",new File("observer/src/main/webapp").getAbsolutePath());
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                Test.class.getResource("/").getPath(), "/"));
        tomcat.start();
        tomcat.getServer().await();
    }
}

package com.Jessica.springcloud.zuul.Zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//网关应用程序
//EnableZuulProxy  标识当前应用是zuulserver
//SpringCloudApplication  用于简化配置的注解
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {
  public static void main(String[] args) {
      SpringApplication.run(ZuulGatewayApplication.class,args);
  }
}

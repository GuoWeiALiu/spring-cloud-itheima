package com.itheima.consumer;

import com.itheima.consumer.config.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:03
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
/*配置Ribbon负载均衡
* name : 服务提供方应用名称
* configuration ：负载均衡bean
* */
 //@RibbonClient(name = "EUREKA-PROVIDER", configuration = MyRule.class)
public class ConsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class,args);
    }
}

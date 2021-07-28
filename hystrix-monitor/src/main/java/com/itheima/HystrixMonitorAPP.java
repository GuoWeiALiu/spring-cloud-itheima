package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author guoweiliu
 * @date 2021-07-28 7:31
 */

@SpringBootApplication
@EnableTurbine  //开启turbine聚合监控功能
@EnableDiscoveryClient
@EnableHystrixDashboard  //开启仪表盘
public class HystrixMonitorAPP {

    public static void main(String[] args) {
        SpringApplication.run(HystrixMonitorAPP.class, args);
    }
}

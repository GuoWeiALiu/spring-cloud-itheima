package com.itheima.consumer.controller;

import com.itheima.consumer.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:28
 */
@EnableDiscoveryClient
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/goods/{id}")
    public Goods findGoodById(@PathVariable("")int id){
        System.out.println("findGoodsById"+id);
        /*
        * 从eureka 动态获取provider ip
        * 1 注入DiscoveryClient对象激活
        * 2 调用方法
        * */

        List<ServiceInstance> instances = discoveryClient.getInstances("EUREKA-PROVIDER");
        if(instances == null || instances.size()==0){
            return null;
        }

        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://"+host+":"+port+"/goods/findOne/"+id;

        Goods goods = restTemplate.getForObject(url, Goods.class);
        return goods;
    }
}

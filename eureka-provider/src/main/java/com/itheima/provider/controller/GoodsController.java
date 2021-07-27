package com.itheima.provider.controller;

import com.itheima.provider.domain.Goods;
import com.itheima.provider.service.GoodsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:17
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Value("${server.port}")
    private int port;
/*
* 降价：
* 1 出现一场
* 2 服务调用超时
* */
    @HystrixCommand(fallbackMethod = "findOne_fallback",
            commandProperties = {
            //设置hystrix 超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "30"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "3000")


    })
    @GetMapping("/findOne/{id}")
    public Goods findOne(@PathVariable("id") int id) {
        Goods goods = goodsService.findOne(id);
        if (id == 1){
            int i = 3/0;
        }
        //int i = 3/0;
/*        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        goods.setTitle(goods.getTitle() + ":" + port);  //端口号设置到商品标题
        return goods;
    }


    /*
    * 定义降级方法：
    * 1 方法返回值和原方法一样
    * 2 方法的参数和原方法一样
    *
    * */
    public Goods findOne_fallback(@PathVariable("id") int id) {
        Goods goods = new Goods();
        goods.setTitle("降级处理");

        return goods;
    }
}


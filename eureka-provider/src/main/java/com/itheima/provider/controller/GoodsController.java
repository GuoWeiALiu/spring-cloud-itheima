package com.itheima.provider.controller;

import com.itheima.provider.domain.Goods;
import com.itheima.provider.service.GoodsService;
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
    @GetMapping("/findOne/{id}")
    public Goods findOne(@PathVariable("id") int id){
        Goods goods = goodsService.findOne(id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goods.setTitle(goods.getTitle()+":"+port);  //端口号设置到商品标题
        return goods;
    }

}


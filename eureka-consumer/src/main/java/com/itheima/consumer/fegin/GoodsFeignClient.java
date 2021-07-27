package com.itheima.consumer.fegin;

import com.itheima.consumer.config.FeignLogConfig;
import com.itheima.consumer.domain.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author guoweiliu
 * @date 2021-07-27 18:55
 * feign 的声明式接口，发起远端调用
 *         String url = "http://EUREKA-PROVIDER/goods/findOne/"+id;
 *
 *         Goods goods = restTemplate.getForObject(url, Goods.class);
 *  1 定义接口
 *  2 接口上添加注解设置value属性为服务提供者的应用名称
 *  3 编写调用接口，接口的声明规则和提供方保持一致
 *  4 注入接口对现象，调用接口方法完成远程调用
 */
@FeignClient(value = "EUREKA-PROVIDER", configuration = FeignLogConfig.class)
public interface GoodsFeignClient {
    @GetMapping("/goods/findOne/{id}")
    public Goods findOneById(@PathVariable("id") int id);

}

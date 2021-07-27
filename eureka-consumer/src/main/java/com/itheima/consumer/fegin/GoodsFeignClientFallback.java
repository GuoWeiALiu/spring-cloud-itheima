package com.itheima.consumer.fegin;

import com.itheima.consumer.domain.Goods;
import org.springframework.stereotype.Component;

/**
 * @author guoweiliu
 * @date 2021-07-27 22:23
 * Feign 客户端的降级处理
 * 1 定义类 实现Feign客户端接口
 * 2使用@ Component 注解将Bean 加入IOC 容器
 */
@Component
public class GoodsFeignClientFallback implements GoodsFeignClient {
    @Override
    public Goods findOneById(int id) {
        Goods goods = new Goods();
        goods.setTitle("客户端降级处理");
        return goods;
    }
}

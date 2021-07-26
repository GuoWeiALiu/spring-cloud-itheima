package com.itheima.provider.dao;

import com.itheima.provider.domain.Goods;
import org.springframework.stereotype.Repository;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:09
 */
@Repository
public class GoodsDao {
    public Goods findOne(int id){
        return new Goods(1,"华为",3999,1000);
    }
}

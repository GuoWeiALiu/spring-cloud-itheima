package com.itheima.provider.service;

import com.itheima.provider.dao.GoodsDao;
import com.itheima.provider.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import javax.xml.ws.soap.Addressing;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:14
 * Goods 业务层
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    /*
    * 根据id查询
    *
    */
    public Goods findOne(int id){
        return goodsDao.findOne(id);
    }
}

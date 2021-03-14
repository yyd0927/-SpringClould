package net.xdclass.order_service.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品订单实体类
 * */
@Data
public class ProductOrder implements Serializable
{

    private int id ;
    /**
     * 商品名称
     * */
    private  String productName ;

    /**
     * 订单号
     * */
    private  String tradeNo ;

    /**
     * 商品价格，分
     * */
    private int price ;
    /**
     * 创建时间
     * */
    private Date createtime ;
    /**
     * 用户
     * */
    private int userId ;
    /**
     * 用户名
     * */
    private String userName ;



}

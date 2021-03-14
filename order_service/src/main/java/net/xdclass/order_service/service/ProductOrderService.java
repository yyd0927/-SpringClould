package net.xdclass.order_service.service;

import net.xdclass.order_service.domain.ProductOrder;

/**
 * 订单业务类
 * @author di-yang
 * */
public interface ProductOrderService {

    /**
     * 保存订单
     * @param productId 产品ID
     * @param userId 用户ID
     * @return 订单数据
     * */
    ProductOrder save(int userId, int productId ) ;

    /**
     * 保存
     * @return 订单数据
     * */

    ProductOrder save( ) ;

}

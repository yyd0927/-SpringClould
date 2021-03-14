package net.xdclass.order_service.controller;

import net.xdclass.order_service.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService ProductOrderService ;

    @RequestMapping("save")
    public  Object save(@RequestParam("user_id") int userId,@RequestParam("product_id") int productId ){

        return  ProductOrderService.save(userId,productId) ;
    }


}

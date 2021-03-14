package net.xdclass.product_service.service.impl;

import net.xdclass.product_service.domain.Product;
import net.xdclass.product_service.service.ProductService;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static Map<Integer,Product> daoMap = new HashMap<>();

    static{
      Product p1 = new Product(1,"iphone12",6799,10);
      Product p2 = new Product(2,"iphone11",5299,10);
      Product p3 = new Product(3,"iphoneX",4999,10);
      Product p4 = new Product(4,"iphone8",3799,10);
      Product p5 = new Product(5,"iphone7",2799,10);
      Product p6 = new Product(6,"iphone6",1799,10);
      Product p7 = new Product(7,"iphone4S",1000,10);

      daoMap.put(p1.getId(),p1);
      daoMap.put(p2.getId(),p2);
      daoMap.put(p3.getId(),p3);
      daoMap.put(p4.getId(),p4);
      daoMap.put(p5.getId(),p5);
      daoMap.put(p6.getId(),p6);
      daoMap.put(p7.getId(),p7);


    }

    @Override
    public  List<Product> listProduct(){

         Collection<Product> collection = daoMap.values();
         List<Product> list = new ArrayList<>(collection) ;

       // List<Product> list= daoMap.entrySet().stream().map(et ->et.getKey()+"_"+et.getValue()).collect(Collectors.toList());


        return  list ;
    };

    @Override
    public   Product findByid(int id){

    return daoMap.get(id) ;

    };


}

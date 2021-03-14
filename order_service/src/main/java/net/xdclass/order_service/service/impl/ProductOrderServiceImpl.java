package net.xdclass.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import net.xdclass.order_service.domain.ProductOrder;
import net.xdclass.order_service.service.ProductClient;
import net.xdclass.order_service.service.ProductOrderService;
import net.xdclass.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

//    @Autowired
//    private RestTemplate restTemplate ;

//    @Autowired
//    private LoadBalancerClient loadBalancer ;

    @Autowired
    private ProductClient productClient ;

    //获取商品详情
    @Override
    public ProductOrder save(int userId, int productId ){

        //调用方式一
        //Map<String,Object> productMap =  restTemplate.getForObject("http://product-service/api/v1/product/find?id="+productId,Map.class) ;

        //调用方式二
//        ServiceInstance instance  = loadBalancer.choose("product-service") ;
//        String url = String.format("http://%s:%s/api/v1/product/find?id="+productId,instance.getHost(),instance.getPort());
//        RestTemplate  restTemplate = new RestTemplate();
//        Map<String,Object> productMap =  restTemplate.getForObject(url,Map.class);
//        System.out.println(productMap);

        //调用方式三
        String response = productClient.findById(productId);

        JsonNode jsonNode = JsonUtils.str2JsonNode(response);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreatetime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));

        return productOrder ;

    }

    /**
     * 学习RestTemplate
     * get,post,put,delete请求
     * */
   @Override
    public ProductOrder save( ){
       ProductOrder productOrder = new ProductOrder();

//       // GET请求
//       //getForEntity方法，返回值是一个ResponseEntity<T>是Spring对HTTP请求响应的封装，包括了几个重要的元素，如响应码、contentType、contentLength、响应消息体等
//       //返回值除了String 也可以是自定义类型，例如ResponseEntity<ProductOrder>
//       //getForEntity还有其他重载方法
//       ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://product-service/api/v1/product/find", String.class);
//
//       //getForObject方法，是对getForEntity函数的进一步封装，返回消息体的内容。getForObject还有其他重载方法
//       productOrder = restTemplate.getForObject("http://product-service/api/v1/product/find", ProductOrder.class);
//
//       //带参数的方法一
//       ResponseEntity<String> responseEntity2 = restTemplate.getForEntity("http://product-service/api/v1/product/find?name={1}", String.class, "赵赵");
//       //带参数的方法二
//       Map<String, String> map = new HashMap<>();
//       map.put("name", "李李");
//       ResponseEntity<String> responseEntity3 = restTemplate.getForEntity("http://product-service/api/v1/product/find?name={name}", String.class, map);
//
//       //调用地址也可以是URI
//       UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://product-service/api/v1/product/find?name={name}").build().expand("钱钱").encode();
//       URI uri = uriComponents.toUri();
//       ResponseEntity<String> responseEntity4 = restTemplate.getForEntity(uri, String.class);
//
//       //POST请求
//       //postForEntity方法，postForObject方法，postForLocation方法
//       //参数一表示要调用的服务的地址，参数二表示上传的参数，参数三表示返回的消息体的数据类型
//       ResponseEntity<ProductOrder>  responseEntity5 = restTemplate.postForEntity("http://product-service/api/v1/product/find",productOrder,ProductOrder.class);
//       Object obj  =  restTemplate.postForObject("http://product-service/api/v1/product/find"  ,productOrder , Object.class  );
//
//       //PUT请求
//       //put方法没有返回值
//       restTemplate.put("http://product-service/api/v1/product/find/{1}" ,productOrder,1);
//
//       //DETETE请求
//       restTemplate.delete("http://product-service/api/v1/product/find/{1}", 2);

      return  productOrder ;
    }








}

package com.baichen.cloud.microserviceconsumermoviefeign.user.feign;

import com.baichen.cloud.microserviceconsumermoviefeign.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name ="microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}

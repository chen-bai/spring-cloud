package com.baichen.cloud.microserviceconsumermoviefeignhystrixfallback.user.feign;

import com.baichen.cloud.microserviceconsumermoviefeignhystrixfallback.user.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign的fallback测试
 * 使用@FeignClient的fallback属性指定回退类
 * @author baichen
 */
@FeignClient(name ="microservice-provider-user", fallback=FeignClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}

/**
 * 回退类FeignClientFallback需实现Feign Client接口
 * FeignClientFallback也可以是public class，没有区别
 * @author baichen
 */
@Component
class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("default user");
        return user;
    }
}
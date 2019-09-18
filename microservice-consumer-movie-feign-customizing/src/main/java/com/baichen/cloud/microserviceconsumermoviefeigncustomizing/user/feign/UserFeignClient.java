package com.baichen.cloud.microserviceconsumermoviefeigncustomizing.user.feign;

import com.baichen.cloud.config.FeignConfiguration;
import com.baichen.cloud.microserviceconsumermoviefeigncustomizing.user.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 使用@FeignClient的configuration属性，指定feign的配置类
 *
 * @author baichen
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {
    /**
     * 使用feign自带的注解@RequestLine
     * @see https://github.com/OpenFeign/feign
     * @param id 用户id
     * @return 用户信息
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}

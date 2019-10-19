package com.baichen.cloud.microserviceconsumermoviefeignhystrixfallbackfactory.user.feign;

import com.baichen.cloud.microserviceconsumermoviefeignhystrixfallbackfactory.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Feign的fallback测试
 * 使用@FeignClient的fallback属性指定回退类
 *
 * @author baichen
 */
@FeignClient(name = "microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}

/**
 * The fallback factory must produce instances of fallback classes that implement
 * the interface annotated by {@link FeignClient}
 * @author baichen
 */
@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            // 日志最好放在各个fallback方法中，而不要直接放在create方法中。
            // 否则在引用启动时，就会打印该日志。
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);
                User user = new User();
                user.setId(-1L);
                user.setUsername("defaul user");
                return user;
            }
        };
    }
}
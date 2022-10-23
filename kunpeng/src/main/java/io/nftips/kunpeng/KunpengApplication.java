package io.nftips.kunpeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
//@MapperScan(basePackages = "io.nftips.kunpeng.orm.mapper")
public class KunpengApplication {
    public static void main(String[] args) {
        SpringApplication.run(KunpengApplication.class, args);
    }
}

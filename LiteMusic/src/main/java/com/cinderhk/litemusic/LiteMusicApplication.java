package com.cinderhk.litemusic;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cinderhk.litemusic"})
@MapperScan("com.cinderhk.litemusic.mapper")
public class LiteMusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteMusicApplication.class, args);
    }

}

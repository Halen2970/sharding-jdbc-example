package com.didi.example;

import com.didi.example.dto.UserDto;
import com.didi.example.service.UserService;
import com.google.common.collect.Lists;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author huangjin
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.didi.example.mapper")
@Slf4j
public class ExampleApplication implements ApplicationRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(ExampleApplication.class)
            .web(false)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("start sharding jdbc example app.");
        List<UserDto> res = userService.findByIds(Lists.newArrayList((long)1, (long)2, (long)3,(long)4,(long)5));
        log.info(res.toString());
//        userService.create(UserDto.builder().userId((long)10).name("hjin").mobile("188888888888").build());
        userService.update(UserDto.builder().userId((long)10).name("hjin").mobile("188888888889").build());
        userService.remove((long)10);

    }
}

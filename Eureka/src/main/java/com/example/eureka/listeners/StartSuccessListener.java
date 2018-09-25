package com.example.eureka.listeners;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : wuguangyao
 * @date : 2018-09-25
 */
@Component
@Slf4j
public class StartSuccessListener implements ApplicationListener<ApplicationReadyEvent>{

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("启动成功");
    }
}

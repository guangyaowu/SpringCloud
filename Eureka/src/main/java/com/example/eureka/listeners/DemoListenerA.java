package com.example.eureka.listeners;

import com.example.eureka.listeners.events.DemoEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : wuguangyao
 * @date : 2018-09-26
 */
@Component
@Slf4j
public class DemoListenerA implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        log.info("处理者A处理事件 ：" + event.getEventContent());
    }
}

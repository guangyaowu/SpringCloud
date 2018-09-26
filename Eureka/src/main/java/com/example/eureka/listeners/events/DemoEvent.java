package com.example.eureka.listeners.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author : wuguangyao
 * @date : 2018-09-26
 */
@Setter
@Getter
public class DemoEvent extends ApplicationEvent {

    private String eventContent ;

    public DemoEvent(Object source,String eventContent) {
        super(source);
        this.eventContent = eventContent;
    }
}

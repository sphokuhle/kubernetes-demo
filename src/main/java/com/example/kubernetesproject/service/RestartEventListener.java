package com.example.kubernetesproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RestartEventListener {

    @Autowired
    private RetryService retryService;

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        retryService.testAfterRestart();
    }
}

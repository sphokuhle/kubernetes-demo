package com.example.kubernetesproject.service;

import com.example.kubernetesproject.KubernetesProjectApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RestartService {

    @Autowired
    private ConfigurableApplicationContext context;

    @Autowired
    private RetryService retryService;

    public void restart() {
        System.out.println("Application restarting...");
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(KubernetesProjectApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }
}

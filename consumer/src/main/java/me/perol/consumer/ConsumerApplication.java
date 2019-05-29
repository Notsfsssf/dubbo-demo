package me.perol.consumer;

import me.perol.provider.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
public class ConsumerApplication {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20880")
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
          System.out.println(demoService.sayHello("mercyblitz"));
        };
    }
}

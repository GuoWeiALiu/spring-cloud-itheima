package itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author guoweiliu
 * @date 2021-07-26 22:51
 */
@SpringBootApplication
//启用EurekaServer
@EnableEurekaServer
public class EurekaApp1 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp1.class, args);
    }
}

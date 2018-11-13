package hui.wang.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *
 * @author hui.wang09
 * @since 13 November 2018
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer.class, args);
	}
}

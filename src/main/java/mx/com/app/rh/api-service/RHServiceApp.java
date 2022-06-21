package mx.com.app.login.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * The Class Login.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "mx.com.app.login.apiservice")
public class RHServiceApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(mx.com.app.login.apiservice.RHServiceApp.class, args);
	}



}

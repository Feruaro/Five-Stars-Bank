package br.com.fivestarsbank.BlueBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = { ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class })
public class FiveStarsBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiveStarsBankApplication.class, args);
	} 

}

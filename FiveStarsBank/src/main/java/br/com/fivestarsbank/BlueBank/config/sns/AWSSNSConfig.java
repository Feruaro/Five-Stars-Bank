package br.com.fivestarsbank.BlueBank.config.sns;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AWSSNSConfig {

	public static final String ACCESS_KEY = "AKIA6BZRT7L4YR72JVVZ";
    public static final String SECRET_KEY = "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";
    
	@Primary
	@Bean
	public AmazonSNSClient getSnsClient() {
		return (AmazonSNSClient) AmazonSNSClientBuilder.standard().withRegion(Regions.US_EAST_2)
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY)))
				.build();
	}
}

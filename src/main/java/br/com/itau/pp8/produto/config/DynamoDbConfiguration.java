package br.com.itau.pp8.produto.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;

@Factory
public class DynamoDbConfiguration {
	
	@Property(name = "aws.credentials.access-key")
	private String accessKey;
	
	@Property(name = "aws.credentials.secret-key")
	private String secretKey;
	
	@Property(name = "aws.endpoint-url")
	private String endpointUrl;
	
	@Property(name = "aws.region")
	private String region;
	
	@Singleton
	public DynamoDBMapper dynamoDBMapper() {
		return new DynamoDBMapper(buildAmazonDynamoDB());
	}

	private AmazonDynamoDB buildAmazonDynamoDB() {
		var credentials = new BasicAWSCredentials(accessKey, secretKey);
		var endpoint = new AwsClientBuilder.EndpointConfiguration(endpointUrl, region);
		
		return AmazonDynamoDBClientBuilder.standard()
//			.withRegion(region)
			.withCredentials(new AWSStaticCredentialsProvider(credentials))
			.withEndpointConfiguration(endpoint)
			.build();
	}
}
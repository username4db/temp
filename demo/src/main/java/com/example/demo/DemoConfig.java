package com.example.demo;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.BasicHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContexts;
import org.apache.hc.core5.ssl.TrustStrategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DemoConfig {

	@Bean("restSSL")
	public RestTemplate genRestTemplate(RestTemplateBuilder builder)
			throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException {

		final TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
		final SSLContext sslContext = SSLContexts //
				.custom() //
				.loadTrustMaterial(null, acceptingTrustStrategy) //
				.build();
		final SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
				NoopHostnameVerifier.INSTANCE);
		final Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder //
				.<ConnectionSocketFactory>create() //
				.register("https", sslsf) //
				.register("http", new PlainConnectionSocketFactory()) //
				.build(); //
		final BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager(
				socketFactoryRegistry);

		CloseableHttpClient httpClient = HttpClients //
				.custom() //
				.setConnectionManager(connectionManager) //
				.build();

		HttpComponentsClientHttpRequestFactory customRequestFactory = new HttpComponentsClientHttpRequestFactory();
		customRequestFactory.setHttpClient(httpClient);

		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
		interceptors.add(new DemoRequestInterceptor("NEW_HEAD", MediaType.APPLICATION_JSON_VALUE));

		RestTemplate restTemplate = builder.requestFactory(() -> customRequestFactory).build();
		restTemplate.setInterceptors(interceptors);

		return restTemplate;
	}
}

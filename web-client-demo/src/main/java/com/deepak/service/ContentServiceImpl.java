package com.deepak.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class ContentServiceImpl implements ContentService {

	private static final Logger LOGGER = Logger.getLogger(ContentServiceImpl.class.getName());

	private final WebClient webClient;

	public ContentServiceImpl(//
			@Value("${content-service}") String baseURL //
	) {
		this.webClient = WebClient //
				.builder() //
				.baseUrl(baseURL) //
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE) //
				.filter(logRequest()) //
				.filter(logResponse()) //
				.build();
	}

	@Override
	public String getPost(int id) {
//		Mono<Post> p = webClient //
//		.bodyToMono(Post.class);
		Mono<String> p = webClient //
				.get() //
				.uri("posts/{id}", id) //
				.retrieve() //
				.bodyToMono(String.class);
		return p.block();
	}

	private ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(req -> {
			LOGGER.info("Request >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			LOGGER.info(req.method().toString());
			LOGGER.info(req.url().toString());
			req.headers().forEach((name, values) -> values.forEach(value -> LOGGER.info(name + ":" + value)));
			LOGGER.info("Request <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			return Mono.just(req);
		});
	}

	private ExchangeFilterFunction logResponse() {
		return ExchangeFilterFunction.ofResponseProcessor(res -> {
			LOGGER.info("Response >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			res.headers().asHttpHeaders()
					.forEach((name, values) -> values.forEach(value -> LOGGER.info(name + ":" + value)));
			LOGGER.info("Response <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			return Mono.just(res);
		});
	}
}

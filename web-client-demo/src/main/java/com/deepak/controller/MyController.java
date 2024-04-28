package com.deepak.controller;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deepak.service.ContentService;
import com.deepak.service.Post;

import reactor.core.publisher.Mono;

@RestController
public class MyController {

	private static final Logger LOGGER = Logger.getLogger(MyController.class.getName());

	private ContentService contentService;

	MyController(ContentService contentService) {
		this.contentService = contentService;
	}

	@GetMapping("/posts/{id}")
	public String getPost(@PathVariable int id) {
		return contentService.getPost(id);
	}
}

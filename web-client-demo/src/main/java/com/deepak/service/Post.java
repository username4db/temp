package com.deepak.service;

import lombok.Builder;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
public class Post {

	Integer userId;

	Integer id;

	String title;

	String body;

	@Override
	public String toString() {
		return "Post [userId=" + userId + ", id=" + id + ", title=" + title + ", body=" + body + "]";
	}
}

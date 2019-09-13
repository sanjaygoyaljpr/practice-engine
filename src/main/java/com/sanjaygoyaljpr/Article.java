package com.sanjaygoyaljpr;

import java.util.List;

public class Article {

	private String title;
	private String author;
	private List<String> tags;
	
	private int wordCount;

	public Article(String title, String author, List<String> tags) {
		this.title = title;
		this.author = author;
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public List<String> getTags() {
		return tags;
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}
}

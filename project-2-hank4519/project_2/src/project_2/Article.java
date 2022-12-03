package project_2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
	private Source source; 
	private String author; 
	private String title; 
	private String description; 
	private String url; 
	private String urlToImage; 
	private String publishedAt; 
	private String content; 
	
	@JsonCreator
	private Article(@JsonProperty("source") Source source, 
			@JsonProperty("author") String author,
			@JsonProperty("title") String title, 
			@JsonProperty("description") String description, 
			@JsonProperty("url") String url,
			@JsonProperty("urlToImage") String urlToImage, 
			@JsonProperty("publishedAt") String publishedAt, 
			@JsonProperty("content") String content) {
		this.source = source; 
		this.author = author; 
		this.title = title; 
		this.description = description; 
		this.url = url; 
		this.urlToImage = urlToImage; 
		this.publishedAt = publishedAt; 
		this.content = content; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Title: " + this.title + "\n");
		sb.append("Description: " + this.description + "\n");
		sb.append("PublishedAt: " + this.publishedAt + "\n");
		sb.append("Url: " + this.url + "\n");
		return sb.toString();
	}
	
	String getTitle() { 
		return title; 
	}
	
	String getDescription() { 
		return description; 
	}
	
	String getPublishedAt() {
		return publishedAt; 
	}
	
	String getUrl() { 
		return url; 
	}
	
	
}

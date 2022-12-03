package project_2;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class News {
	private String status; 
	private int totalResults; 
	private List<Article> articles; 
	
	@JsonCreator 
	News(@JsonProperty("status") String status, 
			@JsonProperty("totalResults") int totalResults,
			@JsonProperty("articles") List<Article> articles) {
		this.status = status; 
		this.totalResults = totalResults; 
		this.articles = articles; 
	}
	
	void setArticles(List <Article> articles) { 
		this.articles = articles; 
	} 
	
	News(List <Article> articles){ 
		this.articles = articles; 
		this.status = "N/A"; 
		this.totalResults = 1; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Article article : this.articles) {
			sb.append(article.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	List<Article> getArticles(){ 
		return articles; 
	}
	
	String getStatus(){ 
		return status; 
	}
	
	int getTotalResults() { 
		return totalResults; 
	}
	
	public boolean equals(Object o) { 
		 if (o == null) { 
			 return false; 
		 }
		 if (o.getClass() != this.getClass()) { 
			 return false; 
		 }
		 final News other = (News) o; 
		 return this.articles.equals(other.articles) 
				 && this.status == other.status
				 && this.totalResults == other.totalResults; 
				 
	}
}

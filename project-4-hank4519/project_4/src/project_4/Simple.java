package project_4;

import java.util.List;

public class Simple extends News {

	//private List<Article> articles; 
	
	Simple(List<Article> articles) {
		super(articles);	
	}
	
	List<Article> getArticles(){ 
		return super.getArticles();  
	}

}

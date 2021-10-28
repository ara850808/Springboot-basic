package com.articleservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import com.article.model.Article;

@Service
public class ArticleService {
	private static List<Article> articles = new ArrayList<Article>();
	private static int articleCount = 3;
	
	static {
        articles.add(new Article(1, "Good book1", "So good", "Donguk", new Date()));
        articles.add(new Article(2, "Good book2", "So good", "Donguk", new Date()));
        articles.add(new Article(3, "Good book3", "So good", "Donguk", new Date()));
    }
	
	public List<Article> retrieveArticles(String user) {
		List<Article> filteredArticles = new ArrayList<Article>();
		for(Article article : articles) {
			if(article.getUser().equals(user)) {
				filteredArticles.add(article);
			}
		}
		return filteredArticles;
	}
	
	public void addArticle(String title, String desc, String name, Date targetDate) {
		articles.add(new Article(++articleCount, title, desc, name, targetDate));
	}
	
	public void deleteArticle(int id) {
		Iterator<Article> iterator = articles.iterator();
		while(iterator.hasNext()) {
			Article article = iterator.next();
			if(article.getId() == id) {
				iterator.remove();
			}
		}
	}
	
}

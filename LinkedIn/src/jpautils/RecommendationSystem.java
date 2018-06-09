package jpautils;

import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import model.Article;
import model.Listing;

public class RecommendationSystem {
	
	private int NEAREST_NEIGHBORS = 10;
	private int NUM_OF_RECOMMENDATIONS = 6;
	
	/* for a given userID returns a list of the userIDs of his connected-with K - Nearest Neighbors */
	private List<String> getConnectedKNearestNeighbors(String userID) {
		List<String> kNearestNeighbors = new ArrayList<>();
		
		/* TODO */
		
		return kNearestNeighbors;
	}
	
	/* for a given userID returns a list of the userIDs of his not-connected-with K - Nearest Neighbors */
	private List<String> getNotConnectedKNearestNeighbors(String userID) {
		List<String> kNearestNeighbors = new ArrayList<>();
		
		/* TODO */
		
		return kNearestNeighbors;
	}
	
	/* get the recommended listings for a specific user, based on his K-Nearest Neighbors */
	private List<Listing> getListingRecommendations(String userID, List<String> kNearestNeighbors) {
		ListingDAO listingDAO = new ListingDAOImpl();
		
		List<Listing> recommendations = new ArrayList<>();
		
		int counter = 0;
		for (String neighborID : kNearestNeighbors) {
			List<Listing> listings = listingDAO.getUserListings(Long.parseLong(neighborID));
			
			for (Listing l : listings) {
				recommendations.add(l);
				counter++;
				
				if(counter >= NUM_OF_RECOMMENDATIONS)
					break;
			}
		}
		
		return recommendations;
	}
	
	/* get the recommended articles for a specific user, based on his K-Nearest Neighbors */
	private List<Article> getArticleRecommendations(String userID, List<String> kNearestNeighbors) {
		ArticleDAO articleDAO = new ArticleDAOImpl();
		
		List<Article> recommendations = new ArrayList<>();
		
		int counter = 0;
		for (String neighborID : kNearestNeighbors) {
			List<Article> articles = articleDAO.getUserArticles(Long.parseLong(neighborID));
			
			for (Article a : articles) {
				recommendations.add(a);
				counter++;
				
				if(counter >= NUM_OF_RECOMMENDATIONS)
					break;
			}
		}
		
		return recommendations;
	}
	
	/* for a given userID return listing recommendations */
	public List<Listing> getConnectedRecommendedListings(String userID) {
		List<String> kNearestNeighbors = getConnectedKNearestNeighbors(userID);
		List<Listing> listings = getListingRecommendations(userID, kNearestNeighbors);
		
		return listings;
	}
	
	public List<Listing> getNotConnectedRecommendedListings(String userID) {
		List<String> kNearestNeighbors = getNotConnectedKNearestNeighbors(userID);
		List<Listing> listings = getListingRecommendations(userID, kNearestNeighbors);
		
		return listings;
	}
	
	/* for a given userID return article recommendations */
	public List<Article> getConnectedRecommendedArticles(String userID) {
		List<String> kNearestNeighbors = getConnectedKNearestNeighbors(userID);
		List<Article> articles = getArticleRecommendations(userID, kNearestNeighbors);
		
		return articles;
	}
	
	public List<Article> getNotConnectedRecommendedArticles(String userID) {
		List<String> kNearestNeighbors = getNotConnectedKNearestNeighbors(userID);
		List<Article> articles = getArticleRecommendations(userID, kNearestNeighbors);
		
		return articles;
	}
	
}

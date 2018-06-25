package jpautils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import dao.ArticleDAO;
import dao.ArticleDAOImpl;
import dao.CommentDAO;
import dao.CommentDAOImpl;
import dao.ConnectionDAO;
import dao.ConnectionDAOImpl;
import dao.LikeArticleDAO;
import dao.LikeArticleDAOImpl;
import dao.LikeListingDAO;
import dao.LikeListingDAOImpl;
import dao.ListingDAO;
import dao.ListingDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.Article;
import model.Listing;

public class RecommendationSystem {
	
	private int NEAREST_NEIGHBORS = 10;
	private int NUM_OF_RECOMMENDATIONS = 6;
	
	/* for a given userID returns a list of the userIDs of his connected-with K - Nearest Neighbors */
	private List<String> getConnectedKNearestNeighbors(String userID) {
		List<String> kNearestNeighbors = new ArrayList<>();
		
		ConnectionDAO connectionDAO = new ConnectionDAOImpl();
		CommentDAO commentDAO = new CommentDAOImpl();
		LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
		LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
		
		List<String> connectedUserIDs = connectionDAO.getConnectedUsersIDs(Long.parseLong(userID));
		List<String> commentedArticleIDs = commentDAO.getUserCommentsArticleIDs(Long.parseLong(userID));
		List<String> likedArticleIDs = likeArticleDAO.getUserLikeArticlesArticleIDs(Long.parseLong(userID));
		List<String> likedListingIDs = likeListingDAO.getUserLikeListingsListingIDs(Long.parseLong(userID));
		
		/* map to a userID the number of its similarities with the current user */
		Map<String, Integer> similarityMapConnections = new TreeMap<>();
		Map<String, Integer> similarityMapCommentedArticles = new TreeMap<>();
		Map<String, Integer> similarityMapLikedArticles = new TreeMap<>();
		Map<String, Integer> similarityMapLikedListings = new TreeMap<>();
		
		for (String uID : connectedUserIDs) {
			List<String> connections = connectionDAO.getConnectedUsersIDs(Long.parseLong(uID));
			for (String id : connections) {
				if (connectedUserIDs.contains(id)) {
					if (similarityMapConnections.containsKey(uID))
						similarityMapConnections.put(uID, similarityMapConnections.get(uID) + 1);
					else
						similarityMapConnections.put(uID, 1);
				}
			}
		}
		
		for (String uID : connectedUserIDs) {
			List<String> commentedArticles = commentDAO.getUserCommentsArticleIDs(Long.parseLong(uID));
			for (String id : commentedArticles) {
				if (commentedArticleIDs.contains(id)) {
					if (similarityMapCommentedArticles.containsKey(uID))
						similarityMapCommentedArticles.put(uID, similarityMapCommentedArticles.get(uID) + 1);
					else
						similarityMapCommentedArticles.put(uID, 1);
				}
			}
		}
		
		for (String uID : connectedUserIDs) {
			List<String> likedArticles = likeArticleDAO.getUserLikeArticlesArticleIDs(Long.parseLong(uID));
			for (String id : likedArticles) {
				if (likedArticleIDs.contains(id)) {
					if (similarityMapLikedArticles.containsKey(uID))
						similarityMapLikedArticles.put(uID, similarityMapLikedArticles.get(uID) + 1);
					else
						similarityMapLikedArticles.put(uID, 1);
				}
			}
		}
		
		for (String uID : connectedUserIDs) {
			List<String> likedListings = likeListingDAO.getUserLikeListingsListingIDs(Long.parseLong(uID));
			for (String id : likedListings) {
				if (likedListingIDs.contains(id)) {
					if (similarityMapLikedListings.containsKey(uID))
						similarityMapLikedListings.put(uID, similarityMapLikedListings.get(uID) + 1);
					else
						similarityMapLikedListings.put(uID, 1);
				}
			}
		}
		
		Map<String, Integer> similarityMapSum = new TreeMap<>();
		
		for (String uID : connectedUserIDs)
			similarityMapSum.put(uID, 0);
		
		for (String uID : similarityMapConnections.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapConnections.get(uID));
		
		for (String uID : similarityMapCommentedArticles.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapCommentedArticles.get(uID));
		
		for (String uID : similarityMapLikedArticles.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapLikedArticles.get(uID));
		
		for (String uID : similarityMapLikedListings.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapLikedListings.get(uID));
		
		Map<String, Integer> similarityMapSumSorted = sortByValue(similarityMapSum);
		
		// create an arraylist initialized by the keys of the map
		ArrayList<String> userIDs = new ArrayList<String>(similarityMapSumSorted.keySet());
		
		// kNearestNeighbors returns empty
		if ( userIDs.size() == 0 )
			return kNearestNeighbors;

		if (userIDs.size() > NEAREST_NEIGHBORS)
			for (int i = userIDs.size()-1; i >= userIDs.size() - NEAREST_NEIGHBORS; i--)
				kNearestNeighbors.add(userIDs.get(i));
		else
			for (int i = userIDs.size()-1; i >= 0; i--)
				kNearestNeighbors.add(userIDs.get(i));
		
		return kNearestNeighbors;
	}
	
	/* for a given userID returns a list of the userIDs of his not-connected-with K - Nearest Neighbors */
	private List<String> getNotConnectedKNearestNeighbors(String userID) {
List<String> kNearestNeighbors = new ArrayList<>();
		
		ConnectionDAO connectionDAO = new ConnectionDAOImpl();
		CommentDAO commentDAO = new CommentDAOImpl();
		LikeArticleDAO likeArticleDAO = new LikeArticleDAOImpl();
		LikeListingDAO likeListingDAO = new LikeListingDAOImpl();
		UserDAO userDAO = new UserDAOImpl();
		
		List<String> allUserIDs = userDAO.listUserIDs();
		List<String> connectedUserIDs = connectionDAO.getConnectedUsersIDs(Long.parseLong(userID));
		List<String> commentedArticleIDs = commentDAO.getUserCommentsArticleIDs(Long.parseLong(userID));
		List<String> likedArticleIDs = likeArticleDAO.getUserLikeArticlesArticleIDs(Long.parseLong(userID));
		List<String> likedListingIDs = likeListingDAO.getUserLikeListingsListingIDs(Long.parseLong(userID));
		
		List<String> notConnectedUserIDs = new ArrayList<String>();
		for (String uID : allUserIDs)
			if (!connectedUserIDs.contains(uID))
				if( !uID.equals(userID) )
					notConnectedUserIDs.add(uID);
		
		/* map to a userID the number of its similarities with the current user */
		Map<String, Integer> similarityMapConnections = new TreeMap<>();
		Map<String, Integer> similarityMapCommentedArticles = new TreeMap<>();
		Map<String, Integer> similarityMapLikedArticles = new TreeMap<>();
		Map<String, Integer> similarityMapLikedListings = new TreeMap<>();
		
		for (String uID : notConnectedUserIDs) {
			List<String> connections = connectionDAO.getConnectedUsersIDs(Long.parseLong(uID));
			for (String id : connections) {
				if (connectedUserIDs.contains(id)) {
					if (similarityMapConnections.containsKey(uID))
						similarityMapConnections.put(uID, similarityMapConnections.get(uID) + 1);
					else
						similarityMapConnections.put(uID, 1);
				}
			}
		}
		
		for (String uID : notConnectedUserIDs) {
			List<String> commentedArticles = commentDAO.getUserCommentsArticleIDs(Long.parseLong(uID));
			for (String id : commentedArticles) {
				if (commentedArticleIDs.contains(id)) {
					if (similarityMapCommentedArticles.containsKey(uID))
						similarityMapCommentedArticles.put(uID, similarityMapCommentedArticles.get(uID) + 1);
					else
						similarityMapCommentedArticles.put(uID, 1);
				}
			}
		}
		
		for (String uID : notConnectedUserIDs) {
			List<String> likedArticles = likeArticleDAO.getUserLikeArticlesArticleIDs(Long.parseLong(uID));
			for (String id : likedArticles) {
				if (likedArticleIDs.contains(id)) {
					if (similarityMapLikedArticles.containsKey(uID))
						similarityMapLikedArticles.put(uID, similarityMapLikedArticles.get(uID) + 1);
					else
						similarityMapLikedArticles.put(uID, 1);
				}
			}
		}
		
		for (String uID : notConnectedUserIDs) {
			List<String> likedListings = likeListingDAO.getUserLikeListingsListingIDs(Long.parseLong(uID));
			for (String id : likedListings) {
				if (likedListingIDs.contains(id)) {
					if (similarityMapLikedListings.containsKey(uID))
						similarityMapLikedListings.put(uID, similarityMapLikedListings.get(uID) + 1);
					else
						similarityMapLikedListings.put(uID, 1);
				}
			}
		}
		
		Map<String, Integer> similarityMapSum = new TreeMap<>();
		
		for (String uID : notConnectedUserIDs)
			similarityMapSum.put(uID, 0);
		
		for (String uID : similarityMapConnections.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapConnections.get(uID));
		
		for (String uID : similarityMapCommentedArticles.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapCommentedArticles.get(uID));
		
		for (String uID : similarityMapLikedArticles.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapLikedArticles.get(uID));
		
		for (String uID : similarityMapLikedListings.keySet())
			similarityMapSum.put(uID, similarityMapSum.get(uID) + similarityMapLikedListings.get(uID));
		
		Map<String, Integer> similarityMapSumSorted = sortByValue(similarityMapSum);
		
		// create an arraylist initialized by the keys of the map
		ArrayList<String> userIDs = new ArrayList<String>(similarityMapSumSorted.keySet());
		
		// kNearestNeighbors returns empty
		if ( userIDs.size() == 0 )
			return kNearestNeighbors;
		
		if (userIDs.size() > NEAREST_NEIGHBORS)
			for (int i = userIDs.size()-1; i >= userIDs.size() - NEAREST_NEIGHBORS; i--)
				kNearestNeighbors.add(userIDs.get(i));
		else
			for (int i = userIDs.size()-1; i >= 0; i--)
				kNearestNeighbors.add(userIDs.get(i));
		
		return kNearestNeighbors;
	}
	
	/* sort a Java Map, by value-ascending order */
	/* source: https://www.mkyong.com/java/how-to-sort-a-map-in-java/ */
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        /*
        //classic iterator example
        for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<String, Integer> entry = it.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }*/


        return sortedMap;
    }
	
	/* get the recommended listings for a specific user, based on his K-Nearest Neighbors */
	private List<Listing> getListingRecommendations(String userID, List<String> kNearestNeighbors) {
		ListingDAO listingDAO = new ListingDAOImpl();
		
		List<Listing> recommendations = new ArrayList<>();
		
		int counter = 0;
		for (String neighborID : kNearestNeighbors) {
			List<Listing> listings = listingDAO.getUserListings(Long.parseLong(neighborID));
			
			if( listings != null ) {
				
				for (Listing l : listings) {
					recommendations.add(l);
					counter++;
				
					if(counter >= NUM_OF_RECOMMENDATIONS)
						break;
				}
				
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

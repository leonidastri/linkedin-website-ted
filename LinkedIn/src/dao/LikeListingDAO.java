package dao;

import java.util.List;

import model.LikeListing;

public interface LikeListingDAO {

    public List<LikeListing> list();

	public void create(LikeListing likeListing);
	
	public List<LikeListing> getUserLikeListings(Long userID);
	
	public List<String> getLikeListingUserIDs(Long listingID);
	
	public List<String> getUserLikeListingsListingIDs(Long userID);

	public LikeListing find(Long id1, Long id2);
	
	List<LikeListing> getLikesOfUserListings(Long listingID);
	
	public void delete(Long id1, Long id2);
}

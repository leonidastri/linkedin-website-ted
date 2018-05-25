package dao;

import java.util.List;

import model.LikeListing;

public interface LikeListingDAO {

    public List<LikeListing> list();

	public void create(LikeListing likeListing);
	
	public List<LikeListing> getUserLikeListings(Long id);

}

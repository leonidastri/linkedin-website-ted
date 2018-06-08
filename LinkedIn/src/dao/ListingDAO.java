package dao;

import java.util.List;

import model.Listing;

public interface ListingDAO {
	
	public Listing find(Long id);

    public List<Listing> list();

	public void create(Listing listing);
	
	public List<Listing> getUserListings(Long id);
	
	public List<Listing> getOtherUsersListings(Long id);
	
	public List<Listing> getConnectedUsersListings(Long id);
	
	public List<Listing> getNotConnectedUsersListings(Long id);
	
}

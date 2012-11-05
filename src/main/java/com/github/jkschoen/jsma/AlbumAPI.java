package com.github.jkschoen.jsma;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Album;
import com.github.jkschoen.jsma.model.AlbumStats;
import com.github.jkschoen.jsma.model.Comment;
import com.github.jkschoen.jsma.response.AlbumCommentResponse;
import com.github.jkschoen.jsma.response.AlbumCommentsResponse;
import com.github.jkschoen.jsma.response.AlbumResponse;
import com.github.jkschoen.jsma.response.AlbumStatsResponse;
import com.github.jkschoen.jsma.response.AlbumsResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class AlbumAPI {
	static final Logger logger = LoggerFactory.getLogger(AlbumAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected AlbumAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Applies a watermark to the images of an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  applyWatermark(albumId, watermarkId, false, false)
	 *  
	 * @param albumId (required) The id for a specific album.
	 * @param watermarkId (required) The id for a specific watermark.
	 * @return returns true if watermark was set
	 * @throws SmugMugException
	 */
	public boolean applyWatermark(int albumId, int watermarkId) throws SmugMugException {
		return applyWatermark(albumId, watermarkId, false, false);
	}
	
	/**
	 * Applies a watermark to the images of an album.
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param watermarkId (required) The id for a specific watermark.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return returns true if watermark was set
	 * @throws SmugMugException
	 */
	public boolean applyWatermark(int albumId, int watermarkId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("applyWatermark() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		params.put("WatermarkID", Integer.toString(watermarkId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.applyWatermark", params, null, pretty, false, strict, false);
		logger.debug("applyWatermark() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Browse to an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  browse(albumId, albumKey, null, false)
	 *  
	 * Confession time, I am not sure what this actually does on the SmugMug side.
	 * If you do, feel free to update this javadoc, or create an example in the Test
	 * package to show me. 
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @param password The password for the album.
	 * @param pretty return formatted JSON that is easier to read
	 * @return true if successfully browsed to album
	 * @throws SmugMugException
	 */
	public boolean browse(int albumId, String albumKey) throws SmugMugException {
		return browse(albumId, albumKey, null, false);
	}
	
	//TODO: Find out what the use case for browse is.
	/**
	 * Browse to an album.
	 * 
	 * Confession time, I am not sure what this actually does on the SmugMug side.
	 * If you do, feel free to update this javadoc, or create an example in the Test
	 * package to show me. 
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @param password The password for the album.
	 * @param pretty return formatted JSON that is easier to read
	 * @return true if successfully browsed to album
	 * @throws SmugMugException
	 */
	public boolean browse(int albumId, String albumKey, String password, boolean pretty) throws SmugMugException {
		logger.debug("browse() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		params.put("AlbumKey", albumKey);
		if(password != null){
			params.put("Password", password);
		}
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.browse", params, null, pretty, false, false, false);
		logger.debug("browse() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Change the settings of an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  changeSettings(album, null, false, null, false, false)
	 *  
	 * @param album the album details to be changed
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album changeSettings(Album album) throws SmugMugException {
		return changeSettings(album, null, false, null, false, false);
	}
	
	/**
	 * Change the settings of an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  changeSettings(album, albumTemplateId, false, null, false, false)
	 *  
	 * @param album the album details to be changed
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album changeSettings(Album album, int albumTemplateId) throws SmugMugException {
		return changeSettings(album, albumTemplateId, false, null, false, false);
	}
	
	/**
	 * Change the settings of an album.
	 * 
	 * @param album the album details to be changed
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @param unique Create an album if one of the same name doesn't already exist in the current hierarchy.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album changeSettings(Album album, Integer albumTemplateId, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("changeSettings() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(albumTemplateId != null){
			params.put("AlbumTemplateID", albumTemplateId.toString());
		}
		if(unique){
			params.put("Unique", "true");
		}
		this.setAlbumParameters(params, album);		
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.changeSettings", params, extras, pretty, false, strict, false);
		logger.debug("changeSettings() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return album;
	}
	
	/**
	 * Add a comment to an album.
	 * 
	 * @param comment The comment to be added.
	 * @param albumId The id for a specific album.
	 * @param albumKey The key for a specific album.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return the added comment
	 */
	public Comment commentAdd(Comment comment, int albumId, String albumKey, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("commentAdd() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Integer.toString(albumId));
		params.put("AlbumKey" , albumKey);
		params.put("Text", comment.getText());
		if(comment.getRating() != null){
			params.put("Rating", comment.getRating().toString());
		}
		
		AlbumCommentResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumCommentResponse.class, "smugmug.albums.comment.add", params, extras, pretty, false, strict, false);
		logger.debug("commentAdd() result: "+(requestToken == null ? "null" : requestToken.toString()));
		comment.setId(requestToken.getComment().getId());
		return comment;
	}
	
	/**
	 * Retrieve a list of comments for an album.
	 * 
	 * @param albumId The id for a specific album.
	 * @param albumKey The key for a specific album.
	 * @param password The password for the album.
	 * @param sitePassword The site password for a specific user.
	 * @param lastUpdated Return results where LastUpdated is after
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Comment> commentGet(int albumId, String albumKey, String password, String sitePassword, Date lastUpdated, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("commentGet() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Integer.toString(albumId));
		params.put("AlbumKey" , albumKey);
		
		if(password != null){
			params.put("Password", password);
		}
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		if(lastUpdated != null){
			params.put("LastUpdated", Long.toString(lastUpdated.getTime()));
		}
		
		AlbumCommentsResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumCommentsResponse.class, "smugmug.albums.comment.get", params, null, pretty, false, strict, false);
		logger.debug("commentGet() result: "+(requestToken == null ? "null" : requestToken.toString()));
		
		return requestToken.getComments();
	}
	
	/**
	 * Create an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  create(album, null, false, null, false, false)
	 *  
	 * @param album the album details to be created
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album create(Album album) throws SmugMugException {
		return create(album, null, false, null, false, false);
	}
	
	/**
	 * Create an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  create(album, albumTemplateId, false, null, false, false)
	 *  
	 * @param album the album details to be created
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album create(Album album, int albumTemplateId) throws SmugMugException {
		return create(album, albumTemplateId, false, null, false, false);
	}
	
	/**
	 * Create an album.
	 * 
	 * @param album the album details to be created
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @param unique Create an album if one of the same name doesn't already exist in the current hierarchy.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return the created album
	 * @throws SmugMugException
	 */
	public Album create(Album album, Integer albumTemplateId, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("create() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(albumTemplateId != null){
			params.put("AlbumTemplateID", albumTemplateId.toString());
		}
		if(unique){
			params.put("Unique", "true");
		}
		this.setAlbumParameters(params, album);		
		
		AlbumResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumResponse.class, "smugmug.albums.create", params, extras, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		album.setId(requestToken.getAlbum().getId());
		album.setKey(requestToken.getAlbum().getKey());
		return album;
	}
	
	/**
	 * Delete an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  delete (albumId, albumKey, false, false)
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @throws SmugMugException
	 */
	public boolean delete(int albumId, String albumKey) throws SmugMugException {
		return delete (albumId, albumKey, false, false);
	}
	
	/**
	 * Delete an album.
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return true if the album is deleted successfully
	 * @throws SmugMugException
	 */
	public boolean delete(int albumId, String albumKey, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		params.put("AlbumKey", albumKey);
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of albums for a given user. 
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  get(true, null, null, null, null, false, false, false, false)
	 * 
	 * @return list of albums
	 * @throws SmugMugException
	 */
	public List<Album> get() throws SmugMugException {
		return get(true, null, null, null, null, false, false, false, false);
	}
	
	
	/**
	 * Retrieve a list of albums for a given user.
	 * 
	 * @param empty return empty albums
	 * @param lastUpdated return results that where last updated after given time
	 * @param nickName The NickName for a specific user
	 * @param sitePassword The site password for a specific user.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Album> get(boolean empty, Date lastUpdated, String nickName, String sitePassword, String[] extras, boolean pretty, boolean sandboxed, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Empty", (empty ? "true" : "false"));
		if(lastUpdated != null){
			params.put("LastUpdated", Long.toString(lastUpdated.getTime()));
		}
		if(nickName != null){
			params.put("NickName", nickName);
		}
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		
		AlbumsResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumsResponse.class, "smugmug.albums.get", params, extras, pretty, sandboxed, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAlbums();
	}
	
	/**
	 * Retrieve the information for an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  getInfo(albumId, albumKey, null, null, false, false, false)
	 *  
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @return the album details
	 * @throws SmugMugException
	 */
	public Album getInfo(int albumId, String albumKey) throws SmugMugException {
		return getInfo(albumId, albumKey, null, null, false, false, false);
	}
	
	/**
	 * Retrieve the information for an album.
	 * 
	 * @param albumId (required) The id for a specific album.
	 * @param albumKey (required) The key for a specific album.
	 * @param password The password for the album.
	 * @param sitePassword The site password for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @return the album details
	 * @throws SmugMugException
	 */
	public Album getInfo(int albumId, String albumKey, String password, String sitePassword, boolean pretty, boolean sandboxed, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		params.put("AlbumKey", albumKey);
		
		if(password != null){
			params.put("Password", password);
		}
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		AlbumResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumResponse.class, "smugmug.albums.getInfo", params, null, pretty, sandboxed, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAlbum();
	}
	
	/**
	 * Retrieve the statistics for an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  getStats(albumId, month, year, false, false, false)
	 * 
	 * @param albumId The id for a specific album.
	 * @param month The month to retrieve statistics for.
	 * @param year The year to retrieve statistics for.
	 * @return
	 * @throws SmugMugException
	 */
	public AlbumStats getStats(int albumId, int month, int year) throws SmugMugException {
		return getStats(albumId, month, year, false, false, false);
	}
	
	/**
	 * Retrieve the statistics for an album.
	 * 
	 * @param albumId The id for a specific album.
	 * @param month The month to retrieve statistics for.
	 * @param year The year to retrieve statistics for.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public AlbumStats getStats(int albumId, int month, int year, boolean pretty, boolean strict, boolean heavy) throws SmugMugException {
		logger.debug("getStats() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		params.put("Month", Integer.toString(month));
		params.put("Year", Integer.toString(year));
		
		AlbumStatsResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumStatsResponse.class, "smugmug.albums.getStats", params, null, pretty, false, strict, heavy);
		logger.debug("getStats() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getStats();
	}
	
	/**
	 * Remove a watermark from the images of an album.
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  removeWatermark(albumId, false, false)
	 * 
	 * @param albumId The id for a specific album.
	 * @return true if the watermarks are removed
	 * @throws SmugMugException
	 */
	public boolean removeWatermark(int albumId) throws SmugMugException {
		return removeWatermark(albumId, false, false);
	}
	
	/**
	 * Remove a watermark from the images of an album.
	 * 
	 * @param albumId The id for a specific album.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return true if the watermarks are removed
	 * @throws SmugMugException
	 */
	public boolean removeWatermark(int albumId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("removeWatermark() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.removeWatermark", params, null, pretty, false, strict, false);
		logger.debug("removeWatermark() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Unknown!!
	 * 
	 * It uses the default values found in the API. The results of this call 
	 * is the same as making the call:
	 *  removeWatermark(albumId, false, false)
	 * 
	 * @param albumId The id for a specific album.
	 * @return 
	 * @throws SmugMugException
	 */
	public boolean reSort(int albumId) throws SmugMugException {
		return reSort(albumId, false, false);
	}
	
	/**
	 * Unknown!!
	 * 
	 * @param albumId The id for a specific album.
	 * @param prettyreturn formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean reSort(int albumId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("reSort() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Integer.toString(albumId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.reSort", params, null, pretty, false, strict, false);
		logger.debug("reSort() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	private void setAlbumParameters(Map<String, String> params, Album album){
		if(album.getBackPrinting() != null){
			params.put("Backprinting", album.getBackPrinting());
		}
		if(album.getBoutiquePackaging() != null){
			params.put("BoutiquePackaging", album.getBoutiquePackaging().toString());
		}
		if(album.getCanRank() != null){
			params.put("CanRank", (album.getCanRank() ? "true" : "false"));
		}
		if(album.getCategory() != null){
			params.put("CategoryID", album.getCategory().getId().toString());
		}
		if(album.getClean() != null){
			params.put("Clean", (album.getClean() ? "true" : "false"));
		}
		if(album.getColorCorrection() != null){
			params.put("ColorCorrection", album.getColorCorrection().toString());
		}
		if(album.getComments() != null){
			params.put("Comments", (album.getComments() ? "true" : "false"));
		}
		if(album.getCommunity() != null){
			params.put("CommunityID", album.getCommunity().getId().toString());
		}
		if(album.getDescription() != null){
			params.put("Description", album.getDescription());
		}
		if(album.getExif() != null){
			params.put("EXIF", (album.getExif() ? "true" : "false"));
		}
		if(album.getExternal() != null){
			params.put("External", (album.getExternal() ? "true" : "false"));
		}
		if(album.getFamilyEdit() != null){
			params.put("FamilyEdit", (album.getFamilyEdit() ? "true" : "false"));
		}
		if(album.getFilenames() != null){
			params.put("Filenames", (album.getFilenames() ? "true" : "false"));
		}
		if(album.getFriendEdit() != null){
			params.put("FriendEdit", (album.getFriendEdit() ? "true" : "false"));
		}
		if(album.getGeography() != null){
			params.put("Geography", (album.getGeography() ? "true" : "false"));
		}
		if(album.getHeader() != null){
			params.put("Header", (album.getHeader() ? "true" : "false"));
		}
		if(album.getHideOwner() != null){
			params.put("HideOwner", (album.getHideOwner() ? "true" : "false"));
		}
		if(album.getInterceptShipping() != null){
			params.put("InterceptShipping", album.getInterceptShipping().toString());
		}
		if(album.getKeywords() != null){
			params.put("Keywords", album.getKeywords());
		}
		if(album.getLarges() != null){
			params.put("Larges", (album.getLarges() ? "true" : "false"));
		}
		if(album.getNiceName() != null){
			params.put("NiceName", album.getNiceName());
		}
		if(album.getOriginals() != null){
			params.put("Originals", (album.getOriginals() ? "true" : "false"));
		}
		if(album.getPackagingBranding() != null){
			params.put("PackagingBranding", (album.getPackagingBranding() ? "true" : "false"));
		}
		if(album.getPassword() != null){
			params.put("Password", album.getPassword());
		}
		if(album.getPasswordHint() != null){
			params.put("PasswordHint", album.getPasswordHint());
		}
		if(album.getPosition() != null){
			params.put("Position", album.getPosition().toString());
		}
		if(album.getPrintable() != null){
			params.put("Printable", (album.getPrintable() ? "true" : "false"));
		}
		if(album.getPrintmark() != null){
			params.put("PrintmarkID", album.getPrintmark().getId().toString());
		}
		if(album.getProofDays() != null){
			params.put("ProofDays", album.getProofDays().toString());
		}
		if(album.getProtectedRightClick() != null){
			params.put("Protected", (album.getProtectedRightClick() ? "true" : "false"));
		}
		if(album.getPublicAlbum() != null){
			params.put("Public", (album.getPublicAlbum() ? "true" : "false"));
		}
		if(album.getShare() != null){
			params.put("Share", (album.getShare() ? "true" : "false"));
		}
		if(album.getSmugSearchable() != null){
			params.put("SmugSearchable", (album.getSmugSearchable() ? "true" : "false"));
		}
		if(album.getSortDirection() != null){
			params.put("SortDirection", (album.getSortDirection() ? "true" : "false"));
		}
		if(album.getSortMethod() != null){
			params.put("SortMethod", album.getSortMethod());
		}
		if(album.getSquareThumbs() != null){
			params.put("SquareThumbs", (album.getSquareThumbs() ? "true" : "false"));
		}
		if(album.getSubCategory() != null){
			params.put("SubCategoryID", album.getSubCategory().getId().toString());
		}
		if(album.getTemplate() != null){
			params.put("TemplateID", album.getTemplate().getId().toString());
		}
		if(album.getTheme() != null){
			params.put("ThemeID", album.getTheme().getId().toString());
		}
		if(album.getTitle() != null){
			params.put("Title", album.getTitle());
		}
		if(album.getUnsharpAmount() != null){
			params.put("UnsharpAmount", album.getUnsharpAmount().toString());
		}
		if(album.getUnsharpRadius() != null){
			params.put("UnsharpRadius", album.getUnsharpRadius().toString());
		}
		if(album.getUnsharpSigma() != null){
			params.put("UnsharpSigma", album.getUnsharpSigma().toString());
		}
		if(album.getUnsharpThreshold() != null){
			params.put("UnsharpThreshold", album.getUnsharpThreshold().toString());
		}
		if(album.getUploadKey() != null){
			params.put("UploadKey", album.getUploadKey());
		}
		if(album.getWatermark() != null){
			params.put("WatermarkID", album.getWatermark().getId().toString());
		}
		if(album.getWatermarking() != null){
			params.put("Watermarking", (album.getWatermarking() ? "true" : "false"));
		}
		if(album.getWorldSearchable() != null){
			params.put("WorldSearchable", (album.getWorldSearchable() ? "true" : "false"));
		}
		if(album.getX2Larges() != null){
			params.put("X2Larges", (album.getX2Larges() ? "true" : "false"));
		}
		if(album.getX3Larges() != null){
			params.put("X3Larges", (album.getX3Larges() ? "true" : "false"));
		}
		if(album.getxLarges() != null){
			params.put("XLarges", (album.getxLarges() ? "true" : "false"));
		}
	}
}

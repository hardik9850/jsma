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
import com.github.jkschoen.jsma.response.AlbumCommentsResponse;
import com.github.jkschoen.jsma.response.AlbumResponse;
import com.github.jkschoen.jsma.response.AlbumStatsResponse;
import com.github.jkschoen.jsma.response.AlbumsResponse;
import com.github.jkschoen.jsma.response.CommentResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class AlbumAPI extends AlbumBaseAPI{
	static final Logger logger = LoggerFactory.getLogger(AlbumAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected AlbumAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
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
	public boolean applyWatermark(long albumId, long watermarkId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("applyWatermark() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
		params.put("WatermarkID", Long.toString(watermarkId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.applyWatermark", params, null, pretty, false, strict, false);
		logger.debug("applyWatermark() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
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
	public boolean browse(long albumId, String albumKey, String password, boolean pretty) throws SmugMugException {
		logger.debug("browse() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
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
	 * <ul>
	 *   <li>AlbumID</li>
	 *   <li>AlbumTemplateName</li>
	 *   <li>Backprinting (Pro accounts only)</li>
	 *   <li>CanRank</li>
	 *   <li>Clean</li>
	 *   <li>Comments</li>
	 *   <li>CommunityID</li>
	 *   <li>EXIF</li>
	 *   <li>External</li>
	 *   <li>FamilyEdit</li>
	 *   <li>Filenames</li>
	 *   <li>FriendEdit</li>
	 *   <li>Geography</li>
	 *   <li>Header (Power & Pro accounts only)</li>
	 *   <li>HideOwner</li>
	 *   <li>InterceptShipping (Pro accounts only)</li>
	 *   <li>Larges (Pro accounts only)</li>
	 *   <li>Originals</li>
	 *   <li>PackagingBranding (Pro accounts only)</li>
	 *   <li>Password</li>
	 *   <li>PasswordHint</li>
	 *   <li>Printable</li>
	 *   <li>PrintmarkID (Pro accounts only)</li>
	 *   <li>ProofDays (Pro accounts only)</li>
	 *   <li>Protected</li>
	 *   <li>Public</li>
	 *   <li>Share</li>
	 *   <li>SmugSearchable</li>
	 *   <li>SortDirection</li>
	 *   <li>SortMethod</li>
	 *   <li>SquareThumbs</li>
	 *   <li>TemplateID</li>
	 *   <li>UnsharpAmount (Power & Pro accounts only)</li>
	 *   <li>UnsharpRadius (Power & Pro accounts only)</li>
	 *   <li>UnsharpSigma (Power & Pro accounts only)</li>
	 *   <li>UnsharpThreshold (Power & Pro accounts only)</li>
	 *   <li>WatermarkID (Pro accounts only)</li>
	 *   <li>Watermarking (Pro accounts only)</li>
	 *   <li>WorldSearchable</li>
	 *   <li>X2Larges</li>
	 *   <li>X3Larges</li>
	 *   <li>XLarges (Pro accounts only)</li>
	 * </ul>
	 * 
	 * @param album the album details to be changed
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @param unique Create an album if one of the same name doesn't already exist in the current hierarchy.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return 
	 * @throws SmugMugException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Album changeSettings(Album album, Long albumTemplateId, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		logger.debug("changeSettings() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(albumTemplateId != null){
			params.put("AlbumID", albumTemplateId.toString());
		}
		if(unique){
			params.put("Unique", "true");
		}
		this.setAlbumParameters(params, album);		
		
		AlbumResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumResponse.class, "smugmug.albums.changeSettings", params, extras, pretty, false, strict, false);
		logger.debug("changeSettings() result: "+(requestToken == null ? "null" : requestToken.toString()));
		album.setKey(requestToken.getAlbum().getKey());
		if(extras != null){
			this.setExtras(album, requestToken.getAlbum(), extras);
		}
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
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Comment commentAdd(Comment comment, long albumId, String albumKey, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("commentAdd() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Long.toString(albumId));
		params.put("AlbumKey" , albumKey);
		params.put("Text", comment.getText());
		if(comment.getRating() != null){
			params.put("Rating", comment.getRating().toString());
		}
		
		CommentResponse requestToken = SMResponse.callMethod(this.smugmug,CommentResponse.class, "smugmug.albums.comment.add", params, extras, pretty, false, strict, false);
		logger.debug("commentAdd() result: "+(requestToken == null ? "null" : requestToken.toString()));
		comment.setId(requestToken.getComment().getId());
		this.setExtras(comment, requestToken.getComment(), extras);
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
	public List<Comment> commentGet(long albumId, String albumKey, String password, String sitePassword, Date lastUpdated, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("commentGet() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Long.toString(albumId));
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
		
		return requestToken.getAlbum().getComments();
	}
	
	/**
	 * Create an album.
	 * 
	 * <ul>
	 *   <li>AlbumID</li>
	 *   <li>AlbumTemplateName</li>
	 *   <li>Backprinting (Pro accounts only)</li>
	 *   <li>CanRank</li>
	 *   <li>Clean</li>
	 *   <li>Comments</li>
	 *   <li>CommunityID</li>
	 *   <li>EXIF</li>
	 *   <li>External</li>
	 *   <li>FamilyEdit</li>
	 *   <li>Filenames</li>
	 *   <li>FriendEdit</li>
	 *   <li>Geography</li>
	 *   <li>Header (Power & Pro accounts only)</li>
	 *   <li>HideOwner</li>
	 *   <li>InterceptShipping (Pro accounts only)</li>
	 *   <li>Larges (Pro accounts only)</li>
	 *   <li>Originals</li>
	 *   <li>PackagingBranding (Pro accounts only)</li>
	 *   <li>Password</li>
	 *   <li>PasswordHint</li>
	 *   <li>Printable</li>
	 *   <li>PrintmarkID (Pro accounts only)</li>
	 *   <li>ProofDays (Pro accounts only)</li>
	 *   <li>Protected</li>
	 *   <li>Public</li>
	 *   <li>Share</li>
	 *   <li>SmugSearchable</li>
	 *   <li>SortDirection</li>
	 *   <li>SortMethod</li>
	 *   <li>SquareThumbs</li>
	 *   <li>TemplateID</li>
	 *   <li>UnsharpAmount (Power & Pro accounts only)</li>
	 *   <li>UnsharpRadius (Power & Pro accounts only)</li>
	 *   <li>UnsharpSigma (Power & Pro accounts only)</li>
	 *   <li>UnsharpThreshold (Power & Pro accounts only)</li>
	 *   <li>WatermarkID (Pro accounts only)</li>
	 *   <li>Watermarking (Pro accounts only)</li>
	 *   <li>WorldSearchable</li>
	 *   <li>X2Larges</li>
	 *   <li>X3Larges</li>
	 *   <li>XLarges (Pro accounts only)</li>
	 * </ul>
	 * 
	 * @param album the album details to be created
	 * @param albumTemplateId the album template id of the template to pull settings from
	 * @param unique Create an album if one of the same name doesn't already exist in the current hierarchy.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return the created album
	 * @throws SmugMugException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Album create(Album album, Long albumTemplateId, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
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
		this.setExtras(album, requestToken.getAlbum(), extras);
		return album;
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
	public boolean delete(long albumId, String albumKey, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
		params.put("AlbumKey", albumKey);
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
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
	public Album getInfo(long albumId, String albumKey, String password, String sitePassword, boolean pretty, boolean sandboxed, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
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
	 * @param albumId The id for a specific album.
	 * @param month The month to retrieve statistics for.
	 * @param year The year to retrieve statistics for.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public AlbumStats getStats(long albumId, int month, int year, boolean pretty, boolean strict, boolean heavy) throws SmugMugException {
		logger.debug("getStats() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
		params.put("Month", Integer.toString(month));
		params.put("Year", Integer.toString(year));
		
		AlbumStatsResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumStatsResponse.class, "smugmug.albums.getStats", params, null, pretty, false, strict, heavy);
		logger.debug("getStats() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getStats();
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
	public boolean removeWatermark(long albumId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("removeWatermark() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.removeWatermark", params, null, pretty, false, strict, false);
		logger.debug("removeWatermark() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	//TODO: Find out the use case for reSort
	/**
	 * Unknown!!
	 * 
	 * @param albumId The id for a specific album.
	 * @param prettyreturn formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean reSort(long albumId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("reSort() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID", Long.toString(albumId));
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albums.reSort", params, null, pretty, false, strict, false);
		logger.debug("reSort() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}

	private void setAlbumParameters(Map<String, String> params, Album album) {
		if(album.getCategory() != null){
			params.put("CategoryID", album.getCategory().getId().toString());
		}
		if(album.getDescription() != null){
			params.put("Description", album.getDescription());
		}
		if(album.getKeywords() != null){
			params.put("Keywords", album.getKeywords());
		}
		if(album.getNiceName() != null){
			params.put("NiceName", album.getNiceName());
		}
		if(album.getSubCategory() != null){
			params.put("SubCategoryID", album.getSubCategory().getId().toString());
		}
		if(album.getTheme() != null){
			params.put("ThemeID", album.getTheme().getId().toString());
		}
		if(album.getTitle() != null){
			params.put("Title", album.getTitle());
		}
		this.setAlbumBaseParameters(params, album);
	}
}

package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Album;
import com.github.jkschoen.jsma.model.Sharegroup;
import com.github.jkschoen.jsma.response.SMResponse;
import com.github.jkschoen.jsma.response.SharegroupResponse;
import com.github.jkschoen.jsma.response.SharegroupsResponse;

public class SharegroupsAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(SharegroupsAPI.class);

	private SmugMugAPI smugmug;

	protected SharegroupsAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Add an album to a sharegroup.
	 * 
	 * @param shareGroupId (required) The id for a specific sharegroup.
	 * @param albumId (required) The id for a specific album.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean albumsAdd(long shareGroupId, long albumId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("albumsAdd() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Long.toString(albumId));
		params.put("ShareGroupID" , Long.toString(shareGroupId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.sharegroups.albums.add", params, null, pretty, false, strict, false);
		logger.debug("albumsAdd() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of albums for a sharegroup.
	 * 
	 * @param shareGroupTag (required) The tag (public id) for the sharegroup.
	 * @param password The password for the sharegroup.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Album> albumsGet(String shareGroupTag, String password, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("albumsGet() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("ShareGroupTag" , shareGroupTag);
		if(password != null){
			params.put("Password" , password);
		}
		
		SharegroupResponse requestToken = SMResponse.callMethod(this.smugmug,SharegroupResponse.class, "smugmug.sharegroups.albums.get", params, extras, pretty, false, strict, false);
		logger.debug("albumsGet() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getSharegroup().getAlbums();
	}
	
	/**
	 * Remove an album from a sharegroup.
	 * 
	 * @param shareGroupId (required) The id for a specific sharegroup.
	 * @param albumId (required) The id for a specific album.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean albumsRemove(long shareGroupId, long albumId, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("albumsRemove() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumID" , Long.toString(albumId));
		params.put("ShareGroupID" , Long.toString(shareGroupId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.sharegroups.albums.remove", params, null, pretty, false, strict, false);
		logger.debug("albumsRemove() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Browse to a sharegroup.
	 * 
	 * Confession time, I am not sure what this actually does on the SmugMug side.
	 * If you do, feel free to update this javadoc, or create an example in the Test
	 * package to show me. 
	 * 
	 * @param shareGroupTag (required) The tag (public id) for the sharegroup.
	 * @param password The password for the sharegroup.
	 * @param pretty return formatted JSON that is easier to read
	 * @return
	 * @throws SmugMugException
	 */
	public boolean browse(String shareGroupTag, String password, boolean pretty) throws SmugMugException {
		logger.debug("browse() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("ShareGroupTag", shareGroupTag);
		if(password != null){
			params.put("Password", password);
		}
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.sharegroups.browse", params, null, pretty, false, false, false);
		logger.debug("browse() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Create a sharegroup.
	 * 
	 * The following fields in the sharegroup passed in are 
	 * used to create the new sharegroup. All others will be ignored.
	 * <ul>
	 *   <li>Name (required)</li>
	 *   <li>AccessPassworded</li>
	 *   <li>Description</li>
	 *   <li>Password</li>
	 *   <li>PasswordHint</li>
	 * </ul>
	 * @param sharegroup the details of the sharegroup to be creaed
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Sharegroup create(Sharegroup sharegroup, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("create() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("Name", sharegroup.getName());
		if(sharegroup.getAccessPassworded() != null){
			params.put("AccessPassworded", sharegroup.getAccessPassworded().toString());
		}
		if(sharegroup.getDescription() != null){
			params.put("Description", sharegroup.getDescription());
		}
		if(sharegroup.getPassword() != null){
			params.put("Password", sharegroup.getPassword());
		}
		if(sharegroup.getPasswordHint() != null){
			params.put("PasswordHint", sharegroup.getPasswordHint());
		}
		SharegroupResponse requestToken = SMResponse.callMethod(this.smugmug,SharegroupResponse.class, "smugmug.sharegroups.create", params, extras, pretty, false, false, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		sharegroup.setId(requestToken.getSharegroup().getId());
		sharegroup.setTag(requestToken.getSharegroup().getTag());
		this.setExtras(sharegroup, requestToken.getSharegroup(), extras);
		return sharegroup;
	}
	
	/**
	 * Delete a sharegroup.
	 * 
	 * @param shareGroupId The id for a specific sharegroup.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(long shareGroupId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("ShareGroupID", Long.toString(shareGroupId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.sharegroups.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of sharegroups.
	 * 
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @param heavy Returns a heavy response for this method.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Sharegroup> get(String[] extras, boolean pretty, boolean strict, boolean heavy) throws SmugMugException{
		logger.debug("get() called");
		
		SharegroupsResponse requestToken = SMResponse.callMethod(this.smugmug,SharegroupsResponse.class, "smugmug.sharegroups.get", null, extras, pretty, false, strict, heavy);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getSharegroups();
	}
	
	/**
	 * Retrieve the information for a sharegroup.
	 * 
	 * @param sharegroupId The id for a specific sharegroup.
	 * @param sharegroupTag The tag (public id) for the sharegroup.
	 * @param password The password for the sharegroup.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public Sharegroup getInfo(Long sharegroupId, String sharegroupTag, String password, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("getInfo() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if (sharegroupId != null){
			params.put("ShareGroupID", sharegroupId.toString());
		}
		if (sharegroupTag != null){
			params.put("ShareGroupTag ", sharegroupTag);
		}
		if(password != null){
			params.put("Password", password);
		}
		
		SharegroupResponse requestToken = SMResponse.callMethod(this.smugmug,SharegroupResponse.class, "smugmug.sharegroups.getInfo", params, extras, pretty, false, strict, false);
		logger.debug("getInfo() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getSharegroup();
	}
	
	/**
	 * Create a modify.
	 * 
	 * The following fields in the sharegroup passed in are 
	 * used to modify the new sharegroup. All others will be ignored.
	 * <ul>
	 *   <li>Name (required)</li>
	 *   <li>AccessPassworded</li>
	 *   <li>Description</li>
	 *   <li>Password</li>
	 *   <li>PasswordHint</li>
	 * </ul>
	 * @param sharegroup the details of the sharegroup to be creaed
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Sharegroup modify(Sharegroup sharegroup, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("modify() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("Name", sharegroup.getName());
		if(sharegroup.getAccessPassworded() != null){
			params.put("AccessPassworded", sharegroup.getAccessPassworded().toString());
		}
		if(sharegroup.getDescription() != null){
			params.put("Description", sharegroup.getDescription());
		}
		if(sharegroup.getPassword() != null){
			params.put("Password", sharegroup.getPassword());
		}
		if(sharegroup.getPasswordHint() != null){
			params.put("PasswordHint", sharegroup.getPasswordHint());
		}
		SharegroupResponse requestToken = SMResponse.callMethod(this.smugmug,SharegroupResponse.class, "smugmug.sharegroups.modify", params, extras, pretty, false, false, false);
		logger.debug("modify() result: "+(requestToken == null ? "null" : requestToken.toString()));
		sharegroup.setId(requestToken.getSharegroup().getId());
		sharegroup.setTag(requestToken.getSharegroup().getTag());
		this.setExtras(sharegroup, requestToken.getSharegroup(), extras);
		return sharegroup;
	}
}

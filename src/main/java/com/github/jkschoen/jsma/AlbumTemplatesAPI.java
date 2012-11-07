package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.AlbumTemplate;
import com.github.jkschoen.jsma.response.AlbumTemplateResponse;
import com.github.jkschoen.jsma.response.AlbumTemplatesResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class AlbumTemplatesAPI extends AlbumBaseAPI{
	static final Logger logger = LoggerFactory.getLogger(AlbumTemplatesAPI.class);
	
    private SmugMugAPI smugmug;
	
	protected AlbumTemplatesAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Change the settings of an album template.
	 * 
	 * <ul>
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
	 * @param albumTemplate the album template to pull settings from
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException 
	 */
	public boolean changeSettings(AlbumTemplate albumTemplate, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("changeSettings() called");
		Map<String, String> params = new HashMap<String, String>();
		if(albumTemplate.getAlbumTemplateName() != null){
			params.put("AlbumTemplateName ", albumTemplate.getAlbumTemplateName());
		}
		this.setAlbumBaseParameters(params, albumTemplate);
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albumtemplates.changeSettings", params, null, pretty, false, strict, false);
		logger.debug("changeSettings() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}

	/**
	 * Create an album template.
	 * 
	 * @param albumTemplate the Album Template to be created
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public AlbumTemplate create(AlbumTemplate albumTemplate, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("create() called");
		Map<String, String> params = new HashMap<String, String>();
		if(albumTemplate.getAlbumTemplateName() != null){
			params.put("AlbumTemplateName ", albumTemplate.getAlbumTemplateName());
		}
		this.setAlbumBaseParameters(params, albumTemplate);
		AlbumTemplateResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumTemplateResponse.class, "smugmug.albumtemplates.create", params, null, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		albumTemplate.setId(requestToken.getAlbumTemplate().getId());
		return albumTemplate;
	}
	
	/**
	 * Delete an album template.
	 * 
	 * @param albumTemplateId The id for a specific albumtemplate.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(int albumTemplateId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("AlbumTemplateID", Integer.toString(albumTemplateId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.albumtemplates.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of album templates.
	 * 
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<AlbumTemplate> get(boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("get() called");
		
		AlbumTemplatesResponse requestToken = SMResponse.callMethod(this.smugmug,AlbumTemplatesResponse.class, "smugmug.albumtemplates.get", null, null, pretty, false, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAlbumTemplates();
	}
}

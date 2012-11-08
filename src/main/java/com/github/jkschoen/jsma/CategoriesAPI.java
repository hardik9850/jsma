package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Category;
import com.github.jkschoen.jsma.response.CategoriesResponse;
import com.github.jkschoen.jsma.response.CategoryResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class CategoriesAPI extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(CategoriesAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected CategoriesAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Create a category.
	 * 
	 * @param category the category to be created
	 * @param unique Create a category if one of the same name doesn't already exist in the current hierarchy.
	 * @param extras A comma separated string of additional attributes to return in the response.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 */
	public Category create(Category category, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		logger.debug("create() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("Name", category.getName());
		if(category.getNiceName() != null){
			params.put("NiceName ", category.getNiceName());
		}
		if(unique){
			params.put("Unique ", "true");
		}
		
		CategoryResponse requestToken = SMResponse.callMethod(this.smugmug,CategoryResponse.class, "smugmug.categories.create", params, null, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		category.setId(requestToken.getCategory().getId());
		if(category != null){
			this.setExtras(category, requestToken.getCategory(), extras);
		}
		return category;
	}
	
	/**
	 * Delete a category.
	 * 
	 * @param categoryId The id for a specific category.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(int categoryId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CategoryID", Integer.toString(categoryId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.categories.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of categories for a given user.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param sitePassword The site password for a specific user.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Category> get(String nickName, String sitePassword, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		Map<String, String> params = new HashMap<String, String>();
		if(nickName != null){
			params.put("NickName ", nickName);
		}
		if(sitePassword != null){
			params.put("SitePassword ", sitePassword);
		}
		
		CategoriesResponse requestToken = SMResponse.callMethod(this.smugmug,CategoriesResponse.class, "smugmug.categories.create", params, null, pretty, false, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getCategories();
	}

	/**
	 * Rename a category.
	 * 
	 * @param categoryId The id for a specific category.
	 * @param name The name for the category.
	 * @param pretty Return a more human friendly response.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean rename(int categoryId, String name, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("rename() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CategoryID", Integer.toString(categoryId));
		params.put("Name", name);
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.categories.rename", null, null, pretty, false, strict, false);
		logger.debug("rename() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
}

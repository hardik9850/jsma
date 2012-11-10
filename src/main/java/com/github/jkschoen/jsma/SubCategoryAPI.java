package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.SubCategory;
import com.github.jkschoen.jsma.response.SMResponse;
import com.github.jkschoen.jsma.response.SubCategoriesResponse;
import com.github.jkschoen.jsma.response.SubCategoryResponse;

public class SubCategoryAPI  extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(SubCategoryAPI.class);

	private SmugMugAPI smugmug;

	protected SubCategoryAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}

	/**
	 * Create a subcategory within a category.
	 * 
	 * @param name The name for the subcategory.
	 * @param categoryId The id for a specific category.
	 * @param unique Create a subcategory if one of the same name doesn't already exist in the current hierarchy.
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
	public SubCategory create(String name, int categoryId, boolean unique, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("create() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("CategoryID", Integer.toString(categoryId));
		params.put("Name", name);
		if(unique){
			params.put("Unique", "true");
		}
		
		SubCategoryResponse requestToken = SMResponse.callMethod(this.smugmug,SubCategoryResponse.class, "smugmug.subcategories.create", params, extras, pretty, false, strict, false);
		logger.debug("create() result: "+(requestToken == null ? "null" : requestToken.toString()));
		SubCategory subCategory = requestToken.getSubCategory();
		subCategory.setName(name);
		return subCategory;
	}
	
	/**
	 * Delete a subcategory.
	 * 
	 * @param subCategoryId The id for a specific subcategory.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean delete(int subCategoryId, boolean pretty, boolean strict) throws SmugMugException {
		logger.debug("delete() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("SubCategoryID", Integer.toString(subCategoryId));
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.subcategories.delete", params, null, pretty, false, strict, false);
		logger.debug("delete() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
	
	/**
	 * Retrieve a list of subcategories for a category.
	 * 
	 * @param categoryId The id for a specific category.
	 * @param nickName The NickName for a specific user.
	 * @param sitePassword The site password for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<SubCategory> get(int categoryId, String nickName, String sitePassword, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("CategoryID", Integer.toString(categoryId));
		if(nickName != null){
			params.put("NickName", nickName);
		}
		if (sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		
		SubCategoriesResponse requestToken = SMResponse.callMethod(this.smugmug,SubCategoriesResponse.class, "smugmug.subcategories.get", params, null, pretty, false, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getSubCategories();
	}
	
	/**
	 * Retrieve a list of all subcategories.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param sitePassword The site password for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<SubCategory> getAll(String nickName, String sitePassword, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("getAll() called");
		
		Map<String, String> params = new HashMap<String, String>();
		if(nickName != null){
			params.put("NickName", nickName);
		}
		if (sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		
		SubCategoriesResponse requestToken = SMResponse.callMethod(this.smugmug,SubCategoriesResponse.class, "smugmug.subcategories.getAll", params, null, pretty, false, strict, false);
		logger.debug("getAll() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getSubCategories();
	}
	
	/**
	 * Rename a subcategory.
	 * 
	 * NOTE: I do not think the extras parameter does anything at all
	 * in this case. But I just followed the api docs for this for 
	 * now and allowed it to be added. Waiting to here back on 
	 * the dgrin forums to find out more.
	 * 
	 * @param subCategoryId The id for a specific subcategory.
	 * @param name The name for the subcategory.
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean rename(int subCategoryId, String name, String[] extras, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("rename() called");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("SubCategoryID", Integer.toString(subCategoryId));
		params.put("Name", name);
		
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.subcategories.rename", params, null, pretty, false, strict, false);
		logger.debug("rename() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return true;
	}
}

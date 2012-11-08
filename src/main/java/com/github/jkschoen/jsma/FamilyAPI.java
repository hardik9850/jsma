package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Family;
import com.github.jkschoen.jsma.response.FamilyResponse;
import com.github.jkschoen.jsma.response.SMResponse;

public class FamilyAPI {
	static final Logger logger = LoggerFactory.getLogger(FamilyAPI.class);

	private SmugMugAPI smugmug;

	protected FamilyAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Add a user to a user's list of family.
	 * 
	 * @param nickName (required) The NickName for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean add(String nickName, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("add() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("NickName", nickName);
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.family.add", params, null, pretty, false, strict, false);
		logger.debug("add() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Retrieve a list of family for a user.
	 * 
	 * @param extras array of extra fields to be populated.
	 * @param pretty return formatted JSON that is easier to read
	 * @param sandboxed Forces URLs to a location with a crossdomain.xml file.
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Family> get(String[] extras, boolean pretty, boolean sandboxed, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		FamilyResponse requestToken = SMResponse.callMethod(this.smugmug,FamilyResponse.class, "smugmug.family.get", null, extras, pretty, sandboxed, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getFamilies();
	}
	
	/**
	 * Remove a user from a user's list of friends.
	 * 
	 * @param nickName (required) The NickName for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean remove(String nickName, boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("remove() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("NickName", nickName);
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.friends.remove", params, null, pretty, false, strict, false);
		logger.debug("remove() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
	
	/**
	 * Remove a user from a user's list of friends.
	 * 
	 * @param nickName (required) The NickName for a specific user.
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public boolean removeAll(boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("removeAll() called");
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.friends.removeAll", null, null, pretty, false, strict, false);
		logger.debug("removeAll() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}
}

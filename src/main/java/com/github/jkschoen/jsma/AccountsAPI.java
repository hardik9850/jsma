package com.github.jkschoen.jsma;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.response.SMResponse;

public class AccountsAPI {
	static final Logger logger = LoggerFactory.getLogger(AccountsAPI.class);
	
	private SmugMugAPI smugmug;
	
	protected AccountsAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Browse to an account.
	 * 
	 * @param nickName The NickName for a specific user.
	 * @param sitePassword The site password for a specific user.
	 * @param pretty  return formatted JSON that is easier to read
	 * @return true if successful
	 * @throws SmugMugException
	 */
	public boolean browse(String nickName, String sitePassword, boolean pretty) throws SmugMugException {
		logger.debug("browse() called");
		Map<String, String> params = new HashMap<String, String>();
		params.put("NickName", nickName);
		if(sitePassword != null){
			params.put("SitePassword", sitePassword);
		}
		SMResponse requestToken = SMResponse.callMethod(this.smugmug,SMResponse.class, "smugmug.accounts.browse", params, null, pretty, false, false, false);
		logger.debug("browse() result: "+(requestToken == null ? "null" : requestToken.toString()));
		//if it does not throw an exception than it worked, so return true
		return true;
	}

}

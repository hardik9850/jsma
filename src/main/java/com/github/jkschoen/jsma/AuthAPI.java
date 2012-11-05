package com.github.jkschoen.jsma;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.Permission;
import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Auth;
import com.github.jkschoen.jsma.response.RequestToken;
import com.github.jkschoen.jsma.response.SMResponse;

public class AuthAPI {
	static final Logger logger = LoggerFactory.getLogger(AuthAPI.class);
	/**
	 * The base url to authorize an application.
	 */
    protected static final String URL_AUTHORIZE = "http://api.smugmug.com/services/oauth/authorize.mg";
	
    private SmugMugAPI smugmug;
	
	protected AuthAPI(SmugMugAPI smugmug){
		this.smugmug = smugmug;
	}
	
	/**
	 * Gets a request token, sets it to the SmugMugAPI instance,
	 * and returns the url needed for the user to authorize your
	 * application.
	 * 
	 * @return url to authorize your application
	 */
	public String getAuthorizeUrl(boolean fullAccess, Permission permission) throws SmugMugException{
		logger.debug("getAuthorizeUrl() called");
		Auth auth = getRequestToken();
		return getAuthorizeUrl(auth, fullAccess, permission);
		
	}
	
	/**
	 * Builds the Authorization URL based on the Request Token
	 * in the Auth instance supplied.
	 * 
	 * @param token contains the request token
	 * @return url to authorize your application
	 */
	public String getAuthorizeUrl(Auth token, boolean fullAccess, Permission permission){
		logger.debug("getAuthorizeUrl() called");
		if (token == null){
			logger.warn("getAuthorizeUrl() token was null, can not create authirization url!!!!");
			return null;
		}
		String url = URL_AUTHORIZE + "?oauth_token=" + token.getToken().getId();
		if (fullAccess){
			url = url + "&Access=Full";
		}
		if (permission == Permission.ADD){
			url = url + "&Permissions=Add";
		} else if (permission == Permission.MODIFY){
			url = url + "&Permissions=Modify";
		}
		
		
		logger.info("getAuthorizeUrl() result: "+url);
		return url;
	}
	
	/**
	 * Verifies the Access Token in the SmugMugAPI instance is
	 * good. If it does not throw a SmugMugException than it 
	 * is still good. 
	 * @return verified AccessToken
	 * @throws SmugMugException
	 */
	public Auth checkAccessToken() throws SmugMugException{
		logger.debug("checkAccessToken() called");
		RequestToken requestToken = SMResponse.callMethod(this.smugmug,RequestToken.class, "smugmug.auth.checkAccessToken", null);
		this.smugmug.setToken(requestToken.getAuth().getToken());
		logger.info("checkAccessToken() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAuth();
	}
	
	/**
	 * Exchange an authorized OAuth request token for an OAuth access token.
	 * Sets the Access Token to the SmugMugAPI instance for future calls as
	 * well as returning the Auth instance to the caller.
	 * 
	 * @return Auth instance containing the access token
	 * @throws SmugMugException
	 */
	public Auth getAccessToken() throws SmugMugException{
		logger.debug("getAccessToken() called");
		RequestToken requestToken = SMResponse.callMethod(this.smugmug,RequestToken.class, "smugmug.auth.getAccessToken", null);
		this.smugmug.setToken(requestToken.getAuth().getToken());
		logger.info("getAccessToken() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAuth();
	}
	
	/**
	 * Retrieve an OAuth request token. and sets the token to the SmugMugAPI instance
	 * as well as return it to the call.
	 * 
	 * @return Auth instance containing the request token
	 * @throws SmugMugException
	 */
	public Auth getRequestToken() throws SmugMugException{
		logger.debug("getRequestToken() called");
		RequestToken requestToken = SMResponse.callMethod(this.smugmug,RequestToken.class, "smugmug.auth.getRequestToken", null);
		this.smugmug.setToken(requestToken.getAuth().getToken());
		logger.info("getRequestToken() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getAuth();
	}
	
	/*
	 * Below are wrappers needed for the responses to be converted correctly. I do not ever
	 * for see them being needed outside of this class, so until they are, they shall stay 
	 * even though I am not a big fan of inner classes.
	 */
}

package com.github.jkschoen.jsma.examples;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.github.jkschoen.jsma.SmugMugAPI;
import com.github.jkschoen.jsma.misc.Permission;
import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Auth;

public class AuthExample {
	/*
	 * APP_NAME is what ever you want it to be. SmugMug asks you give it
	 * unique name so that when a user is having a problem they will
	 * be able to at least identify the app causing the issue.
	 */
	private static String APP_NAME=UserConfig.APP_NAME;
	/*
	 * CONSUMER_SECRET and CONSUMER_KEY come are given to you by SmugMug
	 * when you request an API key. See http://www.smugmug.com/hack/apikeys
	 * for information on Applying for an API Key.
	 */
	private static String CONSUMER_SECRET=UserConfig.CONSUMER_SECRET;
	private static String CONSUMER_KEY=UserConfig.CONSUMER_KEY;
	

	public static void main(String[] args) throws IOException,
			URISyntaxException, SmugMugException {
		//create an instance of the SmugMugAPI to make calls agains.
		SmugMugAPI smugmug = new SmugMugAPI(
				APP_NAME,
				CONSUMER_SECRET,
				CONSUMER_KEY);
		
		//We need to get a request token from SmugMug, create the authorization URL, and 
		//direct the user to go to that url to authorize our application to access SmugMug
		//against that account.
		//The API provides a method to get the Request Token and build the authorize URL
		//for you in one step. Or you can get the Request Token and do it yourself. We
		//are going to use the one that builds the URL for us.
		String url = smugmug.auth().getAuthorizeUrl(true, Permission.MODIFY);
		System.out.println("URL => '"+url+"'");
		
		//now we need to wait for the users to go authorize the URL. We will open a browser
		//window for them to the URL and wait for them to come back.
		Desktop.getDesktop().browse(new URI(url));
		System.out.println("Once you authenticated with SmugMug and granted permissions to this app, press Enter to continue.");
		System.in.read();
		
		//now that they authenticated us, we need to get the Access Token. The Access Token
		//is the one we want to eventually store so the user will not need to make the
		//users re-authenticate every time they run the app.
		Auth accessToken = smugmug.auth().getAccessToken();
		System.out.println("Below you will find the 2 peices of information you need to store, OAUTH_TOKEN_ID and OAUTH_TOKEN_SECRET:");
		System.out.println("OAUTH_TOKEN_ID     => '"+accessToken.getToken().getId()+"'");
		System.out.println("OAUTH_TOKEN_SECRET => '"+accessToken.getToken().getSecret()+"'");
		
		//It may be a good idea to see if the token is still good on application start up. This is how you do that.
		Auth checkedToken = smugmug.auth().checkAccessToken();
		System.out.println(checkedToken);
	}
	
}

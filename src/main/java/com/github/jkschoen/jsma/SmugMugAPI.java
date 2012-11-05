package com.github.jkschoen.jsma;

import com.github.jkschoen.jsma.model.Token;
import com.sun.jersey.api.client.Client;

public class SmugMugAPI {

	
    public static Client CLIENT = Client.create();
	
	private String appName;
	
	private String consumerSecret;
	
	private String cosumerKey;
	
	private Token token;
	
	//all the apis
	private AccountsAPI accounts;
	private AlbumAPI album;
	private AuthAPI auth;
	private ImageAPI images;
	
	public SmugMugAPI(String appName, String consumerSecret, String cosumerKey) {
		this.appName = appName;
		this.consumerSecret = consumerSecret;
		this.cosumerKey = cosumerKey;
	}

	public SmugMugAPI(String appName, String consumerSecret,
			String cosumerKey, Token token) {
		this.appName = appName;
		this.consumerSecret = consumerSecret;
		this.cosumerKey = cosumerKey;
		this.token = token;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getCosumerKey() {
		return cosumerKey;
	}

	public void setCosumerKey(String cosumerKey) {
		this.cosumerKey = cosumerKey;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	
	@Override
	public String toString(){
		return "appName: "+(appName == null ? "null" : appName)
				+ "consumerSecret: "+(consumerSecret == null ? "null" : consumerSecret)
				+ "cosumerKey: "+(cosumerKey == null ? "null" : cosumerKey)
				+ "token: "+(token == null ? "null" : token);
	}

	public AccountsAPI accounts(){
		if (this.accounts == null){
			this.accounts = new AccountsAPI(this);
		}
		return this.accounts;
	}

	public AlbumAPI albums(){
		if (this.album == null){
			this.album = new AlbumAPI(this);
		}
		return this.album;
	}

	public AuthAPI auth(){
		if (this.auth == null){
			this.auth = new AuthAPI(this);
		}
		return this.auth;
	}

	public ImageAPI images(){
		if (this.images == null){
			this.images = new ImageAPI(this);
		}
		return this.images;
	}
	
}

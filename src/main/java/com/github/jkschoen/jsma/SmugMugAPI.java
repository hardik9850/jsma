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
	private AlbumTemplatesAPI albumtemplates;
	private CategoriesAPI categories;
	private CommunitiesAPI communities;
	private CouponsAPI coupons;
	private FamilyAPI family;
	private FansAPI fans;
	private FeaturedAPI featured;
	private FriendsAPI friends;
	private ImageAPI images;
	private PrintMarksAPI printmarks;
	private ServiceAPI service;
	private SubCategoryAPI subcategories;
	private ThemeAPI themes;
	
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

	public AlbumTemplatesAPI albumtemplates(){
		if (this.albumtemplates == null){
			this.albumtemplates = new AlbumTemplatesAPI(this);
		}
		return this.albumtemplates;
	}
	
	public CategoriesAPI categories(){
		if (this.categories == null){
			this.categories = new CategoriesAPI(this);
		}
		return this.categories;
	}
	
	public CommunitiesAPI communities(){
		if (this.communities == null){
			this.communities = new CommunitiesAPI(this);
		}
		return this.communities;
	}
	
	public CouponsAPI coupons(){
		if (this.coupons == null){
			this.coupons = new CouponsAPI(this);
		}
		return this.coupons;
	}
	
	public FamilyAPI family(){
		if (this.family == null){
			this.family = new FamilyAPI(this);
		}
		return this.family;
	}
	
	public FansAPI fans(){
		if (this.fans == null){
			this.fans = new FansAPI(this);
		}
		return this.fans;
	}

	public FeaturedAPI featured(){
		if (this.featured == null){
			this.featured = new FeaturedAPI(this);
		}
		return this.featured;
	}
	
	public FriendsAPI friends(){
		if (this.friends == null){
			this.friends = new FriendsAPI(this);
		}
		return this.friends;
	}
	
	public ImageAPI images(){
		if (this.images == null){
			this.images = new ImageAPI(this);
		}
		return this.images;
	}
	
	public PrintMarksAPI printmarks(){
		if (this.printmarks == null){
			this.printmarks = new PrintMarksAPI(this);
		}
		return this.printmarks;
	}
	
	public ServiceAPI service(){
		if (this.service == null){
			this.service = new ServiceAPI(this);
		}
		return this.service;
	}
	
	public SubCategoryAPI subcategories(){
		if (this.subcategories == null){
			this.subcategories = new SubCategoryAPI(this);
		}
		return this.subcategories;
	}
	
	public ThemeAPI themes(){
		if (this.themes == null){
			this.themes = new ThemeAPI(this);
		}
		return this.themes;
	}
}

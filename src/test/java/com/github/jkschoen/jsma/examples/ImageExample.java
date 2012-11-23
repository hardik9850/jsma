package com.github.jkschoen.jsma.examples;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.github.jkschoen.jsma.SmugMugAPI;
import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Album;
import com.github.jkschoen.jsma.model.Image;
import com.github.jkschoen.jsma.model.Token;

public class ImageExample {

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
	
	/*
	 * To get the OAUTH_TOKEN_ID and OAUTH_TOKEN_SECRET run the AuthExample.
	 */
	private static String OAUTH_TOKEN_ID=UserConfig.OAUTH_TOKEN_ID;
	private static String OAUTH_TOKEN_SECRET=UserConfig.OAUTH_TOKEN_SECRET;

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SmugMugException, IOException, URISyntaxException, InvalidKeyException, NoSuchAlgorithmException {
		SmugMugAPI smugmug = new SmugMugAPI(
				APP_NAME,
				CONSUMER_SECRET,
				CONSUMER_KEY,
				new Token(OAUTH_TOKEN_ID,
						OAUTH_TOKEN_SECRET));

		//lets create an album to put the image in
		System.out.println("\n\ntest smugmug.albums.create");
		Album album = createAlbum(smugmug);
		
		//lets upload the image
		System.out.println("Upload image.");
		File image = null;
		Image smImage = null;
		try {
			image = new File(ImageExample.class.getResource("/Biblioteca_Nacional_de_Espana.jpg").toURI());
			smImage = uploadImage(smugmug, image, album);
		
			//go check that it is there
			System.out.println("Once you check that it is there, press Enter to continue.");
			System.in.read();
		} finally {
			//lets delete the album
			System.out.println("\n\ntest smugmug.albums.delete");
			deleteAlbum(smugmug, album);
		}
	}

	public static Image uploadImage(SmugMugAPI smugmug, File image, Album album) throws InvalidKeyException, NoSuchAlgorithmException, IOException, SmugMugException{
		return smugmug.images().upload(image, album.getId(), "This is a test.", "Testing", false, null, null, null, null, false);
	}
	
	public static Album createAlbum(SmugMugAPI smugmug) throws SmugMugException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Album album = new Album();
		album.setTitle("Test");
		smugmug.albums().create(album, null, false, null, false, false);
		System.out.println("  Created  => "+album.toString());
		return album;
	}
	
	public static void deleteAlbum(SmugMugAPI smugmug, Album album) throws SmugMugException {
		smugmug.albums().delete(album.getId(), album.getKey(), false, false);
		System.out.println("Album Deleted!");
	}

}

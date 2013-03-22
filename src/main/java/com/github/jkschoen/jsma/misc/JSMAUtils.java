package com.github.jkschoen.jsma.misc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.ProcessBuilder.Redirect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSMAUtils {
	
	static final Logger logger = LoggerFactory.getLogger(JSMAUtils.class);
	
	public static boolean JHEAD_EXISTS = false;
	
	static {
		ProcessBuilder pb = new ProcessBuilder("jhead","-h");
		Map<String, String> env = pb.environment();
		Process p;
		try {
			p = pb.start();
			p.waitFor();
			JHEAD_EXISTS = true;
		} catch (IOException e) {
			logger.warn("jhead is not on the path: '"+env.get("PATH")+"'");
		} catch (InterruptedException e) {
			logger.warn("jhead is not on the path: '"+env.get("PATH")+"'");
		}
	}
	
	public static boolean JPEGTRAN_EXISTS = false;
	
	static {
		ProcessBuilder pb = new ProcessBuilder("jpegtran","-h");
		Map<String, String> env = pb.environment();
		Process p;
		try {
			p = pb.start();
			p.waitFor();
			JPEGTRAN_EXISTS = true;
		} catch (IOException e) {
			logger.warn("jpegtran is not on the path: '"+env.get("PATH")+"'");
		} catch (InterruptedException e) {
			logger.warn("jpegtran is not on the path: '"+env.get("PATH")+"'");
		}
	}
	
	public static String uncapitalize(String input){
		if (input == null){
			return null;
		}
		if (input.length()==1){
			return input.toLowerCase();
		}
		return input.substring(0, 1).toLowerCase() + input.substring(1);
	}

	public static String md5(File file) throws NoSuchAlgorithmException,
			IOException {
		if (!file.exists() || !file.isFile()) {
			return null;
		}
		
		InputStream fis =  null;
		try {
			fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			MessageDigest md = MessageDigest.getInstance("MD5");
			int numRead;
	
		    do {
		    	numRead = fis.read(buffer);
		    	if (numRead > 0) {
		    		md.update(buffer, 0, numRead);
		    	}
		    } while (numRead != -1);
		    buffer = null;
		    
		    byte byteData[] = md.digest();
	
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			byteData = null;
			return hexString.toString();
		} finally {
			if (fis != null){
				fis.close();
			}
		}
	}

	public static String md5(String md5Me) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		return md5(md5Me.getBytes("UTF-8"));
	}

	public static String md5(byte[] md5Me) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(md5Me);

		byte byteData[] = md.digest();

		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
	
	/**
	 * This method uses jhead(http://www.sentex.net/~mwandel/jhead/) to 
	 * check if the Orientation flag in the exif has anything but a 
	 * value of '1'. If it does it rotates the image appropriately
	 * and sets the Orientation flag to '1'.
	 * 
	 * jhead in turn uses jpegtran(http://jpegclub.org/jpegtran/) to actually
	 * rotate the image. Both need to be installed on the system, and both
	 * are available for Windows, OS X, and Linux. Basically the install folder
	 * needs to be on the path in order to run.
	 * 
	 * This appears to be the same tool that SmugMug processes uploaded
	 * images with. So if you upload an image that has an Orientation value
	 * other than '1', SmugMug will change it, which changes the MD5Sum and
	 * then could lead to duplicate images. 
	 * 
	 * If jhead or jpegtran are not on the path, this method will return
	 * false. Other wise it will return true, to indicate it ran the 
	 * file through jhead without incident.
	 * 
	 * @param image the image to check if it needs to be rotated
	 * @throws IOException
	 * @throws InterruptedException
	 * returns true if the image is successfully checked and/or rotated
	 */
	public static boolean rotateImage(File image) throws IOException, InterruptedException{
		if (!JSMAUtils.JHEAD_EXISTS){
			logger.warn("jhead is not on the path, image will not checked if it needs to rotate.");
			return false;
		}
		if (!JSMAUtils.JPEGTRAN_EXISTS){
			logger.warn("jpegtran is not on the path, image will not checked if it needs to rotate.");
			return false;
		}
		ProcessBuilder pb = new ProcessBuilder("jhead","-autorot", image.getAbsolutePath());
		
		pb.redirectOutput(Redirect.INHERIT);
		pb.redirectError(Redirect.INHERIT);
		Process p = pb.start();
		p.waitFor();
		return true;
	}
}



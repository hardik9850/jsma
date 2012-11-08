package com.github.jkschoen.jsma;

import java.util.Map;

import com.github.jkschoen.jsma.model.AlbumBase;

public class AlbumBaseAPI extends BaseAPI{

	protected void setAlbumBaseParameters(Map<String, String> params, AlbumBase album){
		if(album.getAlbumTemplateID() != null){
			params.put("AlbumTemplateID", album.getAlbumTemplateID().toString());
		}
		if(album.getBackPrinting() != null){
			params.put("Backprinting", album.getBackPrinting());
		}
		if(album.getBoutiquePackaging() != null){
			params.put("BoutiquePackaging", album.getBoutiquePackaging().toString());
		}
		if(album.getCanRank() != null){
			params.put("CanRank", (album.getCanRank() ? "true" : "false"));
		}
		if(album.getClean() != null){
			params.put("Clean", (album.getClean() ? "true" : "false"));
		}
		if(album.getColorCorrection() != null){
			params.put("ColorCorrection", album.getColorCorrection().toString());
		}
		if(album.getComments() != null){
			params.put("Comments", (album.getComments() ? "true" : "false"));
		}
		if(album.getCommunity() != null){
			params.put("CommunityID", album.getCommunity().getId().toString());
		}
		if(album.getExif() != null){
			params.put("EXIF", (album.getExif() ? "true" : "false"));
		}
		if(album.getExternal() != null){
			params.put("External", (album.getExternal() ? "true" : "false"));
		}
		if(album.getFamilyEdit() != null){
			params.put("FamilyEdit", (album.getFamilyEdit() ? "true" : "false"));
		}
		if(album.getFilenames() != null){
			params.put("Filenames", (album.getFilenames() ? "true" : "false"));
		}
		if(album.getFriendEdit() != null){
			params.put("FriendEdit", (album.getFriendEdit() ? "true" : "false"));
		}
		if(album.getGeography() != null){
			params.put("Geography", (album.getGeography() ? "true" : "false"));
		}
		if(album.getHeader() != null){
			params.put("Header", (album.getHeader() ? "true" : "false"));
		}
		if(album.getHideOwner() != null){
			params.put("HideOwner", (album.getHideOwner() ? "true" : "false"));
		}
		if(album.getInterceptShipping() != null){
			params.put("InterceptShipping", album.getInterceptShipping().toString());
		}
		if(album.getLarges() != null){
			params.put("Larges", (album.getLarges() ? "true" : "false"));
		}
		if(album.getOriginals() != null){
			params.put("Originals", (album.getOriginals() ? "true" : "false"));
		}
		if(album.getPackagingBranding() != null){
			params.put("PackagingBranding", (album.getPackagingBranding() ? "true" : "false"));
		}
		if(album.getPassword() != null){
			params.put("Password", album.getPassword());
		}
		if(album.getPasswordHint() != null){
			params.put("PasswordHint", album.getPasswordHint());
		}
		if(album.getPosition() != null){
			params.put("Position", album.getPosition().toString());
		}
		if(album.getPrintable() != null){
			params.put("Printable", (album.getPrintable() ? "true" : "false"));
		}
		if(album.getPrintmark() != null){
			params.put("PrintmarkID", album.getPrintmark().getId().toString());
		}
		if(album.getProofDays() != null){
			params.put("ProofDays", album.getProofDays().toString());
		}
		if(album.getProtectedRightClick() != null){
			params.put("Protected", (album.getProtectedRightClick() ? "true" : "false"));
		}
		if(album.getPublicAlbum() != null){
			params.put("Public", (album.getPublicAlbum() ? "true" : "false"));
		}
		if(album.getShare() != null){
			params.put("Share", (album.getShare() ? "true" : "false"));
		}
		if(album.getSmugSearchable() != null){
			params.put("SmugSearchable", (album.getSmugSearchable() ? "true" : "false"));
		}
		if(album.getSortDirection() != null){
			params.put("SortDirection", (album.getSortDirection() ? "true" : "false"));
		}
		if(album.getSortMethod() != null){
			params.put("SortMethod", album.getSortMethod());
		}
		if(album.getSquareThumbs() != null){
			params.put("SquareThumbs", (album.getSquareThumbs() ? "true" : "false"));
		}
		if(album.getTemplate() != null){
			params.put("TemplateID", album.getTemplate().toString());
		}
		if(album.getUnsharpAmount() != null){
			params.put("UnsharpAmount", album.getUnsharpAmount().toString());
		}
		if(album.getUnsharpRadius() != null){
			params.put("UnsharpRadius", album.getUnsharpRadius().toString());
		}
		if(album.getUnsharpSigma() != null){
			params.put("UnsharpSigma", album.getUnsharpSigma().toString());
		}
		if(album.getUnsharpThreshold() != null){
			params.put("UnsharpThreshold", album.getUnsharpThreshold().toString());
		}
		if(album.getUploadKey() != null){
			params.put("UploadKey", album.getUploadKey());
		}
		if(album.getWatermark() != null){
			params.put("WatermarkID", album.getWatermark().getId().toString());
		}
		if(album.getWatermarking() != null){
			params.put("Watermarking", (album.getWatermarking() ? "true" : "false"));
		}
		if(album.getWorldSearchable() != null){
			params.put("WorldSearchable", (album.getWorldSearchable() ? "true" : "false"));
		}
		if(album.getX2Larges() != null){
			params.put("X2Larges", (album.getX2Larges() ? "true" : "false"));
		}
		if(album.getX3Larges() != null){
			params.put("X3Larges", (album.getX3Larges() ? "true" : "false"));
		}
		if(album.getxLarges() != null){
			params.put("XLarges", (album.getxLarges() ? "true" : "false"));
		}
	}
}

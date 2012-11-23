package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumTemplate extends AlbumBase{
	
	@XmlElement(name="Name")
	private String albumTemplateName;

	public AlbumTemplate() {
		super();
	}
	
	public AlbumTemplate(Long id){
		super(id);
	}

	public AlbumTemplate(Long id, String albumTemplateName, String backPrinting, Boolean canRank,
			Boolean clean, Integer colorCorrection, Boolean commentsAllowed,
			Community community,
			Boolean exif, Boolean external, Boolean familyEdit, Boolean filenames,
			Boolean friendEdit, Boolean geography, Boolean header,
			Boolean hideOwner, Integer interceptShipping, Boolean larges, Boolean originals,
			Boolean packagingBranding, 
			String password, String passwordHint, 
			Boolean printable, Printmark printmark, Integer proofDays, Boolean protectedRightClick,
			Boolean publicAlbum, Boolean share, Boolean smugSearchable,
			Boolean sortDirection, String sortMethod, Boolean squareThumbs,
			Template template, Float unsharpAmount, Float unsharpRadius,
			Float unsharpSigma, Float unsharpThreshold, Watermark watermark, 
			Boolean watermarking, Boolean worldSearchable,
			Boolean x2Larges, Boolean x3Larges, Boolean xLarges) {
		super(id, backPrinting, canRank, clean, colorCorrection, commentsAllowed, community, exif,
				external, familyEdit, filenames, friendEdit, geography, header, hideOwner,
				interceptShipping, larges, originals, packagingBranding, password,
				passwordHint, printable, printmark, proofDays, protectedRightClick,
				publicAlbum, share, smugSearchable, sortDirection, sortMethod,
				squareThumbs, template, unsharpAmount, unsharpRadius, unsharpSigma,
				unsharpThreshold, watermark, watermarking, worldSearchable, x2Larges, x3Larges,
				xLarges);
		this.albumTemplateName = albumTemplateName;
	}

	public String getAlbumTemplateName() {
		return albumTemplateName;
	}
	
	public void setAlbumTemplateName(String albumTemplateName) {
		this.albumTemplateName = albumTemplateName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((albumTemplateName == null) ? 0 : albumTemplateName
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumTemplate other = (AlbumTemplate) obj;
		if (albumTemplateName == null) {
			if (other.albumTemplateName != null)
				return false;
		} else if (!albumTemplateName.equals(other.albumTemplateName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumTemplate ["+super.toString()+", albumTemplateName=" + albumTemplateName + "]";
	}
	
}

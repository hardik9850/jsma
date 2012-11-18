package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Album")
@XmlAccessorType(XmlAccessType.FIELD)
public class Album extends AlbumBase {

	@XmlElement(name="Key", required=false, namespace="Key")
	private String key;

	@XmlElement(name="Category")
	private Category category;

	@XmlElement(name="Description")
	private String description;

	@XmlElement(name="Highlight")
	private Highlight highlight;

	@XmlElement(name="ImageCount")
	private Integer imageCount;
	
	@XmlElement(name="Keywords")
	private String keywords;
	
	@XmlElement(name="LastUpdated")
	private String lastUpdated;
	
	@XmlElement(name="NiceName")
	private String niceName;
	
	@XmlElement(name="Passworded")
	private Boolean passworded;
	
	@XmlElement(name="SubCategory")
	private SubCategory subCategory;
	
	@XmlElement(name="Theme")
	private Theme theme;
	
	@XmlElement(name="Title")
	private String title;
	
	@XmlElement(name="URL")
	private String url;
	
	@XmlElement(name="Type")
	private String type;
	
	public Album() {
		super();
	}
	
	public Album(Integer id, String key) {
		super(id);
		this.key = key;
	}
	
	public Album(Integer id, String key, String url) {
		super(id);
		this.key = key;
		this.url = url;
	}
	
	public Album(Integer id, String key, Category category, String title) {
		super(id);
		this.key = key;
		this.category = category;
		this.title = title;
	}
	
	public Album(Integer id, String key, String backPrinting, Boolean canRank, 
			Category category, Boolean clean, Integer colorCorrection,
			Boolean commentsAllowed, String description, Boolean exif,
			Boolean external, Boolean familyEdit, Boolean friendEdit,
			Boolean geography, Boolean header, Boolean hideOwner, Integer imageCount,
			Boolean larges,String lastUpdated, String niceName,Boolean originals,
			String password, String passwordHint,Integer position, Boolean printable,
			Integer proofDays, Boolean protectedRightClick, Boolean publicAlbum,
			Boolean share, Boolean smugSearchable, Boolean sortDirection,
			String sortMethod, Boolean squareThumbs, Template template,
			String title, String type, String url, Float unsharpAmount,
			Float unsharpRadius, Float unsharpSigma, Float unsharpThreshold, 
			String uploadKey, Watermark watermark, Boolean watermarking, 
			Boolean worldSearchable, Boolean xLarges,  Boolean x2Larges, 
			Boolean x3Larges) {
		super(id, backPrinting, canRank, clean, colorCorrection,
				commentsAllowed, exif, external, familyEdit, friendEdit, 
				geography, header, hideOwner, larges, originals, password, 
				passwordHint, position, printable, proofDays, protectedRightClick, 
				publicAlbum, share, smugSearchable, sortDirection, sortMethod, 
				squareThumbs, template, unsharpAmount, unsharpRadius, unsharpSigma, 
				unsharpThreshold, uploadKey, watermark, watermarking, worldSearchable, 
				xLarges,  x2Larges,x3Larges);
		this.key = key;
		this.category = category;
		this.description = description;
		this.imageCount = imageCount;
		this.lastUpdated = lastUpdated;
		this.niceName = niceName;
		this.title = title;
		this.url = url;
		this.type = type;
	}
	
	/***
	 * The key for this album.
	 */
	public String getKey() {
		return key;
	}

	/***
	 * Set the key for this album.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * The category that this album belongs to.
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Set the category that this album belongs to.
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * The description for this album.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description for this album.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The highlight image for this album.
	 */
	public Highlight getHighlight() {
		return highlight;
	}

	/**
	 * Set the highlight image for this album.
	 */
	public void setHighlight(Highlight highlight) {
		this.highlight = highlight;
	}

	/**
	 * The number of images in this album.
	 */
	public Integer getImageCount() {
		return imageCount;
	}
	
	/**
	 * Set the number of images in this album.
	 */
	public void setImageCount(Integer imageCount) {
		this.imageCount = imageCount;
	}

	/**
	 * The meta keyword string for this album.
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Set the meta keyword string for this album.
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * The date that this album was last updated.
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Set the date that this album was last updated.
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * The nicename for this album.
	 */
	public String getNiceName() {
		return niceName;
	}

	/**
	 * Set the nicename for this album.
	 */
	public void setNiceName(String niceName) {
		this.niceName = niceName;
	}

	/**
	 * Indicates whether this album is password protected.
	 */
	public Boolean getPassworded() {
		return passworded;
	}

	/**
	 * Sets whether this album is password protected.
	 */
	public void setPassworded(Boolean passworded) {
		this.passworded = passworded;
	}

	/**
	 * The subcategory that this album belongs to.
	 */
	public SubCategory getSubCategory() {
		return subCategory;
	}

	/**
	 * Sets the subcategory that this album belongs to.
	 */
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * The theme applied to this album.
	 */
	public Theme getTheme() {
		return theme;
	}

	/**
	 * Sets the theme applied to this album.
	 */
	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	/**
	 * The title for this album.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Set the title for this album.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * The URL for this album.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the URL for this album.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((highlight == null) ? 0 : highlight.hashCode());
		result = prime * result
				+ ((imageCount == null) ? 0 : imageCount.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result
				+ ((niceName == null) ? 0 : niceName.hashCode());
		result = prime * result
				+ ((passworded == null) ? 0 : passworded.hashCode());
		result = prime * result
				+ ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Album other = (Album) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (highlight == null) {
			if (other.highlight != null)
				return false;
		} else if (!highlight.equals(other.highlight))
			return false;
		if (imageCount == null) {
			if (other.imageCount != null)
				return false;
		} else if (!imageCount.equals(other.imageCount))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (niceName == null) {
			if (other.niceName != null)
				return false;
		} else if (!niceName.equals(other.niceName))
			return false;
		if (passworded == null) {
			if (other.passworded != null)
				return false;
		} else if (!passworded.equals(other.passworded))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Album ["+super.toString()+", key=" + key + ", category=" + category
				+ ", description=" + description + ", highlight=" + highlight
				+ ", imageCount=" + imageCount + ", keywords=" + keywords
				+ ", lastUpdated=" + lastUpdated + ", niceName=" + niceName
				+ ", passworded=" + passworded + ", subCategory=" + subCategory
				+ ", theme=" + theme + ", title=" + title + ", url=" + url
				+ ", type=" + type + "]";
	}
	
	
	
}

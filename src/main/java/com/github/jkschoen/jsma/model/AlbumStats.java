package com.github.jkschoen.jsma.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Album")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumStats {
	
	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Bytes")
	private Integer bytes;
	
	@XmlElement(name="Hits")
	private Integer hits;
	
	@XmlElement(name="Large")
	private Integer large;
	
	@XmlElement(name="Medium")
	private Integer medium;
	
	@XmlElement(name="Original")
	private Integer original;
	
	@XmlElement(name="Small")
	private Integer small;
	
	@XmlElement(name="Video1280")
	private Integer video1280;
	
	@XmlElement(name="Video1920")
	private Integer video1920;
	
	@XmlElement(name="Video320")
	private Integer video320;
	
	@XmlElement(name="Video640")
	private Integer video640;
	
	@XmlElement(name="Video960")
	private Integer video960;
	
	@XmlElement(name="X2Large ")
	private Integer x2Large ;
	
	@XmlElement(name="X3Large ")
	private Integer x3Large ;
	
	@XmlElement(name="XLarge ")
	private Integer xLarge;
	
	@XmlElement(name="Images ")
	private List<ImageStats> images;

	public AlbumStats() {
	}

	/**
	 * The id for this image.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id for this image.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The key for this image.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Sets the key for this image.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * The bytes transferred for this image (or video) for a given month.
	 */
	public Integer getBytes() {
		return bytes;
	}

	/**
	 * Sets the bytes transferred for this image (or video) for a given month.
	 */
	public void setBytes(Integer bytes) {
		this.bytes = bytes;
	}

	/**
	 * The total hits for this image (or video) for a given month.
	 */
	public Integer getHits() {
		return hits;
	}

	/**
	 * Set the total hits for this image (or video) for a given month.
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}

	/**
	 * The number of Large hits for this image (or video) for a given month.
	 */
	public Integer getLarge() {
		return large;
	}

	/**
	 * Set the number of Large hits for this image (or video) for a given month.
	 */
	public void setLarge(Integer large) {
		this.large = large;
	}

	/**
	 * The number of Medium hits for this image (or video) for a given month.
	 */
	public Integer getMedium() {
		return medium;
	}

	/**
	 * Set the number of Medium hits for this image (or video) for a given month.
	 */
	public void setMedium(Integer medium) {
		this.medium = medium;
	}

	/**
	 * The number of Original hits for this image (or video) for a given month.
	 */
	public Integer getOriginal() {
		return original;
	}

	/**
	 * Set the number of Original hits for this image (or video) for a given month.
	 */
	public void setOriginal(Integer original) {
		this.original = original;
	}

	/**
	 * The number of Small hits for this image (or video) for a given month.
	 */
	public Integer getSmall() {
		return small;
	}

	/**
	 * Set the number of Small hits for this image (or video) for a given month.
	 */
	public void setSmall(Integer small) {
		this.small = small;
	}

	/**
	 * The number of Video1280 hits for this image (or video) for a given month.
	 */
	public Integer getVideo1280() {
		return video1280;
	}

	/**
	 * Set the number of Video1280 hits for this image (or video) for a given month.
	 */
	public void setVideo1280(Integer video1280) {
		this.video1280 = video1280;
	}

	/**
	 * The number of Video1920 hits for this image (or video) for a given month.
	 */
	public Integer getVideo1920() {
		return video1920;
	}

	/**
	 * Set the number of Video1920 hits for this image (or video) for a given month.
	 */
	public void setVideo1920(Integer video1920) {
		this.video1920 = video1920;
	}

	/**
	 * The number of Video320 hits for this image (or video) for a given month.
	 */
	public Integer getVideo320() {
		return video320;
	}

	/**
	 * Set the number of Video320 hits for this image (or video) for a given month.
	 */
	public void setVideo320(Integer video320) {
		this.video320 = video320;
	}

	/**
	 * The number of Video640 hits for this image (or video) for a given month.
	 */
	public Integer getVideo640() {
		return video640;
	}

	/**
	 * Set the number of Video640 hits for this image (or video) for a given month.
	 */
	public void setVideo640(Integer video640) {
		this.video640 = video640;
	}

	/**
	 * The number of Video960 hits for this image (or video) for a given month.
	 */
	public Integer getVideo960() {
		return video960;
	}

	/**
	 * Set the number of Video960 hits for this image (or video) for a given month.
	 */
	public void setVideo960(Integer video960) {
		this.video960 = video960;
	}

	/**
	 * The number of X2Large hits for this image (or video) for a given month.
	 */
	public Integer getX2Large() {
		return x2Large;
	}

	/**
	 * Set the number of X2Large hits for this image (or video) for a given month.
	 */
	public void setX2Large(Integer x2Large) {
		this.x2Large = x2Large;
	}

	/**
	 * The number of X3Large hits for this image (or video) for a given month.
	 */
	public Integer getX3Large() {
		return x3Large;
	}

	/**
	 * Set the number of X3Large hits for this image (or video) for a given month.
	 */
	public void setX3Large(Integer x3Large) {
		this.x3Large = x3Large;
	}

	/**
	 * The number of XLarge hits for this image (or video) for a given month.
	 */
	public Integer getxLarge() {
		return xLarge;
	}

	/**
	 * Set the number of XLarge hits for this image (or video) for a given month.
	 */
	public void setxLarge(Integer xLarge) {
		this.xLarge = xLarge;
	}


	/**
	 * Statistics for each image in the album
	 */
	public List<ImageStats> getImages() {
		return images;
	}

	/**
	 * Sets the list of image statistics for each image.
	 */
	public void setImages(List<ImageStats> images) {
		this.images = images;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bytes == null) ? 0 : bytes.hashCode());
		result = prime * result + ((hits == null) ? 0 : hits.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((large == null) ? 0 : large.hashCode());
		result = prime * result + ((medium == null) ? 0 : medium.hashCode());
		result = prime * result
				+ ((original == null) ? 0 : original.hashCode());
		result = prime * result + ((small == null) ? 0 : small.hashCode());
		result = prime * result
				+ ((video1280 == null) ? 0 : video1280.hashCode());
		result = prime * result
				+ ((video1920 == null) ? 0 : video1920.hashCode());
		result = prime * result
				+ ((video320 == null) ? 0 : video320.hashCode());
		result = prime * result
				+ ((video640 == null) ? 0 : video640.hashCode());
		result = prime * result
				+ ((video960 == null) ? 0 : video960.hashCode());
		result = prime * result + ((x2Large == null) ? 0 : x2Large.hashCode());
		result = prime * result + ((x3Large == null) ? 0 : x3Large.hashCode());
		result = prime * result + ((xLarge == null) ? 0 : xLarge.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumStats other = (AlbumStats) obj;
		if (bytes == null) {
			if (other.bytes != null)
				return false;
		} else if (!bytes.equals(other.bytes))
			return false;
		if (hits == null) {
			if (other.hits != null)
				return false;
		} else if (!hits.equals(other.hits))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (large == null) {
			if (other.large != null)
				return false;
		} else if (!large.equals(other.large))
			return false;
		if (medium == null) {
			if (other.medium != null)
				return false;
		} else if (!medium.equals(other.medium))
			return false;
		if (original == null) {
			if (other.original != null)
				return false;
		} else if (!original.equals(other.original))
			return false;
		if (small == null) {
			if (other.small != null)
				return false;
		} else if (!small.equals(other.small))
			return false;
		if (video1280 == null) {
			if (other.video1280 != null)
				return false;
		} else if (!video1280.equals(other.video1280))
			return false;
		if (video1920 == null) {
			if (other.video1920 != null)
				return false;
		} else if (!video1920.equals(other.video1920))
			return false;
		if (video320 == null) {
			if (other.video320 != null)
				return false;
		} else if (!video320.equals(other.video320))
			return false;
		if (video640 == null) {
			if (other.video640 != null)
				return false;
		} else if (!video640.equals(other.video640))
			return false;
		if (video960 == null) {
			if (other.video960 != null)
				return false;
		} else if (!video960.equals(other.video960))
			return false;
		if (x2Large == null) {
			if (other.x2Large != null)
				return false;
		} else if (!x2Large.equals(other.x2Large))
			return false;
		if (x3Large == null) {
			if (other.x3Large != null)
				return false;
		} else if (!x3Large.equals(other.x3Large))
			return false;
		if (xLarge == null) {
			if (other.xLarge != null)
				return false;
		} else if (!xLarge.equals(other.xLarge))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AlbumStats [id=" + id + ", key=" + key + ", bytes=" + bytes
				+ ", hits=" + hits + ", large=" + large + ", medium=" + medium
				+ ", original=" + original + ", small=" + small
				+ ", video1280=" + video1280 + ", video1920=" + video1920
				+ ", video320=" + video320 + ", video640=" + video640
				+ ", video960=" + video960 + ", x2Large=" + x2Large
				+ ", x3Large=" + x3Large + ", xLarge=" + xLarge + ", images="
				+ images + "]";
	}
}

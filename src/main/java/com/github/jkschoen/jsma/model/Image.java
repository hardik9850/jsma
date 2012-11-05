package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Image {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Album")
	private Album album;
	
	@XmlElement(name="Altitude")
	private Integer altitude;
	
	@XmlElement(name="Caption")
	private String caption;
	
	@XmlElement(name="Date")
	private String date;
	
	@XmlElement(name="FileName")
	private String fileName;
	
	@XmlElement(name="Duration")
	private Integer duration;
	
	@XmlElement(name="Format")
	private String format;
	
	@XmlElement(name="Height")
	private Integer height;
	
	@XmlElement(name="Hidden")
	private Boolean hidden;
	
	@XmlElement(name="Keywords")
	private String keywords;

	@XmlElement(name="LargeURL")
	private String largeURL;
	
	@XmlElement(name="LastUpdated")
	private String lastUpdated;
	
	@XmlElement(name="Latitude")
	private Float latitude;
	
	@XmlElement(name="LightboxURL")
	private String lightboxURL;
	
	@XmlElement(name="Longitude")
	private Float longitude;

	@XmlElement(name="MD5Sum ")
	private String md5Sum;
	
	@XmlElement(name="MediumURL")
	private String mediumURL;
	
	@XmlElement(name="OriginalURL")
	private String originalURL;
	
	@XmlElement(name="Position")
	private Integer position;
	
	@XmlElement(name="Serial")
	private Integer serial;
	
	@XmlElement(name="Size")
	private Integer size;
	
	@XmlElement(name="SmallURL")
	private String smallURL;
	
	@XmlElement(name="Status")
	private String status;
	
	@XmlElement(name="ThumbURL")
	private String thumbURL;
	
	@XmlElement(name="TinyURL")
	private String tinyURL;
	
	@XmlElement(name="Type")
	private String type;
	
	@XmlElement(name="URL")
	private String url;
	
	@XmlElement(name="User")
	private User user;
	
	@XmlElement(name="Video320URL")
	private String video320URL;
	
	@XmlElement(name="Video640URL")
	private String video640URL;
	
	@XmlElement(name="Video960URL ")
	private String video960URL;
	
	@XmlElement(name="Video1280URL")
	private String video1280URL;
	
	@XmlElement(name="Video1920URL")
	private String video1920URL;
	
	@XmlElement(name="VideoSMILURL")
	private String videoSMILURL;
	
	@XmlElement(name="VideoStreamingURL ")
	private String videoStreamingURL;
	
	@XmlElement(name="Width")
	private Integer width;
	
	@XmlElement(name="X2LargeURL ")
	private String x2LargeURL;
	
	@XmlElement(name="X3LargeURL ")
	private String x3LargeURL;
	
	@XmlElement(name="XLargeURL ")
	private String xLargeURL;

	public Image() {
		super();
	}

	/**
	 * The id for this image.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id for this image.
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
	 * Set the key for this image.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * (collected & smart only)
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * (collected & smart only)
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

	/**
	 * The altitude at which this image (or video) was taken.
	 */
	public Integer getAltitude() {
		return altitude;
	}

	/**
	 * Set the altitude at which this image (or video) was taken.
	 */
	public void setAltitude(Integer altitude) {
		this.altitude = altitude;
	}

	/**
	 * The caption for this image (or video).
	 */
	public String getCaption() {
		return caption;
	}

	/**
	 * Set the caption for this image (or video).
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}

	/**
	 * The date that this image (or video) was uploaded.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Set the date that this image (or video) was uploaded.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * The filename of this image (or video).
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Set the filename of this image (or video).
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * The duration of the video in seconds.
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Set the duration of the video in seconds.
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * The original format of this image (or video).
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Set the original format of this image (or video).
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 * The height of the crop.
	 */
	public Integer getHeight() {
		return height;
	}

	/**
	 * Set the height of the crop.
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}

	/**
	 * Hide this image (or video).
	 */
	public Boolean getHidden() {
		return hidden;
	}

	/**
	 * Sets whether to hide this image (or video) or not.
	 */
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * The keyword string for this image (or video).
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * Set the keyword string for this image (or video).
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * The url for the Large version of this image.
	 */
	public String getLargeURL() {
		return largeURL;
	}

	/**
	 * Set the url for the Large version of this image.
	 */
	public void setLargeURL(String largeURL) {
		this.largeURL = largeURL;
	}

	/**
	 * The date that this image (or video) was last updated.
	 */
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Set the date that this image (or video) was last updated.
	 */
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	/**
	 * The latitude at which this image (or video) was taken.
	 */
	public Float getLatitude() {
		return latitude;
	}

	/**
	 * Set the latitude at which this image (or video) was taken.
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/**
	 * The Lightbox URL for this image.
	 */
	public String getLightboxURL() {
		return lightboxURL;
	}

	/**
	 * Set the Lightbox URL for this image.
	 */
	public void setLightboxURL(String lightboxURL) {
		this.lightboxURL = lightboxURL;
	}

	/**
	 * The longitude at which this image (or video) was taken.
	 */
	public Float getLongitude() {
		return longitude;
	}

	/**
	 * Set the longitude at which this image (or video) was taken.
	 */
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	/**
	 * The MD5 sum for this image (or video).
	 */
	public String getMd5Sum() {
		return md5Sum;
	}

	/**
	 * Set the MD5 sum for this image (or video).
	 */
	public void setMd5Sum(String md5Sum) {
		this.md5Sum = md5Sum;
	}

	/**
	 * The url for the Medium version of this image.
	 */
	public String getMediumURL() {
		return mediumURL;
	}

	/**
	 * Set the url for the Medium version of this image.
	 */
	public void setMediumURL(String mediumURL) {
		this.mediumURL = mediumURL;
	}

	/**
	 * The url for the Original version of this image.
	 */
	public String getOriginalURL() {
		return originalURL;
	}

	/**
	 * Set the url for the Original version of this image.
	 */
	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	/**
	 * The position of this image (or video) within the album.
	 */
	public Integer getPosition() {
		return position;
	}

	/**
	 * Set the position of this image (or video) within the album.
	 */
	public void setPosition(Integer position) {
		this.position = position;
	}

	/**
	 * The current revision of this image (or video).
	 */
	public Integer getSerial() {
		return serial;
	}

	/**
	 * Set the current revision of this image (or video).
	 */
	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	/**
	 * The size of this image (or video) in bytes.
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Set the size of this image (or video) in bytes.
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * The url for the Small version of this image.
	 */
	public String getSmallURL() {
		return smallURL;
	}

	/**
	 * Set the url for the Small version of this image.
	 */
	public void setSmallURL(String smallURL) {
		this.smallURL = smallURL;
	}

	/**
	 * The status for this image.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status for this image.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * The url for the Thumb version of this image
	 */
	public String getThumbURL() {
		return thumbURL;
	}

	/**
	 * Set the url for the Thumb version of this image
	 */
	public void setThumbURL(String thumbURL) {
		this.thumbURL = thumbURL;
	}

	/**
	 * The url for the Tiny version of this image.
	 */
	public String getTinyURL() {
		return tinyURL;
	}

	/**
	 * Set the url for the Tiny version of this image.
	 */
	public void setTinyURL(String tinyURL) {
		this.tinyURL = tinyURL;
	}

	/**
	 * The type for this image.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type for this image.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * The URL for this image.
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the URL for this image.
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * (collected & smart only)
	 */
	public User getUser() {
		return user;
	}

	/**
	 * (collected & smart only)
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * The url for the 320 version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideo320URL() {
		return video320URL;
	}

	/**
	 * Set the url for the 320 version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideo320URL(String video320url) {
		video320URL = video320url;
	}

	/**
	 * The url for the 640 version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideo640URL() {
		return video640URL;
	}

	/**
	 * Set the url for the 640 version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideo640URL(String video640url) {
		video640URL = video640url;
	}

	/**
	 * The url for the 960 version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideo960URL() {
		return video960URL;
	}

	/**
	 * Set the url for the 960 version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideo960URL(String video960url) {
		video960URL = video960url;
	}

	/**
	 * The url for the 1280 version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideo1280URL() {
		return video1280URL;
	}

	/**
	 * Set the url for the 1280 version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideo1280URL(String video1280url) {
		video1280URL = video1280url;
	}

	/**
	 * The url for the 1920 version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideo1920URL() {
		return video1920URL;
	}

	/**
	 * Set the url for the 1920 version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideo1920URL(String video1920url) {
		video1920URL = video1920url;
	}

	/**
	 * The url for the SMIL version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideoSMILURL() {
		return videoSMILURL;
	}

	/**
	 * Set the url for the SMIL version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideoSMILURL(String videoSMILURL) {
		this.videoSMILURL = videoSMILURL;
	}

	/**
	 * The url for the Streaming version of this video.
	 * (video, power & pro accounts only)
	 */
	public String getVideoStreamingURL() {
		return videoStreamingURL;
	}

	/**
	 * Set the url for the Streaming version of this video.
	 * (video, power & pro accounts only)
	 */
	public void setVideoStreamingURL(String videoStreamingURL) {
		this.videoStreamingURL = videoStreamingURL;
	}

	/**
	 * The width of the crop.
	 */
	public Integer getWidth() {
		return width;
	}

	/**
	 * Set the width of the crop.
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * The url for the X2Large version of this image.
	 */
	public String getX2LargeURL() {
		return x2LargeURL;
	}

	/**
	 * Set the url for the X2Large version of this image.
	 */
	public void setX2LargeURL(String x2LargeURL) {
		this.x2LargeURL = x2LargeURL;
	}

	/**
	 * The url for the X3Large version of this image.
	 */
	public String getX3LargeURL() {
		return x3LargeURL;
	}

	/**
	 * Set the url for the X3Large version of this image.
	 */
	public void setX3LargeURL(String x3LargeURL) {
		this.x3LargeURL = x3LargeURL;
	}

	/**
	 * The url for the XLarge version of this image.
	 */
	public String getxLargeURL() {
		return xLargeURL;
	}

	/**
	 * Set the url for the XLarge version of this image.
	 */
	public void setxLargeURL(String xLargeURL) {
		this.xLargeURL = xLargeURL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result
				+ ((altitude == null) ? 0 : altitude.hashCode());
		result = prime * result + ((caption == null) ? 0 : caption.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((height == null) ? 0 : height.hashCode());
		result = prime * result + ((hidden == null) ? 0 : hidden.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result
				+ ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result
				+ ((largeURL == null) ? 0 : largeURL.hashCode());
		result = prime * result
				+ ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((lightboxURL == null) ? 0 : lightboxURL.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((md5Sum == null) ? 0 : md5Sum.hashCode());
		result = prime * result
				+ ((mediumURL == null) ? 0 : mediumURL.hashCode());
		result = prime * result
				+ ((originalURL == null) ? 0 : originalURL.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result
				+ ((smallURL == null) ? 0 : smallURL.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((thumbURL == null) ? 0 : thumbURL.hashCode());
		result = prime * result + ((tinyURL == null) ? 0 : tinyURL.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result
				+ ((video1280URL == null) ? 0 : video1280URL.hashCode());
		result = prime * result
				+ ((video1920URL == null) ? 0 : video1920URL.hashCode());
		result = prime * result
				+ ((video320URL == null) ? 0 : video320URL.hashCode());
		result = prime * result
				+ ((video640URL == null) ? 0 : video640URL.hashCode());
		result = prime * result
				+ ((video960URL == null) ? 0 : video960URL.hashCode());
		result = prime * result
				+ ((videoSMILURL == null) ? 0 : videoSMILURL.hashCode());
		result = prime
				* result
				+ ((videoStreamingURL == null) ? 0 : videoStreamingURL
						.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		result = prime * result
				+ ((x2LargeURL == null) ? 0 : x2LargeURL.hashCode());
		result = prime * result
				+ ((x3LargeURL == null) ? 0 : x3LargeURL.hashCode());
		result = prime * result
				+ ((xLargeURL == null) ? 0 : xLargeURL.hashCode());
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
		Image other = (Image) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (altitude == null) {
			if (other.altitude != null)
				return false;
		} else if (!altitude.equals(other.altitude))
			return false;
		if (caption == null) {
			if (other.caption != null)
				return false;
		} else if (!caption.equals(other.caption))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (height == null) {
			if (other.height != null)
				return false;
		} else if (!height.equals(other.height))
			return false;
		if (hidden == null) {
			if (other.hidden != null)
				return false;
		} else if (!hidden.equals(other.hidden))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (largeURL == null) {
			if (other.largeURL != null)
				return false;
		} else if (!largeURL.equals(other.largeURL))
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (lightboxURL == null) {
			if (other.lightboxURL != null)
				return false;
		} else if (!lightboxURL.equals(other.lightboxURL))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (md5Sum == null) {
			if (other.md5Sum != null)
				return false;
		} else if (!md5Sum.equals(other.md5Sum))
			return false;
		if (mediumURL == null) {
			if (other.mediumURL != null)
				return false;
		} else if (!mediumURL.equals(other.mediumURL))
			return false;
		if (originalURL == null) {
			if (other.originalURL != null)
				return false;
		} else if (!originalURL.equals(other.originalURL))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (smallURL == null) {
			if (other.smallURL != null)
				return false;
		} else if (!smallURL.equals(other.smallURL))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (thumbURL == null) {
			if (other.thumbURL != null)
				return false;
		} else if (!thumbURL.equals(other.thumbURL))
			return false;
		if (tinyURL == null) {
			if (other.tinyURL != null)
				return false;
		} else if (!tinyURL.equals(other.tinyURL))
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
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (video1280URL == null) {
			if (other.video1280URL != null)
				return false;
		} else if (!video1280URL.equals(other.video1280URL))
			return false;
		if (video1920URL == null) {
			if (other.video1920URL != null)
				return false;
		} else if (!video1920URL.equals(other.video1920URL))
			return false;
		if (video320URL == null) {
			if (other.video320URL != null)
				return false;
		} else if (!video320URL.equals(other.video320URL))
			return false;
		if (video640URL == null) {
			if (other.video640URL != null)
				return false;
		} else if (!video640URL.equals(other.video640URL))
			return false;
		if (video960URL == null) {
			if (other.video960URL != null)
				return false;
		} else if (!video960URL.equals(other.video960URL))
			return false;
		if (videoSMILURL == null) {
			if (other.videoSMILURL != null)
				return false;
		} else if (!videoSMILURL.equals(other.videoSMILURL))
			return false;
		if (videoStreamingURL == null) {
			if (other.videoStreamingURL != null)
				return false;
		} else if (!videoStreamingURL.equals(other.videoStreamingURL))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		if (x2LargeURL == null) {
			if (other.x2LargeURL != null)
				return false;
		} else if (!x2LargeURL.equals(other.x2LargeURL))
			return false;
		if (x3LargeURL == null) {
			if (other.x3LargeURL != null)
				return false;
		} else if (!x3LargeURL.equals(other.x3LargeURL))
			return false;
		if (xLargeURL == null) {
			if (other.xLargeURL != null)
				return false;
		} else if (!xLargeURL.equals(other.xLargeURL))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", key=" + key + ", album=" + album
				+ ", altitude=" + altitude + ", caption=" + caption + ", date="
				+ date + ", fileName=" + fileName + ", duration=" + duration
				+ ", format=" + format + ", height=" + height + ", hidden="
				+ hidden + ", keywords=" + keywords + ", largeURL=" + largeURL
				+ ", lastUpdated=" + lastUpdated + ", latitude=" + latitude
				+ ", lightboxURL=" + lightboxURL + ", longitude=" + longitude
				+ ", md5Sum=" + md5Sum + ", mediumURL=" + mediumURL
				+ ", originalURL=" + originalURL + ", position=" + position
				+ ", serial=" + serial + ", size=" + size + ", smallURL="
				+ smallURL + ", status=" + status + ", thumbURL=" + thumbURL
				+ ", tinyURL=" + tinyURL + ", type=" + type + ", url=" + url
				+ ", user=" + user + ", video320URL=" + video320URL
				+ ", video640URL=" + video640URL + ", video960URL="
				+ video960URL + ", video1280URL=" + video1280URL
				+ ", video1920URL=" + video1920URL + ", videoSMILURL="
				+ videoSMILURL + ", videoStreamingURL=" + videoStreamingURL
				+ ", width=" + width + ", x2LargeURL=" + x2LargeURL
				+ ", x3LargeURL=" + x3LargeURL + ", xLargeURL=" + xLargeURL
				+ "]";
	}
}

package com.github.jkschoen.jsma.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageEXIF {

	@XmlElement(name="id")
	private Integer id;
	
	@XmlElement(name="Key")
	private String key;
	
	@XmlElement(name="Aperture")
	private String aperture;
	
	@XmlElement(name="Brightness")
	private String brightness;
	
	@XmlElement(name="CCDWidth")
	private String ccdWidth;
	
	@XmlElement(name="ColorSpace")
	private Integer colorSpace;
	
	@XmlElement(name="CompressedBitsPerPixel")
	private String compressedBitsPerPixel;
	
	@XmlElement(name="Contrast")
	private Integer contrast;
	
	@XmlElement(name="DateTime")
	private String dateTime;
	
	@XmlElement(name="DateTimeDigitized")
	private String dateTimeDigitized;
	
	@XmlElement(name="DateTimeOriginal")
	private String dateTimeOriginal;
	
	@XmlElement(name="DigitalZoomRatio")
	private String digitalZoomRatio;
	
	@XmlElement(name="ExposureBias")
	private String exposureBiasValue;
	
	@XmlElement(name="ExposureMode")
	private Integer exposureMode;
	
	@XmlElement(name="ExposureProgram")
	private Integer exposureProgram;
	
	@XmlElement(name="ExposureTime")
	private String exposureTime;
	
	@XmlElement(name="Flash")
	private Integer flash;
	
	@XmlElement(name="FocalLength")
	private String focalLength;
	
	@XmlElement(name="FocalLengthIn35mmFilm")
	private String focalLengthIn35mmFilm;
	
	@XmlElement(name="ISO")
	private Integer iso;
	
	@XmlElement(name="LightSource")
	private Integer lightSource;
	
	@XmlElement(name="Make")
	private String make;
	
	@XmlElement(name="Metering")
	private Integer metering;
	
	@XmlElement(name="Model")
	private String model;
	
	@XmlElement(name="Saturation")
	private Integer saturation;
	
	@XmlElement(name="SensingMethod")
	private Integer sensingMethod;
	
	@XmlElement(name="Sharpness")
	private Integer sharpness;
	
	@XmlElement(name="SubjectDistance")
	private String subjectDistance;
	
	@XmlElement(name="SubjectDistanceRange")
	private Integer subjectDistanceRange;
	
	@XmlElement(name="WhiteBalance")
	private Integer whiteBalance;
	
	public ImageEXIF(){}

	public ImageEXIF(Integer id, String key, String aperture, String ccdWidth,
			Integer colorSpace, String compressedBitsPerPixel, String dateTime,
			String dateTimeDigitized, String dateTimeOriginal,
			String digitalZoomRatio, String exposureBiasValue,
			Integer exposureMode, String exposureTime, Integer flash,
			String focalLength, String make, String model,
			Integer sensingMethod, Integer whiteBalance) {
		this.id = id;
		this.key = key;
		this.aperture = aperture;
		this.ccdWidth = ccdWidth;
		this.colorSpace = colorSpace;
		this.compressedBitsPerPixel = compressedBitsPerPixel;
		this.dateTime = dateTime;
		this.dateTimeDigitized = dateTimeDigitized;
		this.dateTimeOriginal = dateTimeOriginal;
		this.digitalZoomRatio = digitalZoomRatio;
		this.exposureBiasValue = exposureBiasValue;
		this.exposureMode = exposureMode;
		this.exposureTime = exposureTime;
		this.flash = flash;
		this.focalLength = focalLength;
		this.make = make;
		this.model = model;
		this.sensingMethod = sensingMethod;
		this.whiteBalance = whiteBalance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getAperture() {
		return aperture;
	}

	public void setAperture(String aperture) {
		this.aperture = aperture;
	}

	public String getBrightness() {
		return brightness;
	}

	public void setBrightness(String brightness) {
		this.brightness = brightness;
	}

	public String getCcdWidth() {
		return ccdWidth;
	}

	public void setCcdWidth(String ccdWidth) {
		this.ccdWidth = ccdWidth;
	}

	public Integer getColorSpace() {
		return colorSpace;
	}

	public void setColorSpace(Integer colorSpace) {
		this.colorSpace = colorSpace;
	}

	public String getCompressedBitsPerPixel() {
		return compressedBitsPerPixel;
	}

	public void setCompressedBitsPerPixel(String compressedBitsPerPixel) {
		this.compressedBitsPerPixel = compressedBitsPerPixel;
	}

	public Integer getContrast() {
		return contrast;
	}

	public void setContrast(Integer contrast) {
		this.contrast = contrast;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getDateTimeDigitized() {
		return dateTimeDigitized;
	}

	public void setDateTimeDigitized(String dateTimeDigitized) {
		this.dateTimeDigitized = dateTimeDigitized;
	}

	public String getDateTimeOriginal() {
		return dateTimeOriginal;
	}

	public void setDateTimeOriginal(String dateTimeOriginal) {
		this.dateTimeOriginal = dateTimeOriginal;
	}

	public String getDigitalZoomRatio() {
		return digitalZoomRatio;
	}

	public void setDigitalZoomRatio(String digitalZoomRatio) {
		this.digitalZoomRatio = digitalZoomRatio;
	}

	public String getExposureBiasValue() {
		return exposureBiasValue;
	}

	public void setExposureBiasValue(String exposureBiasValue) {
		this.exposureBiasValue = exposureBiasValue;
	}

	public Integer getExposureMode() {
		return exposureMode;
	}

	public void setExposureMode(Integer exposureMode) {
		this.exposureMode = exposureMode;
	}

	public Integer getExposureProgram() {
		return exposureProgram;
	}

	public void setExposureProgram(Integer exposureProgram) {
		this.exposureProgram = exposureProgram;
	}

	public String getExposureTime() {
		return exposureTime;
	}

	public void setExposureTime(String exposureTime) {
		this.exposureTime = exposureTime;
	}

	public Integer getFlash() {
		return flash;
	}

	public void setFlash(Integer flash) {
		this.flash = flash;
	}

	public String getFocalLength() {
		return focalLength;
	}

	public void setFocalLength(String focalLength) {
		this.focalLength = focalLength;
	}

	public String getFocalLengthIn35mmFilm() {
		return focalLengthIn35mmFilm;
	}

	public void setFocalLengthIn35mmFilm(String focalLengthIn35mmFilm) {
		this.focalLengthIn35mmFilm = focalLengthIn35mmFilm;
	}

	public Integer getIso() {
		return iso;
	}

	public void setIso(Integer iso) {
		this.iso = iso;
	}

	public Integer getLightSource() {
		return lightSource;
	}

	public void setLightSource(Integer lightSource) {
		this.lightSource = lightSource;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public Integer getMetering() {
		return metering;
	}

	public void setMetering(Integer metering) {
		this.metering = metering;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getSaturation() {
		return saturation;
	}

	public void setSaturation(Integer saturation) {
		this.saturation = saturation;
	}

	public Integer getSensingMethod() {
		return sensingMethod;
	}

	public void setSensingMethod(Integer sensingMethod) {
		this.sensingMethod = sensingMethod;
	}

	public Integer getSharpness() {
		return sharpness;
	}

	public void setSharpness(Integer sharpness) {
		this.sharpness = sharpness;
	}

	public String getSubjectDistance() {
		return subjectDistance;
	}

	public void setSubjectDistance(String subjectDistance) {
		this.subjectDistance = subjectDistance;
	}

	public Integer getSubjectDistanceRange() {
		return subjectDistanceRange;
	}

	public void setSubjectDistanceRange(Integer subjectDistanceRange) {
		this.subjectDistanceRange = subjectDistanceRange;
	}

	public Integer getWhiteBalance() {
		return whiteBalance;
	}

	public void setWhiteBalance(Integer whiteBalance) {
		this.whiteBalance = whiteBalance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aperture == null) ? 0 : aperture.hashCode());
		result = prime * result
				+ ((brightness == null) ? 0 : brightness.hashCode());
		result = prime * result
				+ ((ccdWidth == null) ? 0 : ccdWidth.hashCode());
		result = prime * result
				+ ((colorSpace == null) ? 0 : colorSpace.hashCode());
		result = prime
				* result
				+ ((compressedBitsPerPixel == null) ? 0
						: compressedBitsPerPixel.hashCode());
		result = prime * result
				+ ((contrast == null) ? 0 : contrast.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime
				* result
				+ ((dateTimeDigitized == null) ? 0 : dateTimeDigitized
						.hashCode());
		result = prime
				* result
				+ ((dateTimeOriginal == null) ? 0 : dateTimeOriginal.hashCode());
		result = prime
				* result
				+ ((digitalZoomRatio == null) ? 0 : digitalZoomRatio.hashCode());
		result = prime
				* result
				+ ((exposureBiasValue == null) ? 0 : exposureBiasValue
						.hashCode());
		result = prime * result
				+ ((exposureMode == null) ? 0 : exposureMode.hashCode());
		result = prime * result
				+ ((exposureProgram == null) ? 0 : exposureProgram.hashCode());
		result = prime * result
				+ ((exposureTime == null) ? 0 : exposureTime.hashCode());
		result = prime * result + ((flash == null) ? 0 : flash.hashCode());
		result = prime * result
				+ ((focalLength == null) ? 0 : focalLength.hashCode());
		result = prime
				* result
				+ ((focalLengthIn35mmFilm == null) ? 0 : focalLengthIn35mmFilm
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((iso == null) ? 0 : iso.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result
				+ ((lightSource == null) ? 0 : lightSource.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result
				+ ((metering == null) ? 0 : metering.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((saturation == null) ? 0 : saturation.hashCode());
		result = prime * result
				+ ((sensingMethod == null) ? 0 : sensingMethod.hashCode());
		result = prime * result
				+ ((sharpness == null) ? 0 : sharpness.hashCode());
		result = prime * result
				+ ((subjectDistance == null) ? 0 : subjectDistance.hashCode());
		result = prime
				* result
				+ ((subjectDistanceRange == null) ? 0 : subjectDistanceRange
						.hashCode());
		result = prime * result
				+ ((whiteBalance == null) ? 0 : whiteBalance.hashCode());
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
		ImageEXIF other = (ImageEXIF) obj;
		if (aperture == null) {
			if (other.aperture != null)
				return false;
		} else if (!aperture.equals(other.aperture))
			return false;
		if (brightness == null) {
			if (other.brightness != null)
				return false;
		} else if (!brightness.equals(other.brightness))
			return false;
		if (ccdWidth == null) {
			if (other.ccdWidth != null)
				return false;
		} else if (!ccdWidth.equals(other.ccdWidth))
			return false;
		if (colorSpace == null) {
			if (other.colorSpace != null)
				return false;
		} else if (!colorSpace.equals(other.colorSpace))
			return false;
		if (compressedBitsPerPixel == null) {
			if (other.compressedBitsPerPixel != null)
				return false;
		} else if (!compressedBitsPerPixel.equals(other.compressedBitsPerPixel))
			return false;
		if (contrast == null) {
			if (other.contrast != null)
				return false;
		} else if (!contrast.equals(other.contrast))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (dateTimeDigitized == null) {
			if (other.dateTimeDigitized != null)
				return false;
		} else if (!dateTimeDigitized.equals(other.dateTimeDigitized))
			return false;
		if (dateTimeOriginal == null) {
			if (other.dateTimeOriginal != null)
				return false;
		} else if (!dateTimeOriginal.equals(other.dateTimeOriginal))
			return false;
		if (digitalZoomRatio == null) {
			if (other.digitalZoomRatio != null)
				return false;
		} else if (!digitalZoomRatio.equals(other.digitalZoomRatio))
			return false;
		if (exposureBiasValue == null) {
			if (other.exposureBiasValue != null)
				return false;
		} else if (!exposureBiasValue.equals(other.exposureBiasValue))
			return false;
		if (exposureMode == null) {
			if (other.exposureMode != null)
				return false;
		} else if (!exposureMode.equals(other.exposureMode))
			return false;
		if (exposureProgram == null) {
			if (other.exposureProgram != null)
				return false;
		} else if (!exposureProgram.equals(other.exposureProgram))
			return false;
		if (exposureTime == null) {
			if (other.exposureTime != null)
				return false;
		} else if (!exposureTime.equals(other.exposureTime))
			return false;
		if (flash == null) {
			if (other.flash != null)
				return false;
		} else if (!flash.equals(other.flash))
			return false;
		if (focalLength == null) {
			if (other.focalLength != null)
				return false;
		} else if (!focalLength.equals(other.focalLength))
			return false;
		if (focalLengthIn35mmFilm == null) {
			if (other.focalLengthIn35mmFilm != null)
				return false;
		} else if (!focalLengthIn35mmFilm.equals(other.focalLengthIn35mmFilm))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (iso == null) {
			if (other.iso != null)
				return false;
		} else if (!iso.equals(other.iso))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (lightSource == null) {
			if (other.lightSource != null)
				return false;
		} else if (!lightSource.equals(other.lightSource))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (metering == null) {
			if (other.metering != null)
				return false;
		} else if (!metering.equals(other.metering))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (saturation == null) {
			if (other.saturation != null)
				return false;
		} else if (!saturation.equals(other.saturation))
			return false;
		if (sensingMethod == null) {
			if (other.sensingMethod != null)
				return false;
		} else if (!sensingMethod.equals(other.sensingMethod))
			return false;
		if (sharpness == null) {
			if (other.sharpness != null)
				return false;
		} else if (!sharpness.equals(other.sharpness))
			return false;
		if (subjectDistance == null) {
			if (other.subjectDistance != null)
				return false;
		} else if (!subjectDistance.equals(other.subjectDistance))
			return false;
		if (subjectDistanceRange == null) {
			if (other.subjectDistanceRange != null)
				return false;
		} else if (!subjectDistanceRange.equals(other.subjectDistanceRange))
			return false;
		if (whiteBalance == null) {
			if (other.whiteBalance != null)
				return false;
		} else if (!whiteBalance.equals(other.whiteBalance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImageEXIF [id=" + id + ", key=" + key + ", aperture="
				+ aperture + ", brightness=" + brightness + ", ccdWidth="
				+ ccdWidth + ", colorSpace=" + colorSpace
				+ ", compressedBitsPerPixel=" + compressedBitsPerPixel
				+ ", contrast=" + contrast + ", dateTime=" + dateTime
				+ ", dateTimeDigitized=" + dateTimeDigitized
				+ ", dateTimeOriginal=" + dateTimeOriginal
				+ ", digitalZoomRatio=" + digitalZoomRatio
				+ ", exposureBiasValue=" + exposureBiasValue
				+ ", exposureMode=" + exposureMode + ", exposureProgram="
				+ exposureProgram + ", exposureTime=" + exposureTime
				+ ", flash=" + flash + ", focalLength=" + focalLength
				+ ", focalLengthIn35mmFilm=" + focalLengthIn35mmFilm + ", iso="
				+ iso + ", lightSource=" + lightSource + ", make=" + make
				+ ", metering=" + metering + ", model=" + model
				+ ", saturation=" + saturation + ", sensingMethod="
				+ sensingMethod + ", sharpness=" + sharpness
				+ ", subjectDistance=" + subjectDistance
				+ ", subjectDistanceRange=" + subjectDistanceRange
				+ ", whiteBalance=" + whiteBalance + "]";
	}
}

package com.github.jkschoen.jsma;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jkschoen.jsma.misc.SmugMugException;
import com.github.jkschoen.jsma.model.Theme;
import com.github.jkschoen.jsma.response.SMResponse;
import com.github.jkschoen.jsma.response.ThemesResponse;

public class ThemeAPI   extends BaseAPI{
	static final Logger logger = LoggerFactory.getLogger(ThemeAPI.class);

	private SmugMugAPI smugmug;

	protected ThemeAPI(SmugMugAPI smugmug) {
		this.smugmug = smugmug;
	}
	
	/**
	 * Retrieve a list of themes.
	 * 
	 * @param pretty return formatted JSON that is easier to read
	 * @param strict Enable strict error handling.
	 * @return
	 * @throws SmugMugException
	 */
	public List<Theme> get(boolean pretty, boolean strict) throws SmugMugException{
		logger.debug("get() called");
		
		ThemesResponse requestToken = SMResponse.callMethod(this.smugmug,ThemesResponse.class, "smugmug.themes.get", null, null, pretty, false, strict, false);
		logger.debug("get() result: "+(requestToken == null ? "null" : requestToken.toString()));
		return requestToken.getThemes();
	}

}

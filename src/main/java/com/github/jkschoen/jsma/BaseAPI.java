package com.github.jkschoen.jsma;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public abstract class BaseAPI {

	/**
	 * Converts a String [] to a comma separated string.
	 * 
	 * @param array
	 * @return
	 */
	protected String convertToString(String[] array){
		String string = "";
		for (String s : array){
			if (string.length() > 0){
				string = string + ",";
			}
			string = string+s;
		}
		return string;
	}
	
	/**
	 * This is handy for create/change methods to have the ability to
	 * request a list of extra fields to be returned. This will loop 
	 * through those fields, pull the value from the result and set
	 * them to the original.
	 * 
	 * I made the decisions to not catch any of the reflection exceptions
	 * here, since there isn't anything I can actually to but move on. I would
	 * rather it blow up, so I know what needs to be fixed. Instead of hiding
	 * it under the rug.
	 * 
	 * @param original the object to set values to
	 * @param result the object to pull values from
	 * @param fields the fields to be set
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	protected <T> void setExtras(T original, T result, String[] fields) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		if (original == null || result == null){
			return;
		}
		
		Class<?> clazz = original.getClass();
		//loop through and find out fields
		for (String jsonField : fields){
			//need to convert the json field to the field in the class name
			//most of the time it is a matter of making the first letter 
			//lowercase
			String uncapField = StringUtils.uncapitalize(jsonField);
			//for special cases we will maintain a map and swap them out.
			if (BaseAPI.FIELD_NAME_MAP.containsKey(uncapField)){
				uncapField = BaseAPI.FIELD_NAME_MAP.get(uncapField);
			}
			//get the field
			Field f = clazz.getField(uncapField);
			//get the value
			Object value = f.get(result);
			//set the value
			f.set(original, value);
		}
	}
	
	private static Map<String, String> FIELD_NAME_MAP;
	
	static {
		FIELD_NAME_MAP = new HashMap<String, String>();
		FIELD_NAME_MAP.put("protected", "protectedRightClick");
		FIELD_NAME_MAP.put("public", "publicAlbum");
	}
}

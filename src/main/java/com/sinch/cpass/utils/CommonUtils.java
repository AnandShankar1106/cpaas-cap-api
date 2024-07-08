package com.sinch.cpass.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CommonUtils {
	
	  public static String replaceLast(String string, String toReplace, String replacement) {
	        int pos = string.lastIndexOf(toReplace);
	        if (pos > -1){
	            return string.substring(0, pos) + replacement + string.substring(pos + toReplace.length());
	        } else {
	            return string;
	        }
	    }
	  
	  public static UUID uuid(String s) {

	        try {
	            return UUID.fromString(s);
	        } catch (Exception e) {
	            // do nothing
	        }

	        return null;
	    }

}

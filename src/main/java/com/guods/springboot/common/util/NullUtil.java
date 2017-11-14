package com.guods.springboot.common.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;


public class NullUtil {
	
	public static String eraseNull(String input){
		if(null == input) {
			return "";
		} else {
			return input;
		}
	}
	public static boolean isEmpty(Collection<?> obj)
    {
        return obj == null || obj.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> obj)
    {
        return obj == null || obj.isEmpty();
    }

    public static boolean isEmpty(long[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(int[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(short[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(double[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(float[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(Object[] obj)
    {
        return obj == null || obj.length == 0;
    }

    public static boolean isEmpty(String obj)
    {
        return obj == null || obj.trim().length() == 0;
    }

    public static boolean isEmpty(StringBuffer obj)
    {
        return obj == null || obj.toString().trim().length() == 0;
    }

    public static boolean isEmpty(StringBuilder obj)
    {
        return obj == null || obj.toString().trim().length() == 0;
    }

    public static boolean isNotEmpty(Collection<?> obj)
    {
        return obj != null && !obj.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> obj)
    {
        return obj != null && !obj.isEmpty();
    }

    public static boolean isNotEmpty(long[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(int[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(short[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(double[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(float[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(Object[] obj)
    {
        return obj != null && obj.length != 0;
    }

    public static boolean isNotEmpty(String obj)
    {
        return obj != null && obj.trim().length() != 0;
    }

    public static boolean isNotEmpty(StringBuffer obj)
    {
        return obj != null && obj.toString().trim().length() != 0;
    }

    public static boolean isNotEmpty(StringBuilder obj)
    {
        return obj != null && obj.toString().trim().length() != 0;
    }
    
    public static BigDecimal nullTo0(BigDecimal input){
    	if(null == input){
    		return new BigDecimal(0);    	
    	} else {
    		return input;
    	}
    }
}

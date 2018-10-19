package com.wangzunbin.pss.util;

public class StringUtil {

	private StringUtil() {
	}

	/**
	 * 判断字符串是否有长度
	 * @param str 需判断都的字符串
	 * @return 如果字符串有值,则返回true,如果字符串为null or "" or " ",则返回false
	 */
	public static boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}

package com.example.admin.leiyun_ic.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularUtils {

	/**
	 * 验证身份证号码
	 * 
	 * @param idCard
	 *            居民身份证号码15位或18位，最后一位可能是数字或字母
	 * @return 验证成功返回true，验证失败返回false
	 */
	/*public static boolean checkIdCard(String idCard) {
		String regex ="^d{15}|d{}18$";
		return Pattern.matches(regex, idCard);
	}*/
	public static boolean personIdValidation(String text) {
		boolean flag;
		  String regx = "[0-9]{17}x";
		  String reg1 = "[0-9]{15}";
		  String regex = "[0-9]{18}";
		  flag = text.matches(regx) || text.matches(reg1) || text.matches(regex);
		  return flag;
		 }

	/**
	 * 验证中文
	 * 
	 * @param chinese
	 *            中文字符
	 * @return 验证成功返回true，验证失败返回false
	 */
	public static boolean checkChinese(String chinese) {
		String regex = "^[\u4E00-\u9FA5]+$";
		return Pattern.matches(regex, chinese);
	}
	//验证手机号
	public static boolean checkMobile(String mobile) {
		String regex = "(\\+\\d+)?1[34578]\\d{9}$";
		return Pattern.matches(regex, mobile);
	}
	//验证只有字母和数字
	public static boolean checkPwd(String password){
		String isPwd="^[a-zA-Z0-9_]+$";
		return Pattern.matches(isPwd, password);
		
	}
	public static boolean checkIdcard(String value) {
		 int length = 0;
		 if (value == null) {
		   return false;
		 } else {
		   length = value.length();
		   if (length != 15) {} else if (length != 18) {} else {
		     return false;
		   }
		 }
		 String[] areasArray = { "11", "12", "13", "14", "15", "21", "22", "23", "31",
		               "32", "33", "34", "35", "36", "37", "41", "42", "43", "44",
		               "45", "46", "50", "51", "52", "53", "54", "61", "62", "63",
		               "64", "65", "71", "81", "82", "91" };


		 HashSet < String > areasSet = new HashSet < String > (Arrays.asList(areasArray));
		 String valueStart2 = value.substring(0, 2);


		 if (areasSet.contains(valueStart2)) {} else {
		   return false;
		 }
		 
		 Pattern pattern = null;
		 Matcher matcher = null;


		 int year = 0;
		 switch (length) {
		 case 15:
		   year = Integer.parseInt(value.substring(6, 8)) + 1900;


		   if (year % 4 == 0 || (year % 100 == 0 && year % 4 == 0)) {
		     pattern = Pattern.compile("^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$"); // 测试出生日期的合法性
		   } else {
		     pattern = Pattern.compile("^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$"); // 测试出生日期的合法性
		   }
		   matcher = pattern.matcher(value);
		   if (matcher.find()) {
		     return true;
		   } else {
		     return false;
		   }
		 case 18:
		   year = Integer.parseInt(value.substring(6, 10));


		   if (year % 4 == 0 || (year % 100 == 0 && year % 4 == 0)) {
		     pattern = Pattern.compile("^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$"); // 测试出生日期的合法性
		   } else {
		     pattern = Pattern.compile("^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$"); // 测试出生日期的合法性
		   }


		   matcher = pattern.matcher(value);
		   if (matcher.find()) {
		     int S = (Integer.parseInt(value.substring(0, 1)) + Integer.parseInt(value.substring(10, 11))) * 7 + (Integer.parseInt(value.substring(1, 2)) + Integer.parseInt(value.substring(11, 12))) * 9 + (Integer.parseInt(value.substring(2, 3)) + Integer.parseInt(value.substring(12, 13))) * 10 + (Integer.parseInt(value.substring(3, 4)) + Integer.parseInt(value.substring(13, 14))) * 5 + (Integer.parseInt(value.substring(4, 5)) + Integer.parseInt(value.substring(14, 15))) * 8 + (Integer.parseInt(value.substring(5, 6)) + Integer.parseInt(value.substring(15, 16))) * 4 + (Integer.parseInt(value.substring(6, 7)) + Integer.parseInt(value.substring(16, 17))) * 2 + Integer.parseInt(value.substring(7, 8)) * 1 + Integer.parseInt(value.substring(8, 9)) * 6 + Integer.parseInt(value.substring(9, 10)) * 3;
		     int Y = S % 11;
		     String M = "F";
		     String JYM = "10X98765432";
		     M = JYM.substring(Y, Y + 1); // 判断校验位
		     if (M.equals(value.substring(17, 18))) {
		       return true; // 检测ID的校验位
		     } else {
		       return false;
		     }
		   } else {
		     return false;
		   }
		 default:
		   return false;
		 }
	
	}
	
	
	
	
	
}

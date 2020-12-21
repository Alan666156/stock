package com.stock.util;

import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.google.i18n.phonenumbers.geocoding.PhoneNumberOfflineGeocoder;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * 手机归属地/运营商/号码验证 查询工具类
 * @author fuhongxing
 */
public class PhoneUtil {

    private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    private static PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();

    private static PhoneNumberOfflineGeocoder geocoder = PhoneNumberOfflineGeocoder.getInstance();
    
    /** 直辖市*/
    private static final String[] CITIES = {"北京市","上海市","天津市","重庆市"};
    
    /** 自治区*/
    private static final String[] PROVINCES = {"新疆","西藏","宁夏","内蒙古","广西"};
    /**
     * 中国城市code
     */
    private static int code = 86;


    /**
     * 根据国家代码和手机号  判断手机号是否有效
     * @param phoneNumber 手机号码
     * @return
     */
    public static boolean checkPhoneNumber(String phoneNumber){
        Long phone = 0L;
        //针对固定电话处理
        if(phoneNumber.contains("-")){
            String [] arrays = StringUtils.split(phoneNumber, "-");
            phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
            phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
            phone = Long.valueOf(phoneNumber);
        }
        return phoneNumberUtil.isValidNumber(new PhoneNumber().setCountryCode(86).setNationalNumber(phone));
    }

    /**
     * 根据国家代码和手机号  判断手机号是否有效
     * @param phoneNumber 手机号码
     * @param countryCode 国家code(86)
     * @return
     */
    public static boolean checkPhoneNumber(String phoneNumber, String countryCode){
        Long phone = null;
        //针对固定电话处理
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }
        return phoneNumberUtil.isValidNumber(new PhoneNumber().setCountryCode(Integer.valueOf(countryCode)).setNationalNumber(phone));
    }

    /**
     * 查询手机归属地和运营商信息
     * @param phoneNumber 手机号码
     * @param countryCode 国家code(中国86)
     * @return 返回归属地和运营商信息
     */
    public static String getCityAndCarrier(String phoneNumber, String countryCode){
    	Long phone = null;
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }
        PhoneNumber pn = new PhoneNumber()
                .setCountryCode(Integer.valueOf(countryCode))
                .setNationalNumber(phone);
        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(pn, Locale.ENGLISH);
        String carrierZh = "";
        //获取归属地
        carrierZh += geocoder.getDescriptionForNumber(pn, Locale.CHINESE);
        switch (carrierEn) {
	        case "China Mobile":
	            carrierZh += "移动";
	            break;
	        case "China Unicom":
	            carrierZh += "联通";
	            break;
	        case "China Telecom":
	            carrierZh += "电信";
	            break;
	        default:
	            break;
        }
        return carrierZh;
    }
    
    /**
     *  查询手机运营商信息
     * @param phoneNumber 手机号码
     * @param countryCode 国家code(中国86)
     * @return 返回运营商信息
     */
    public static String getCarrier(String phoneNumber, String countryCode){
    	Long phone = null;
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }

        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(new PhoneNumber().setCountryCode(Integer.valueOf(countryCode)).setNationalNumber(phone), Locale.ENGLISH);
        //获取运营商
        String carrierZh = "";
        switch (carrierEn) {
	        case "China Mobile":
	            carrierZh += "移动";
	            break;
	        case "China Unicom":
	            carrierZh += "联通";
	            break;
	        case "China Telecom":
	            carrierZh += "电信";
	            break;
	        default:
	            break;
        }
        return carrierZh;
    }
    /**
     *  查询中国手机运营商信息
     * @param phoneNumber 手机号码
     * @return 返回运营商信息(1：移动，2：联通，3：电信)
     */
    public static String getCarrierFromMobile(String phoneNumber){
        if(phoneNumber == null || "".equals(phoneNumber)){
            return null;
        }

        Long phone = null;
        if(phoneNumber.contains("-")){
            String [] arrays = StringUtils.split(phoneNumber, "-");
            phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
            phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
            phone = Long.valueOf(phoneNumber);
        }
        String carrierEn = carrierMapper.getNameForNumber(new PhoneNumber().setCountryCode(Integer.valueOf(code)).setNationalNumber(phone), Locale.ENGLISH);
        //获取运营商
        String carrierZh = "";
        switch (carrierEn) {
            case "China Mobile":
                carrierZh = "1";
                break;
            case "China Unicom":
                carrierZh = "2";
                break;
            case "China Telecom":
                carrierZh = "3";
                break;
            default:
                break;
        }
        return carrierZh;
    }
    /**
     *  查询中国手机运营商信息
     * @param phoneNumber 手机号码
     * @return 返回运营商信息
     */
    public static String getCarrier(String phoneNumber){
    	if(phoneNumber == null || "".equals(phoneNumber)){
    		return null;
    	}
    	
    	Long phone = null;
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }
        //返回结果只有英文，自己转成成中文
        String carrierEn = carrierMapper.getNameForNumber(new PhoneNumber().setCountryCode(Integer.valueOf(code)).setNationalNumber(phone), Locale.ENGLISH);
        //获取运营商
        String carrierZh = "";
        switch (carrierEn) {
	        case "China Mobile":
	            carrierZh += "移动";
	            break;
	        case "China Unicom":
	            carrierZh += "联通";
	            break;
	        case "China Telecom":
	            carrierZh += "电信";
	            break;
	        default:
	            break;
        }
        return carrierZh;
    }

    /**
     * 
    * 根据国家代码和手机号查询手机归属地信息
    * @param phoneNumber 手机号码
    * @param countryCode 国家code(中国86)
    * @return    省市
     */
    public static String getCity(String phoneNumber, String countryCode){
    	int code = Integer.valueOf(countryCode);
    	Long phone = 0L;
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }
        //获取归属地
        return geocoder.getDescriptionForNumber(new PhoneNumber().setCountryCode(Integer.valueOf(code)).setNationalNumber(phone), Locale.CHINESE);
    }
    
    /**
     * 
    * 查询中国手机号归属地信息
    * @param phoneNumber 手机号码
    * @return    省市
     */
    public static String getCity(String phoneNumber){
    	if(phoneNumber == null || "".equals(phoneNumber)){
    		return "";
    	}
    	Long phone = null;
		//针对固定电话处理
        if(phoneNumber.contains("-")){
			String [] arrays = StringUtils.split(phoneNumber, "-");
			phoneNumber = arrays.length > 2 ? arrays[0] + arrays[1] : phoneNumber;
        	phone = Long.valueOf(phoneNumber.replace("-", ""));
        }else{
        	phone = Long.valueOf(phoneNumber);
        }
        //获取归属地
        return geocoder.getDescriptionForNumber(new PhoneNumber().setCountryCode(Integer.valueOf(code)).setNationalNumber(phone), Locale.CHINESE);
    }


    


}
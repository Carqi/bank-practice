package com.bankManagementSystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChk {
	 /** 
     * 手机号码验证,11位，不知道详细的手机号码段，只是验证开头必须是1和位数 
     * */  
    public boolean checkCellPhone(String cellPhoneNr)  
    {  
        String reg="^[1][\\d]{10}";  
        return startCheck(reg,cellPhoneNr);  
    }
    
    public  boolean startCheck(String reg,String string)  
    {  
        boolean tem=false;  
          
        Pattern pattern = Pattern.compile(reg);  
        Matcher matcher=pattern.matcher(string);  
          
        tem=matcher.matches();  
        return tem;  
    }
}

package com.bankManagementSystem.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChk {
	 /** 
     * �ֻ�������֤,11λ����֪����ϸ���ֻ�����Σ�ֻ����֤��ͷ������1��λ�� 
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

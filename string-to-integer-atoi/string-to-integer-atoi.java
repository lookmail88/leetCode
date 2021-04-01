class Solution {
        char minus = "-".charAt(0);
        char plus = "+".charAt(0);
        

    
    public int myAtoi(String s) {      

        
       String str = getNumString(s);
        
       if (outOfRange(str)) return  getClampedValue(str);
        
 
       Long l = Long.parseLong(str);
       Long maxInt = Long.parseLong(Integer.toString(Integer.MAX_VALUE));
       Long minInt = Long.parseLong(Integer.toString(Integer.MIN_VALUE));
       if(l>=maxInt) return Integer.MAX_VALUE;
       if(l<=minInt) return Integer.MIN_VALUE; 
        return Integer.parseInt(str);
    }
    
    private boolean outOfRange(String s){
        boolean rv = false;
        if(Long.toString(Long.MAX_VALUE).length()-1<s.length()) return true;    
        return rv;
    }
    
    private int getClampedValue(String s){
        int rv = Integer.MAX_VALUE;
        if (Character.compare(s.charAt(0),minus)==0)return Integer.MIN_VALUE; 
        return rv;
    }
    

    
    private String getNumString(String s){
        int sp =0;
        int ep =0;

        boolean found1st=false;
        boolean withSign = false;
        boolean foundNoneDigital = false;
        String sign = "";
        
        if (s.length()<1) return "0";
        if (s.trim().length()==0) return "0";
        
        for (int i =0; i<s.length();i++){
            char c = s.charAt(i);
            
            if(!found1st&&Character.isSpaceChar(c))continue;
            if(!found1st && (Character.compare(c,minus)==0||Character.compare(c,plus)==0)){
                if(s.length()==1)return "0";
                withSign = true;
                sign = String.valueOf(c);
                sp = i;
                found1st =true;
                continue;
            }
            if(!found1st&&!Character.isDigit(c))return "0";
            
            if(!found1st && Character.isDigit(c)){
                sp = i;
                found1st =true;
                continue;
            }
            
            if(found1st&&!Character.isDigit(c)&&withSign&&i==sp+1)return "0";
                                    
            if(found1st&&!Character.isDigit(c)){
                ep=i;
                foundNoneDigital = true;
                break;
            }  
            ep=i;
        }
        
        String str = s.substring(sp);
        if (foundNoneDigital) str = s.substring(sp,ep);
        
        
        System.out.println("sp:"+sp+",ep:"+ep+",length:"+s.length());
        System.out.println("["+str+"]");
        

        if (withSign)str = str.substring(1);
        str = str.replaceAll("^0+", "");
        
         if (str.length()<1) str= "0";
        if (str.trim().length()==0) str= "0";
        
        return sign+str;
    }
    
    
    
}
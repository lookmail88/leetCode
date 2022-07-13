class Solution {
     
    public List<String> fizzBuzz(int n) {
      List<String> ls = new ArrayList<>();
      
      for (int num = 1; num <= n; num++) {     
            if(mod3(num)==0&&mod5(num)==0){
                ls.add("FizzBuzz");
            }else if(mod3(num)==0){
                ls.add("Fizz");
            }else if(mod5(num)==0){
                ls.add("Buzz");
            }else{
               ls.add(Integer.toString(num)) ;
            }
      }  
      return ls;
    }
    
    private int mod3(int n){
        return n%3;
    }
    private int mod5(int n){
        return n%5;
    }
}
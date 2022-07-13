class Solution {
    static Map<String, Integer> values = new HashMap<>();
    
     static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        int max = 0;
        String[] ar = s.split("");
        for (int i = ar.length-1;i>=0;i--){
            int curr=values.get(ar[i]);
            if (curr>=max) {
                max = curr;
                sum=sum + curr;
            }
            else{
                sum = sum - curr;
            }
        }
        return sum;
    }
}
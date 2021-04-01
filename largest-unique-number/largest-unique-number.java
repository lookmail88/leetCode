class Solution {
    public int largestUniqueNumber(int[] A) {
       
       Map<Integer,Integer> unique = new HashMap();

        for (int i=0;i<A.length;i++){
            if(null==unique.get(A[i])){
                unique.put(A[i],1);
                continue;
            }
            unique.put(A[i],unique.get(A[i])+1);
        }

        List<Integer> uniqueList = unique.entrySet().stream()
                .filter(x->x.getValue()==1)
                .map(x->x.getKey())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                ;
        
       if(uniqueList.isEmpty()) return -1;
        
       return uniqueList.get(0);     
    }
}
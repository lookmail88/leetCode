class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double l = 0, r = 0;
        for(int i = 0; i < stations.length - 1; i++) r = Math.max(r, stations[i + 1] - stations[i]);
        while(r - l > 1e-6){
            double mid = l + (r - l) / 2;
            if(possible(stations, mid, K)){
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean possible(int[] stations, double gap, int K){
        int count = 0;
        for(int i = 0; i < stations.length - 1; i++){
            int space = stations[i + 1] - stations[i];
            if(space > gap){
                count += Math.floor(space / gap);
            }
        }
        return count <= K;
    }
}
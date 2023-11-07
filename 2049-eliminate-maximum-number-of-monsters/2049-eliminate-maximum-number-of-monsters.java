class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] timeTaken = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            timeTaken[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }
        Arrays.sort(timeTaken);
        int bullets = timeTaken[0] - 1;
        for (int i = 1; i < dist.length; i++) {    
            bullets += timeTaken[i] - timeTaken[i - 1];
            bullets--;
            if (bullets < 0) {
                return i;
            }     
            
        }
        return dist.length;
    }
}
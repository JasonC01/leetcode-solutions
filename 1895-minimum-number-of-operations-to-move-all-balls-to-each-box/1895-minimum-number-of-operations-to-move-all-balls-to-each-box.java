class Solution {
    public int[] minOperations(String boxes) {
        int[] pref = new int[boxes.length()];
        int[] suf = new int[boxes.length()];
        int[] prefCount = new int[boxes.length()];
        int[] sufCount = new int[boxes.length()];
        prefCount[0] = Integer.parseInt(String.valueOf(boxes.charAt(0)));
        sufCount[boxes.length() - 1] = Integer.parseInt(String.valueOf(boxes.charAt(boxes.length() - 1)));
        pref[0] = 0;
        suf[boxes.length() - 1] = 0;
        for (int i = 1; i < boxes.length(); i++) {
            prefCount[i] = prefCount[i - 1] + Integer.parseInt(String.valueOf(boxes.charAt(i)));
            sufCount[boxes.length() - 1 - i]  = sufCount[boxes.length() - i] + Integer.parseInt(String.valueOf(boxes.charAt(boxes.length() - 1 - i)));
            pref[i] = prefCount[i - 1] + pref[i - 1];
            suf[boxes.length() - 1 - i] = sufCount[boxes.length() - i] + suf[boxes.length() - i];
        }
        // System.out.println(Arrays.toString(pref));
        // System.out.println(Arrays.toString(suf));
        // System.out.println(Arrays.toString(prefCount));
        // System.out.println(Arrays.toString(sufCount));
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pref[i] + suf[i];
        }
        return ans;
    }
}
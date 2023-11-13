class Solution {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        while (sb.length() < s.length()) {
            if (isVowel(s.charAt(index1))) {
                while (!isVowel(chars[index2])) {
                    index2++;
                }
                sb.append(chars[index2]);
                index1++;
                index2++;
            } else {
                sb.append(s.charAt(index1));
                index1++;
            }
        }
        return sb.toString();
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
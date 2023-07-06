class Solution {
    public String reverseVowels(String s) {
        List<Integer> vowelIndex = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                vowelIndex.add(i);
            }
        }
        for (int i = 0; i < vowelIndex.size() / 2; i++) {
            char temp = s.charAt(vowelIndex.get(i));
            sb.setCharAt(vowelIndex.get(i), s.charAt(vowelIndex.get(vowelIndex.size() - 1 - i)));
            sb.setCharAt(vowelIndex.get(vowelIndex.size() - 1 - i), temp);
        }
        return sb.toString();
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
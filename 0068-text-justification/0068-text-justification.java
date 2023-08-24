class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int currLength = 0;
        List<String> currWords = new ArrayList<>();
        for (String s : words) {
            if (currLength + currWords.size() + s.length() > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int spaceLength = currWords.size() == 1 ? 0 : Math.floorDiv(maxWidth - currLength, currWords.size() - 1);
                int extraSpace = currWords.size() == 1 ? maxWidth - currLength : maxWidth - (currWords.size() - 1) * spaceLength - currLength;
                while (currWords.size() > 1) {
                    sb.append(currWords.remove(0));
                    if (extraSpace > 0) {
                        extraSpace--;
                        sb.append(" ".repeat(spaceLength + 1));
                    } else {
                        sb.append(" ".repeat(spaceLength));
                    }
                }
                sb.append(currWords.remove(0));
                if (extraSpace > 0) {
                    sb.append(" ".repeat(extraSpace));
                }
                res.add(sb.toString());
                currWords.add(s);
                currLength = s.length();
            } else {
                currLength += s.length();
                currWords.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        int extraSpace = maxWidth - (currWords.size() - 1) - currLength;
        while (currWords.size() > 1) {
            sb.append(currWords.remove(0));
            sb.append(" ");
        }
        sb.append(currWords.remove(0));
        if (extraSpace > 0) {
            sb.append(" ".repeat(extraSpace));
        }
        res.add(sb.toString());

        return res;
    }
}
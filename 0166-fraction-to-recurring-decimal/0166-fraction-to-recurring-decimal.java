class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        StringBuilder mantissa = new StringBuilder();
        HashMap<Integer,Integer> map = new HashMap<>();
        sb.append(numerator / (long) denominator);
        System.out.println(numerator / (long) denominator);
        int rem = Math.abs(Math.abs(numerator) % Math.abs(denominator));
        System.out.println(rem);
        if (rem == 0) {
            return sb.toString();
        }
        if (sb.charAt(0) == '0' && (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.insert(0, "-");
        }
        sb.append(".");
        int index = 0;
        while (rem > 0 && !map.containsKey(rem)) {
            map.put(rem, index++);
            int[] res = divide(rem, Math.abs(denominator));
            mantissa.append(Math.abs(res[0]));
            rem = res[1];
        }
        if (rem == 0) {
            return sb.append(mantissa).toString();
        }
        System.out.println(rem);
        mantissa.insert(map.get(rem), "(");
        sb.append(mantissa);
        sb.append(")");
        return sb.toString();
    }

    public int[] divide(int numerator, int denominator) {
        return new int[]{(int) (numerator * 10L / (long) denominator), Math.abs((int) ((numerator * 10L) % denominator))};    
    }
}
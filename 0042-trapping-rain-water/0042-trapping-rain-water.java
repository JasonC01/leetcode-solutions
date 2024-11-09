class Solution {
    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }
        int index = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> widthStack = new Stack<>();
        while (index < height.length) {
            // System.out.println(stack);
            if (stack.isEmpty() || stack.peek() > height[index]) {
                stack.push(height[index++]);
                widthStack.push(1);
            } else {
//                int popCount = 0;
                int minusValue = 0;
                int total = 0;
                while (stack.size() > 1 && stack.peek() < height[index]) {
                    int sVal = stack.pop();
                    int wVal = widthStack.pop();
                    total += wVal;
                    minusValue += sVal * wVal;
                }
                int low = stack.pop();
                int lw = widthStack.pop();
                ans += (total * Math.min(height[index], low)) - minusValue;
                if (low > height[index]) {
                    stack.push(low);
                    widthStack.push(lw);
                    stack.push(height[index]);
                    widthStack.push(total + 1);
//                    for (int i = 0; i <= popCount; i++) {
//                        stack.push(height[index]);
//                    }
                } else {
                    if (stack.isEmpty()) {
                        stack.push(height[index]);
                        widthStack.push(1);
                    } else {
                        stack.push(height[index]);
                        widthStack.push(total + lw + 1);
                    }
                    
//                    for (int i = 0; i <= popCount + 1; i++) {
//                        stack.push(height[index]);
//                    }
                }
                index++;
                // System.out.println(ans);
            }
        }
        // System.out.println(stack);
        return ans;
    }
}
//           0 
// 0         0
// 0     0   0
// 0 0   0 0 0
// 0 0 _ 0 0 0
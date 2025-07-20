class Solution {

func jump(_ nums: [Int]) -> Int {
    var memo: [Int] = []
    for i in 0...nums.count - 1 {
        memo.append(Int.max)
    }
    return helper(nums, at: 0, jumps: 0, memo: &memo)
}

func helper(_ nums: [Int], at index: Int, jumps: Int, memo: inout [Int]) -> Int {
    if index == nums.count - 1 {
        return jumps
    }
    var ans = Int.max
    if (nums[index] == 0) {
        return ans
    }
    if memo[index] != Int.max {
        return memo[index] + jumps
    }
    for i in 1...nums[index] {
        if index + i < nums.count {
            ans = min(ans, helper(nums, at: index + i, jumps: jumps + 1, memo: &memo))
        } else {
            break
        }
    }
    memo[index] = ans - jumps
    return ans
}
}
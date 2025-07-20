class Solution {
    func permute(_ nums: [Int]) -> [[Int]] {
    return helper(nums, [])
}

func helper(_ nums: [Int], _ curr: [Int]) -> [[Int]] {
    var ans: [[Int]] = []
    if nums.isEmpty {
        let res: [Int] = curr
        ans.append(res)
        return ans
    }
    for i in 0..<nums.count {
        var newNums: [Int] = nums
        var newCurr: [Int] = curr
        newNums.remove(at: i)
        newCurr.append(nums[i])
        ans.append(contentsOf: helper(newNums, newCurr))
    }
    return ans
}



}
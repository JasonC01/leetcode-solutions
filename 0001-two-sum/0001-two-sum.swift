class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
    var answer: [Int] = []
    var numsWithIndex: [[Int]] = []
    for i in 0..<nums.count {
        numsWithIndex.append([i, nums[i]])
    }
    let sorted: [[Int]] = numsWithIndex.sorted {$0[1] <= $1[1]}
    var low: Int = 0
    var high: Int = nums.count - 1
    while low < high {
        let sum = sorted[low][1] + sorted[high][1]
        if sum == target {
            answer.append(sorted[low][0])
            answer.append(sorted[high][0])
            return answer
        } else if sum > target {
            high -= 1
        } else {
            low += 1
        }
    }
    return answer
}
}
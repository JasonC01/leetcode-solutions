/**
 * @param {number[][]} isWater
 * @return {number[][]}
 */
var highestPeak = function(isWater) {
    let queue = [];
    let ans = [];
    let visited = [];
    for (let i = 0; i < isWater.length; i++) {
        ans.push([]);
        visited.push([]);
        for (let j = 0; j < isWater[0].length; j++) {
            if (isWater[i][j] === 1) {
                queue.push([i, j]);
            }
            visited[i].push(false);
            ans[i].push(0);
        }
    }
    let currLevel = 0;
    let levelSize = queue.length;
    let index = 0;
    while (index < queue.length) {
        let curr = queue[index];
        let i = curr[0];
        let j = curr[1];
        levelSize--;
        if (i >= 0 && j >= 0 && i < isWater.length && j < isWater[0].length && !visited[i][j]) {
            queue.push([i + 1, j]);
            queue.push([i - 1, j]);
            queue.push([i, j + 1]);
            queue.push([i, j - 1]);
            ans[i][j] = currLevel;
            visited[i][j] = true;
        }
        if (levelSize === 0) {
            currLevel++;
            levelSize = queue.length - index - 1;
        }
        index++;
    }
    return ans;
};
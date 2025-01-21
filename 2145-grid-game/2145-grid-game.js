/**
 * @param {number[][]} grid
 * @return {number}
 */
var gridGame = function(grid) {
    if (grid[0].length == 1) {
        return 0;
    }
    let pref = [];
    let suf = [];
    for (let i = 0; i < grid[0].length; i++) {
      pref.push(0);
      suf.push(0);
    }
    pref[0] = grid[1][0];
    suf[suf.length - 1] = grid[0][grid[0].length - 1];
    for (let i = 1; i < grid[0].length; i++) {
      pref[i] = pref[i - 1] + grid[1][i];
      suf[grid[0].length - 1 - i] = suf[grid[0].length - i] + grid[0][grid[0].length - 1 - i];
    }
    // console.log(suf);
    // console.log(pref);
    let ans = Math.min(pref[pref.length - 2], suf[1]);
    for (let i = 1; i < grid[0].length - 1; i++) {
      ans = Math.min(ans, Math.max(pref[i - 1], suf[i + 1]));
    }
    return ans;
};
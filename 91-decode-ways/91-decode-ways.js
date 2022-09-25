/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  const n = s?.length;
  const dp = new Array(n).fill(-1);
  return f(0, n, s, dp);
};

const f = (i, n, s, dp) => {
  if (i === n) return 1;
  if (dp[i] !== -1) return dp[i];

  let ctr = 0;
  for (let k = i; k < n; k++) {
    if (isValid(s?.substring(i, k + 1))) {
      ctr += f(k + 1, n, s, dp);
    }
  }
  return (dp[i] = ctr);
};

const isValid = (s) => {
  if (s[0] === "0") return false;
  if (parseInt(s, 10) > 26) return false;
  return true;
};

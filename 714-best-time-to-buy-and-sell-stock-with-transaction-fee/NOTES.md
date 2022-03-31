122. Best Time to Buy and Sell Stock II **with modification**
When selling, deduct fee from sell price,
(arr[ind] - fee) + f(ind+1,1) => (arr[ind] - fee) + dp[ind + 1][1]
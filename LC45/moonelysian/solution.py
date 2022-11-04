def jump(self, nums: List[int]) -> int:
    if len(nums) < 2:
        return 0
    
    dp = [0] * len(nums)
    j = 0

    for i in range(1, len(nums)):
        while j + nums[j] < i:
            j += 1
        dp[i] = j+1

    return dp[-1]
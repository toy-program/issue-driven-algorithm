def threeSumClosest(self, nums: List[int], target: int) -> int:     
    if (len(nums) == 3):
        return sum(nums)

    nums.sort()
    closest = float("inf")
    
    for i in range(len(nums) - 2):
        left, right = i + 1, len(nums) - 1
        
        while left < right:
            current = nums[i] + nums[left] + nums[right]
            if abs(target - current) < abs(target - closest):
                closest = current
            if current == target:
                return current
            elif current < target:
                left += 1
            else:
                right -= 1

    return closest
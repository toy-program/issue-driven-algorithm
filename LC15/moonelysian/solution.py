class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = set()
        nums.sort()
    
        for i, value in enumerate(nums[:-2]):
            if i != 0 and value == nums[i-1]:
                continue

            left = i+1
            right = len(nums)-1

            while left < right:
                if nums[left] + nums[right] + value == 0:
                    result.add((value, nums[left], nums[right]))
                    left += 1
                    right -= 1
                elif nums[left] + nums[right] + value > 0:
                    right -= 1
                else:
                    left += 1
        
        return list(map(list, result))

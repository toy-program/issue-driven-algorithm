def maxArea(self, height: List[int]) -> int:
    area = 0
    left = 0
    right = len(height) - 1
    
    while left < right:
        w = right - left
        if height[right] < height[left]:
            h = height[right]
            right -= 1
        else:
            h = height[left]
            left += 1
        area = max(area, w * h)
    return area
            
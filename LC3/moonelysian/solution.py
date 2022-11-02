def lengthOfLongestSubstring(self, s: str) -> int:
    maxLen = 0
    substring = ''
    
    for value in s:
        if value in substring:
            substring += value
            i = substring.index(value)
            substring = substring[i+1:]
        else:
            substring += value
        maxLen = max(maxLen, len(substring))
    return maxLen
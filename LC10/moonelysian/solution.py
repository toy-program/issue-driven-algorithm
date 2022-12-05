class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        
        T = [[False] * (len(s)+1) for _ in range(len(p)+1)]
        T[0][0] = True

        for i in range(1, len(p)):
            T[i+1][0] = T[i-1][0] and p[i] == '*'

        for i in range(len(p)):
            for j in range(len(s)):
                if p[i] == '*':
                    T[i+1][j+1] = T[i-1][j+1] or T[i-2][j]
                    if p[i-1] == '.' or p[i-1] == s[j]:
                        T[i+1][j+1] |= T[i+1][j]
                else:
                    T[i+1][j+1] = T[i][j] and (p[i] == s[j] or p[i] == '.')

        return T[-1][-1]

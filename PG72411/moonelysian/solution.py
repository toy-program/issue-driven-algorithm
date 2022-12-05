from itertools import combinations as com
from collections import Counter

def solution(orders, course):
    answer = []
    
    for c in course:
        temp = []
        
        for order in orders:
            combi = com(sorted(order), c)
            temp += combi
            
        counter = Counter(temp)
            
        if len(counter) != 0 and max(counter.values()) > 1:
            for key, value in counter.items():
                if value == max(counter.values()):
                    answer.append(''.join(i for i in key))

    return sorted(answer)
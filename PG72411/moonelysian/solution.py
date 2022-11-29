from itertools import combinations as com
from collections import Counter

def solution(orders, course):
    answer = []
    for c in course:
      temp = []

      for order in orders:
        combi = com(sorted(order), c)
        temp += combi

        count = Counter(temp)
        print
    return answer
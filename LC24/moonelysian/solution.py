class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return None
        
        prev, current, answer = None, head, head.next
        
        while (current and current.next):
            result = current.next
            if prev:
               prev.next = result
               
            current.next = result.next
            result.next = current

            prev = current
            current = current.next

        return answer or head

package LC24.changhoi;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> nodes = new ArrayList<>();

        ListNode curr = head;
        while(curr != null) {
            if (curr.next == null) {
                nodes.add(curr);
                break;
            }

            nodes.add(curr.next);
            nodes.add(curr);
            curr = curr.next.next;
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        nodes.get(nodes.size() - 1).next = null;

        return nodes.get(0);
    }
}

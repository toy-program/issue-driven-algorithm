package LC143.changhoi;


import java.util.ArrayList;
import java.util.List;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> original = new ArrayList<>();
        List<ListNode> ans = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            original.add(curr);
            curr = curr.next;
        }

        int l = 0, r = original.size() - 1;
        while (l <= r) {
            if (l == r) {
                ans.add(original.get(l));
                break;
            }

            ans.add(original.get(l));
            ans.add(original.get(r));
            l++;
            r--;
        }

        for (int i = 0; i < ans.size() - 1; i++) ans.get(i).next = ans.get(i + 1);
        ans.get(ans.size() - 1).next = null;
    }
}

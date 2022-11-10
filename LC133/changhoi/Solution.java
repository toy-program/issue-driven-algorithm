package LC133.changhoi;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}



class Solution {
    HashMap<Integer, Node> map = new HashMap<>();

    Node getNode(int val) {
        if (map.containsKey(val)) return map.get(val);

        Node n = new Node(val);
        map.put(val, n);

        return n;
    }

    Node clone(Node n) {
        if (n == null) return null;
        Node curr = this.getNode(n.val);
        List<Node> list = new ArrayList<>();
        for (Node neighbor : n.neighbors) {
            if (map.containsKey(neighbor.val)) {
                list.add(map.get(neighbor.val));
                continue;
            }
            list.add(clone(neighbor));
        }
        curr.neighbors = list;
        return curr;
    }

    public Node cloneGraph(Node node) {
        return clone(node);
    }
}

/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node currNode = nodes.poll();
            if (visited.contains(currNode)) {
                continue;
            }
            visited.add(currNode);
            if (!nodeMap.containsKey(currNode.val)) {
                nodeMap.put(currNode.val, new Node(currNode.val));
            }
            for (Node n : currNode.neighbors) {
                if (!nodeMap.containsKey(n.val)) {
                    nodeMap.put(n.val, new Node(n.val));
                }
                nodeMap.get(currNode.val).neighbors.add(nodeMap.get(n.val));
                nodes.add(n);
            }
        }
        return nodeMap.get(1);
    }
}
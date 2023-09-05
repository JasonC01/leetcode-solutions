/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Integer> map = new HashMap<>();
        Node curr = head;
        int index = 0;
        while (curr != null) {
            map.put(curr, index);
            index++;
            curr = curr.next;
        }
        int[] randomIndex = new int[map.size()];
        curr = head;
        Node[] newNodes = new Node[map.size()];
        index = 0;
        while (curr != null) {
            newNodes[index++] = new Node(curr.val);
            randomIndex[map.get(curr)] = curr.random == null ? -1 : map.get(curr.random);
            curr = curr.next;
        }
        for (int i = 0; i < newNodes.length; i++) {
            
            newNodes[i].next = i == newNodes.length -1 ? null : newNodes[i + 1];
            newNodes[i].random = randomIndex[i] == -1 ? null : newNodes[randomIndex[i]];
        }
        return newNodes[0];
    }
}
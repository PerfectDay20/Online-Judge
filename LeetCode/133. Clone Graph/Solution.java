import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
        UndirectedGraphNode hNode = new UndirectedGraphNode(node.label);
        map.put(node.label, hNode);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.remove();
            List<UndirectedGraphNode> list = temp.neighbors;
            List<UndirectedGraphNode> sList = map.get(temp.label).neighbors;
            for (UndirectedGraphNode n : list) {
                if (!map.containsKey(n.label)) {
                    map.put(n.label, new UndirectedGraphNode(n.label));
                    queue.add(n);
                }
                sList.add(map.get(n.label));
            }
        }
        return hNode;
    }
}
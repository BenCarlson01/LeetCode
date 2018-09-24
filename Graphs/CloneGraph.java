public class CloneGraph {

    /** I did this alone */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        return helper1(node, nodes);
    }
    
    private UndirectedGraphNode helper1(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> nodes) {
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        nodes.put(new_node.label, new_node);
        for (UndirectedGraphNode n : node.neighbors) {
            if (nodes.keySet().contains(n.label)) {
                new_node.neighbors.add(nodes.get(n.label));
            } else {
                new_node.neighbors.add(helper1(n, nodes));
            }
        }
        return new_node;
    }

    /** Slightly faster answer I got from after looking at discussion */
    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> nodes = new HashMap<>();
        return helper2(node, nodes);
    }
    
    private UndirectedGraphNode helper2(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> nodes) {
        if (nodes.keySet().contains(node.label)) {
            return nodes.get(node.label);
        }
        UndirectedGraphNode new_node = new UndirectedGraphNode(node.label);
        nodes.put(new_node.label, new_node);
        for (UndirectedGraphNode n : node.neighbors) {
            new_node.neighbors.add(helper2(n, nodes));
        }
        return new_node;
    }
}

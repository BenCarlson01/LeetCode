public class CloneGraph {

    /** I did this alone. It is very slow, but it works! */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        HashMap<Integer, Node1> map = new HashMap<>();
        for (int[] a : prerequisites) {
            if (!map.keySet().contains(a[0])) {
                map.put(a[0], new Node1(a[0]));
            }
            if (!map.keySet().contains(a[1])) {
                map.put(a[1], new Node1(a[1]));
            }
            map.get(a[0]).children.add(a[1]);
            map.get(a[1]).in_degree += 1;
        }
        int size = map.size() + 1;
        while (size != map.size()) {
            size = map.size();
            ArrayList<Integer> remove = new ArrayList<>();
            for (int n : map.keySet()) {
                if (map.get(n).in_degree == 0) {
                    for (int i : map.get(n).children) {
                        map.get(i).in_degree -= 1;
                    }
                    remove.add(n);
                }
            }
            for (int i : remove) {
                map.remove(i);
            }
        }
        return map.size() == 0;
    }
    
    private class Node1 {
        private int id, in_degree;
        private HashSet<Integer> children;
        private Node1(int id) {
            this.id = id;
            in_degree = 0;
            children = new HashSet<>();
        }
    }

    /** Faster, but still a naive solution */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] in_degree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : prerequisites) {
            if (!map.keySet().contains(a[0])) {
                map.put(a[0], new LinkedList<>());
            }
            map.get(a[0]).add(a[1]);
            in_degree[a[1]] += 1;
        }
        int size = map.size() + 1;
        List<Integer> remove;
        while (size != map.size()) {
            remove = new LinkedList<>();
            size = map.size();
            for (int i : map.keySet()) {
                if (in_degree[i] == 0) {
                    for (int j : map.get(i)) {
                        in_degree[j] -= 1;
                    }
                    remove.add(i);
                }
            }
            for (int i : remove) {
                map.remove(i);
            }
        }
        return map.size() == 0;
    }

    /** Getting better! */
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        int[] in_degree = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] a : prerequisites) {
            if (!map.keySet().contains(a[0])) {
                map.put(a[0], new LinkedList<>());
            }
            map.get(a[0]).add(a[1]);
            in_degree[a[1]] += 1;
        }
        Queue<Integer> remove = new LinkedList<>();
        for (int i : map.keySet()) {
            if (in_degree[i] == 0) {
                remove.add(i);
            }
        }
        while (!remove.isEmpty()) {
            int course = remove.poll();
            if (map.get(course) == null) {
                continue;
            }
            for (int i : map.get(course)) {
                in_degree[i] -= 1;
                if (in_degree[i] == 0) {
                    remove.add(i);
                }
            }
            map.remove(course);
        }
        return map.size() == 0;
    }
}

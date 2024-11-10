package classes;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // Map to store nodes by horizontal distance
        Map<Integer, List<Integer>> verticalMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));

        // BFS traversal to populate verticalMap
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.key();
            int hd = pair.value();

            // Add node value to the corresponding horizontal distance
            verticalMap.computeIfAbsent(hd, k -> new ArrayList<>()).add(node.getValue());

            if (node.left != null) {
                queue.add(new Pair<>(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, hd + 1));
            }
        }
        return verticalMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}

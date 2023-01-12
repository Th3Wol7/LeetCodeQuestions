package minimumTimeToCollectApplesInTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectApples {
/*1 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
fromi < toi
hasApple.length == n*/

    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // Initialize graph as a list of integer lists
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Initialize set of visited nodes
        Set<Integer> visited = new HashSet<>();

        // DFS function to traverse the tree
        return dfs(graph, hasApple, visited, 0);
    }

    public static int dfs(List<List<Integer>> graph, List<Boolean> hasApple, Set<Integer> visited, int node) {
        // Mark current node as visited
        visited.add(node);
        int res = 0;
        // Check all neighboring nodes
        for (int neighbor : graph.get(node)) {
            // If neighbor has not been visited
            if (!visited.contains(neighbor)) {
                // Check if there is an apple in the neighbor or the subtree rooted at neighbor
                int subTreeTime = dfs(graph, hasApple, visited, neighbor);
                if (subTreeTime > 0 || hasApple.get(neighbor)) {
                    res += subTreeTime + 2;
                }
            }
        }
        // Return the time spent in subtree + current node
        return res + (hasApple.get(node) ? 1 : 0);
    }


    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = new ArrayList<>();
        hasApple.add(false);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(false);
        hasApple.add(true);
        hasApple.add(true);
        hasApple.add(false);
        System.out.println(minTime(n, edges, hasApple));
    }

}

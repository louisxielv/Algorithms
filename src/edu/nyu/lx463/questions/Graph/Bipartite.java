package edu.nyu.lx463.questions.Graph;

import java.util.*;

/**
 * Created by LyuXie on 4/15/17.
 */
public class Bipartite {
    /**
     * public class GraphNode {
     *   public int key;
     *   public List<GraphNode> neighbors;
     *   public GraphNode(int key) {
     *     this.key = key;
     *     this.neighbors = new ArrayList<GraphNode>();
     *   }
     * }
     */
        public boolean isBipartite(List<GraphNode> graph) {
            if (graph == null || graph.size() == 0) {
                return true;
            }

            Map<GraphNode, Integer> visited = new HashMap<>();
            for (GraphNode node : graph) {
                if (!bfs(node, visited)) {
                    return false;
                }
            }

            return true;
        }

        private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
            if (visited.containsKey(node)) {
                return true;
            }

            Queue<GraphNode> queue = new LinkedList<>();
            visited.put(node, 0);
            queue.offer(node);

            while (!queue.isEmpty()) {
                GraphNode curr = queue.poll();
                int currGroup = visited.get(curr);
                int neiGroup = currGroup == 0 ? 1 : 0;

                for (GraphNode neibor : curr.neighbors) {
                    if (visited.containsKey(neibor)) {
                        if (visited.get(neibor) != neiGroup) {
                            return false;
                        }
                    }
                    else {
                        visited.put(neibor, neiGroup);
                        queue.offer(neibor);
                    }
                }
            }

            return true;
        }


}
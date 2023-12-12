package MinimumSpanningTree;
  import java.util.*;

public class Prim {
    public static void main(String[] args) {
        int[][] edges = new int[][]{
            {1, 3, 4}, {1, 2, 5}, {2, 3, 2}, {3, 5, 4}, {2, 4, 3}, {4, 5, 2},
            {5, 6, 1}, {6, 7, 8}, {4, 7, 6},
            {7, 8, 2}
        };

        List<int[]> minimumSpanningTree = prim(edges, 8);
        int totalCost = calculateTotalCost(minimumSpanningTree);

        // Output the minimum spanning tree edges
        System.out.println("Minimum Spanning Tree Edges:");
        for (int[] edge : minimumSpanningTree) {
            System.out.println(Arrays.toString(edge));
        }

        // Output the total cost
        System.out.println("Total Cost: " + totalCost);
    }

    //the adjacency list of vertices and the edges that connectes them
    private static List<int[]> prim(int[][] edges, int numNodes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        //priority queue structure for keeping track of the lists of edges
        // the {0, 1, 0} place holder is for the initial node, which is not used

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 1, 0});

        boolean[] visited = new boolean[numNodes + 1];
        List<int[]> result = new ArrayList<>();

        //the loop runs until the priority queue is empty;
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int from = current[0];
            int to = current[1];
            int cost = current[2];

            //the if statement checks if the vertex is visited or not. 
            //if yes, it continues to the next vertex;
            if (visited[to]) continue;
            visited[to] = true;

            // the result list is updated with the edges that are visited
            result.add(new int[]{from, to, cost});

            //the for loop adds the edges to the priority queue
            for (int[] edge : graph.get(to)) {
                if (!visited[edge[0]]) {
                    pq.add(new int[]{to, edge[0], edge[1]});
                }
            }
        }

        return result.subList(1, result.size()); // Exclude the initial placeholder [0, 1, 0]
    }

    //total cost method of the minimum spanning tree
    private static int calculateTotalCost(List<int[]> mst) {
        int totalCost = 0;
        for (int[] edge : mst) {
            totalCost += edge[2];
        }
        return totalCost;
    }
}


package escapemud;

import java.util.*;

/* Find the shortest, or the 'least' path.
 * Dijkstra's algorithm is applied, and the original code is from
 * http://en.literateprograms.org/index.php?title=Special%3aDownloadCode/Dijkstra%27s_algorithm_%28Java%29&oldid=15444
 */

class Vertex implements Comparable<Vertex> {
    public final String name;
    public Edge[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; }
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vertex target;
    public final double weight;
    public Edge(Vertex argTarget, double argWeight)
    { target = argTarget; weight = argWeight; }
}

public class EscapeMud {

    public static void computePaths(Vertex source)
    {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            /* visit every nodes exiting the current node */
            for (Edge e : u.adjacencies)
            {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);

                    v.minDistance = distanceThroughU ;
                    v.previous = u;
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static int getDijkstra(int n, String[] mud) {
    	
        /* 48 is 0 in ASCII code */
        int ascii0 = 48;
        Vertex v[] = new Vertex[n*n];
        int[][] values = new int[n][n];

        
        /* retrieve the values from input, and initialize the vertices */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                values[i][j] = mud[i].charAt(j) - ascii0;
                int element = i*n + j;
                v[element] = new Vertex(Integer.toString(element));
            }
        }

        /* Add the edges
         * for safety, this process is done after all vertices are made
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int element = i*n + j;

                /* destination point */
                if(element == n*n - 1) {
                    Edge[] edges = new Edge[2];
                    edges[0] = new Edge(v[element - 1], values[i][j]);
                    edges[1] = new Edge(v[element - n], values[i][j]);
                    v[element].adjacencies = edges;
                }
                /* first row or column */
                else if (element < n || (element % n == 0 && element < (n-1)*n)) {
                    Edge[] edges = new Edge[2];
                    edges[0] = new Edge(v[element + n], values[i][j]);
                    edges[1] = new Edge(v[element + 1], values[i][j]);
                    v[element].adjacencies = edges;
                }

                /* last column */
                else if (element % n == n-1 && element < n * n - 1) {
                    Edge[] edges = new Edge[2];
                    edges[0] = new Edge(v[element + n], values[i][j]);
                    edges[1] = new Edge(v[element - 1], values[i][j]);
                    v[element].adjacencies = edges;
                }

                /* last row */
                else if (element >= (n - 1) * n && element < n * n - 1) {
                    Edge[] edges = new Edge[2];
                    edges[0] = new Edge(v[element - n], values[i][j]);
                    edges[1] = new Edge(v[element + 1], values[i][j]);
                    v[element].adjacencies = edges;
                }

                /* rest */
                else {

                    Edge[] edges = new Edge[4];
                    edges[0] = new Edge(v[element - n], values[i][j]);
                    edges[1] = new Edge(v[element - 1], values[i][j]);
                    edges[2] = new Edge(v[element + n], values[i][j]);
                    edges[3] = new Edge(v[element + 1], values[i][j]);
                    v[element].adjacencies = edges;
                }

            }

        }

        /* run dijkstra to find the shortest path */
        computePaths(v[0]);
        int min = (int) v[n*n-1].minDistance;
        /* if the result is oer 100, set it to 100 */
        if(min > 100)
            min = 100;

    	return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        String[] mud = new String[n];
        for(int i = n - 1; i >= 0; i--) {
        	mud[i] = sc.next();
        }
        
        int min = getDijkstra(n, mud);
        System.out.println(min);

    }
}

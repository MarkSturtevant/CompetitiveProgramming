import java.util.*;
import java.io.*;

public class sai {

    static double[][] survProbs;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] rushes;

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        double P = Double.parseDouble(input[1]);
        int W = Integer.parseInt(input[2]), H = Integer.parseInt(input[3]);
        String[] input1 = br.readLine().split(" "), input2 = br.readLine().split(" ");
        Coord start = new Coord(Integer.parseInt(input1[0]), Integer.parseInt(input1[1]));
        Coord end = new Coord(Integer.parseInt(input2[0]), Integer.parseInt(input2[1]));
        int M = Integer.parseInt(br.readLine());
        survProbs = new double[M + 2][M + 2];
        rushes = new boolean[M + 2][M + 2];
        Node[] nodes = new Node[M + 2];
        int[][] map = new int[W][H];

        for (int a = 1; a <= M; ++a) {
            String[] input3 = br.readLine().split(" ");
            Coord next = new Coord(Integer.parseInt(input3[0]), Integer.parseInt(input3[1]));
            map[next.c][next.r] = a;
            nodes[a] = new Node(next, a);
        }
        nodes[0] = new Node(start, 0);
        nodes[M + 1] = new Node(end, M + 1);
        map[end.c][end.r] = M + 1;

        int K = Integer.parseInt(br.readLine());
        for (int a = 0; a < K; ++a) {
            String[] input3 = br.readLine().split(" ");
            Coord next = new Coord(Integer.parseInt(input3[0]), Integer.parseInt(input3[1]));
            map[next.c][next.r] = -1;
        }

        // map and node array initialized, now finding edges.
        for (int i = 0; i < M + 1; ++i) {
            Node next = nodes[i];
            Queue<Coord> queue = new LinkedList<>();
            int[][] flood = new int[W][H];
            flood[next.loc.c][next.loc.r] = 1;
            queue.add(next.loc);
            while (! queue.isEmpty()) {
                Coord nextCoord = queue.remove();
                int newValue = flood[nextCoord.c][nextCoord.r] + 1;
                boolean close = false;
                for (int[] d : dir) {
                    Coord nc = new Coord(nextCoord.c + d[0], nextCoord.r + d[1]);
                    if (nc.c < 0 || nc.r < 0 || nc.c >= W || nc.r >= H || map[nc.c][nc.r] == -1 || flood[nc.c][nc.r] > 0)
                        continue;
                    if (map[nc.c][nc.r] > 0) {
                        // setting probabilities
                        rushes[i][map[nc.c][nc.r]] = N < newValue - 1;
                        survProbs[i][map[nc.c][nc.r]] = getProb(N, P, newValue - 1);
                        next.connections.add(nodes[map[nc.c][nc.r]]);
                        if (map[nc.c][nc.r] == M + 1)
                            close = true;
                    }
                    flood[nc.c][nc.r] = newValue;
                    queue.add(nc);
                }
                if (close)
                    break;
            }
        }

        // now doing depth-first search
        Queue<Edge> edges = new PriorityQueue<>((a, b) -> (int) (100000000 * (b.prob - a.prob)));
        double[] allProbs = new double[M + 2];
        for (int i = 0; i < M + 2; ++i)
            allProbs[i] = -1;
        allProbs[0] = 1;
        for (Node n : nodes[0].connections)
            edges.add(new Edge(n, survProbs[0][n.id], rushes[0][n.id] ? 1 : 0));

        while (! edges.isEmpty()) {
            Edge edge = edges.poll();
            if (allProbs[edge.target.id] != -1)
                continue;

            if (edge.target.id == M + 1) {
                System.out.printf("%.8f", edge.prob);
                return;
            }
            allProbs[edge.target.id] = edge.prob;
            for (Node n : edge.target.connections) {
                int numRushes = edge.numRushes;
                double prob = edge.prob;
                if (rushes[edge.target.id][n.id]) {
                    ++numRushes;
                    prob /= numRushes;
                }

                edges.add(new Edge(n, prob * survProbs[edge.target.id][n.id], numRushes));
            }
        }

        System.out.println("0.00000000");

    }

    static double getProb(int N, double P, int spaces) {
        if (spaces <= N)
            return 1.0;
        return P / (spaces - N);
    }

    static class Edge {
        Node target;
        double prob;
        int numRushes;
        public Edge(Node target, double prob, int numRushes) {
            this.target = target;
            this.prob = prob;
            this.numRushes = numRushes;
        }
    }

    static class Coord {
        int r, c;
        public Coord(int c, int r) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node {
        Coord loc;
        int id;
        List<Node> connections;

        public Node(Coord loc, int id) {
            this.loc = loc;
            this.id = id;
            this.connections = new ArrayList<>();
        }
    }

}

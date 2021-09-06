import java.io.*;
import java.util.*;

public class crossingpaths {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(reader.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(in.nextToken()), Q = Integer.parseInt(in.nextToken());
        Home[] homes = new Home[N + 1];
        for (int i = 1; i < N + 1; ++i)
            homes[i] = new Home(i);
        for (int i = 1; i < N; ++i) {
            in = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(in.nextToken()), b = Integer.parseInt(in.nextToken());
            homes[a].edges.add(homes[b]);
            homes[b].edges.add(homes[a]);
        }
        homes[1].setSubs(null);

        for (int i = 0; i < Q; ++i) {
            in = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(in.nextToken()), b = Integer.parseInt(in.nextToken()), c = Integer.parseInt(in.nextToken()), d = Integer.parseInt(in.nextToken());
            Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
            Home start = homes[a];
            set1.add(a); set1.add(b); set2.add(c); set2.add(d);
            while (! start.subs.contains(b)) {
                start = start.up;
                set1.add(start.id);
            }
            start = homes[b];
            while (! start.subs.contains(a)) {
                start = start.up;
                set1.add(start.id);
            }

            start = homes[c];
            while (! start.subs.contains(d)) {
                start = start.up;
                set2.add(start.id);
            }
            start = homes[d];
            while (! start.subs.contains(c)) {
                start = start.up;
                set2.add(start.id);
            }

            set1.retainAll(set2);
            if (set1.isEmpty())
                pw.println("NO");
            else pw.println("YES");
        }
        pw.close();
    }


}

class Home {
    int id;
    Set<Integer> subs;
    List<Home> edges;
    Home up;

    public Home(int id) {
        this.id = id;
        this.subs = new HashSet<>();
        this.edges = new ArrayList<>();
        this.up = null;
    }

    public Set<Integer> setSubs(Home caller) {
        this.up = caller;
        this.subs.add(id);
        for (Home edge : edges) {
            if (! edge.equals(caller))
                this.subs.addAll(edge.setSubs(this));
        }
        return subs;
    }
}

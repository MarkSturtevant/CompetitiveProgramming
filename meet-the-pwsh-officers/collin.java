import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class collin {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int W = Integer.parseInt(input[0]), H = Integer.parseInt(input[1]), D = Integer.parseInt(input[2]);

        Platform start = null;

        List<Platform>[] currentPlatforms = (List<Platform>[]) new List[W];
        for (int i = 0; i < W; ++i)
            currentPlatforms[i] = new ArrayList<>();

        for (int i = 0; i < H; ++i) {
            String nextLine = br.readLine();
            for (int j = 0; j < W; ++j) {
                j = nextLine.indexOf("X", j);
                if (j == -1)
                    break;
                int k = nextLine.indexOf("*", j) - 1;
                if (k == -2)
                    k = W - 1;
                Platform nextPlat = new Platform(i);
                if (i == 1 && j == 0)
                    start = nextPlat;
                if (j > 0)
                    currentPlatforms[j - 1].add(nextPlat);
                if (k < W - 1)
                    currentPlatforms[k + 1].add(nextPlat);
                for (int a = j; a <= k; ++a) {
                    for (Platform p : currentPlatforms[a])
                        if (nextPlat.y - p.y <= D)
                            p.links.add(nextPlat);
                    currentPlatforms[a].clear();
                }
            }
        }
        Platform floor = new Platform(H);
        for (int i = 0; i < W; ++i)
            for (Platform p : currentPlatforms[i])
                if (H - p.y <= D)
                    p.links.add(floor);

        if (start.found(floor))
            System.out.println("Yer boi done did it!");
        else System.out.println("That's a josh situation.");
    }

    static class Platform {
        List<Platform> links;
        boolean visited;
        int y;

        public Platform(int y) {
            links = new ArrayList<>();
            visited = false;
            this.y = y;
        }

        boolean found(Platform target) {
            if (target == this)
                return true;

            for (Platform p : links)
                if (( ! p.visited) && p.found(target))
                    return true;

            this.visited = true;
            return false;
        }
    }

}

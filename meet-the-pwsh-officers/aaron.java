import java.io.*;

public class aaron {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int l = Integer.parseInt(br.readLine());
        char[][] given = new char[l][l];
        char[][] goal = new char[l][l];
        for (int i = 0; i < l; i++) {
            given[i] = br.readLine().trim().toUpperCase().toCharArray();
        }
        br.readLine();
        for (int i = 0; i < l; i++) {
            goal[i] = br.readLine().trim().toUpperCase().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < l - 2; i++) {
            for (int j = 0; j < l - 2; j++) {
                if (given[i][j] != goal[i][j]) {
                    count++;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            given[i + x][j + y] = given[i + x][j + y] == 'X' ? 'O' : 'X';
                        }
                    }
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < l && flag; i++) {
            for (int j = 0; j < l && flag; j++) {
                flag = given[i][j] == goal[i][j];
            }
        }
        if (flag) {
            bw.write(count + "\n");
        } else {
            bw.write("NO SOLUTION\n");
        }
        br.close();
        bw.close();
    }

}

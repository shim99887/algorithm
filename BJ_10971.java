import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class BJ_10971 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N;
    static int[][] map;
    static boolean[] visited;

    static int[] arr;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            tokens = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }

        Date date = new Date();

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            arr[0] = i;
            visited[i] = true;
            func(1);
        }

        Date finish = new Date();

        System.out.println(min);

//        System.out.println((finish.getTime() - date.getTime()) / 1000);
    }

    static void func(int idx) {
        boolean isEnd = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                isEnd = false;
            }
        }

        if (isEnd) {
            if (map[arr[N - 1]][arr[0]] > 0) {
                min = Math.min(min, calculate());
            }
            return;
        }

//        for (int i = 0; i < N; i++) {
//            if(visited[i])
//                continue;
        for (int j = 0; j < N; j++) {
            if (idx == j)
                continue;
            if (visited[j])
                continue;
            if (map[arr[idx - 1]][j] == 0)
                continue;
            visited[j] = true;
            arr[idx] = j;
            func(idx + 1);
            visited[j] = false;
            arr[idx] = 0;
        }
//        }
    }

    static int calculate() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += map[arr[i]][arr[i + 1]];
        }

        sum += map[arr[N - 1]][arr[0]];

        return sum;
    }

}

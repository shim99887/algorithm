import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1189 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int R, C, K, count = 0;
    static char[][] map;

    static boolean[][] visited;
    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        tokens = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        K = Integer.parseInt(tokens.nextToken());

        map = new char[R][C];

        for(int r=0; r < R; r++){
            String line = reader.readLine();
            for(int c=0; c < C; c++){
                map[r][c] = line.charAt(c);
            }
        }

        visited = new boolean[R][C];
        visited[R-1][0] = true;

//        func(R-1,0,1, visited);
        func(R-1,0,1);

        System.out.println(count);
    }

    static void func(int r, int c, int cnt){

        if(cnt == K && r == 0 && c == C-1){
            count++;
            return;
        }
        if(cnt > K){
            return;
        }

        for(int d=0; d < dirs.length; d++){
            int frontR = r + dirs[d][0];
            int frontC = c + dirs[d][1];

//            if(isIn(frontR, frontC)){
//                if(!visited[frontR][frontC] && map[frontR][frontC] == '.'){
//                    visited[frontR][frontC] = true;
//                    func(frontR, frontC, cnt+1);
//                }
//                visited[frontR][frontC] = false;
//            }

            if(!isIn(frontR, frontC))
                continue;

            if(map[frontR][frontC] == 'T')
                continue;

            if(visited[frontR][frontC])
                continue;

            visited[frontR][frontC] = true;
            func(frontR, frontC, cnt+1);
            visited[frontR][frontC] = false;
        }
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < R && c >= 0 && c < C;
    }

}

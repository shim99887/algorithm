import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1553 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[][] map = new int[8][7];
    static int[][] dirs = {{0,1}, {1,0}};
    static int[][] pattern = {
            {0,0},{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},
            {1,1},{1,2},{1,3},{1,4},{1,5},{1,6},
            {2,2},{2,3},{2,4},{2,5},{2,6},
            {3,3},{3,4},{3,5},{3,6},
            {4,4},{4,5},{4,6},
            {5,5},{5,6},
            {6,6}
    };

    static boolean[][] visited = new boolean[8][7];

    static int count = 0;
    static boolean[] usedPattern = new boolean[28];

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        for(int i=0; i < map.length; i++){
            String line = reader.readLine();
            for(int j=0; j < map[0].length; j++){
                map[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

//        for(int i=0; i < usedPattern.length; i++){
//            if(!usedPattern[i]){
//                System.out.println(i + " 사용안됨");
//            }
//        }

//        for(int[] ar : map){
//            System.out.println(Arrays.toString(ar));
//        }

        func(0,0);

        System.out.println(count);

    }

    static void func(int r, int c){
        boolean isEnd = true;

        for(int i=0; i < usedPattern.length; i++){
            if(!usedPattern[i]){
                isEnd = false;
            }
        }

        if(isEnd){
            count++;
            return;
        }

        if(visited[r][c]){
            if(isIn(r,c+1)){
                func(r, c+1);
            }else{
                func(r+1, 0);
            }
            return;
        }
        for(int i=0; i < dirs.length; i++){
            int frontR = r + dirs[i][0];
            int frontC = c + dirs[i][1];

            if(!isIn(frontR, frontC))
                continue;

            if(visited[frontR][frontC])
                continue;

            for(int j=0; j < pattern.length; j++){
                if(usedPattern[j])
                    continue;
                if(!((pattern[j][0] == map[r][c] && pattern[j][1] == map[frontR][frontC]) || (pattern[j][0] == map[frontR][frontC] && pattern[j][1] == map[r][c])))
                    continue;

//                System.out.println("기존 : " +  r + " " + c);
//                System.out.println("이동 : " + frontR + " " + frontC);
                visited[r][c] = true;
                visited[frontR][frontC] = true;
                usedPattern[j] = true;
//                for(boolean[] ar : visited){
//                    System.out.println(Arrays.toString(ar));
//                }
                int dirR = r, dirC = c+1;
                if(isIn(dirR, dirC)){
                    func(dirR, dirC);
                } else {
                    func(r+1, 0);
                }

                visited[r][c] = false;
                visited[frontR][frontC] = false;
                usedPattern[j] = false;
            }
        }
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < 8 && c >= 0 && c < 7;
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9663 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N, count = 0;
    static int[][] map;
    static boolean [] canQueen;

    static int[][] dirs = {
            {1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1}
    };

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
//        Date date = new Date();

        map = new int[N][N];
        canQueen = new boolean[N];

        func(0);

        System.out.println(count);

//        Date finish = new Date();

//        System.out.println(date.getTime());
//        System.out.println(finish.getTime());
//        System.out.println((finish.getTime() - date.getTime())/1000);

    }

    static void func(int idx){
        if(idx >= N){
//            for(int[] ar: map){
//                System.out.println(Arrays.toString(ar));
//            }
//            System.out.println();
            count++;
            return;
        }

        for(int i=0; i < N; i++){
            if(canQueen[i])
                continue;

              if(!canQueen[i] && canPutQueen(idx, i)) {
                  map[idx][i] = 1;
                  canQueen[i] = true;
                  func(idx+1);
            }
            map[idx][i] = 0;
            canQueen[i] = false;
        }
    }

    static boolean canPutQueen(int r, int c){
        if(map[r][c] == 1){
            return false;
        }

//        for(int i=0; i < dirs.length; i++){
//            for(int j=1; j <= N; j++){
//                int frontR = r + dirs[i][0] * j;
//                int frontC = c + dirs[i][1] * j;
//
//                if(isIn(frontR, frontC) && map[frontR][frontC] == 1){
//                    return false;
//                }else {
//                    break;
//                }
//            }
//        }

        for(int i=0; i < dirs.length; i++){
            int frontR = r;
            int frontC = c;
            do{
                frontR += dirs[i][0];
                frontC += dirs[i][1];

                if(isIn(frontR, frontC)){
                    if(map[frontR][frontC] == 1){
                        return false;
                    }
                }else{
                    break;
                }
            }while(true);
        }

        return true;
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}

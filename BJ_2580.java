import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2580 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[][] map;

    static int[][] dirs = {
            {0,1},{0,-1},{1,0},{-1,0}
    };

    static List<Point> list;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        Date date = new Date();

        map = new int[9][9];
        list = new ArrayList<>();

        for(int i=0; i < 9; i++){
            tokens = new StringTokenizer(reader.readLine());
            for(int j=0; j < 9; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
                if(map[i][j] == 0){
                    list.add(new Point(i,j));
                }
            }
        }

//        System.out.println(list.size());

//        for(int[] ar : map){
//            System.out.println(Arrays.toString(ar));
//        }

        func(0);

        Date finish = new Date();

//        System.out.println((finish.getTime() - date.getTime())/1000);
    }

    static void func(int idx){
        if(idx >= list.size()){
            for(int[] ar : map){
                for(int val : ar){
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.exit(0);
        }

//        for(int i=0; i < list.size(); i++){
            Point point = list.get(idx);
            for(int j=1; j <= 9; j++){
                if(canPut(point, j)){
                    map[point.r][point.c] = j;
                    func(idx+1);
                }
                map[point.r][point.c] = 0;
            }
//        }
    }

    static boolean canPut(Point p, int value){
        int ariaR = p.r/3, ariaC = p.c/3;

        for(int i=ariaR * 3; i < ariaR*3+3; i++){
            for(int j=ariaC * 3; j < ariaC *3+3; j++){
                if(map[i][j] == value){
                    return false;
                }
            }
        }

        for(int i=0; i < dirs.length; i++){
            int frontR = p.r;
            int frontC = p.c;
            while(true){
                frontR += dirs[i][0];
                frontC += dirs[i][1];

                if(!isIn(frontR, frontC))
                    break;

                if(map[frontR][frontC] == value){
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isIn(int r, int c){
        return r >= 0 && r < 9 && c >= 0 && c < 9;
    }

    public static class Point{
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}

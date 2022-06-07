import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15649 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        arr = new int[M];

        func(1);
    }

    static boolean isIn(int value){
        for(int i = 0; i < M; i++){
            if(arr[i] == value){
                return false;
            }
        }

        return true;
    }

    static void func(int idx){
        if(idx > M){
            for(int value : arr){
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i <= N; i++){
            if(isIn(i)){
                arr[idx-1] = i;
                func(idx+1);
            }
            arr[idx-1] = 0;
        }
    }
}

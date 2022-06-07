import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15651 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        tokens = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        arr = new int[M];

        func(0);
        System.out.print(output);
    }

    static void func(int idx){
        if(idx >= M){
            for(int i=0; i < arr.length; i++){
                output.append(arr[i]).append(" ");
            }
            output.append("\n");
            return;
        }

        for(int i=1; i <= N; i++){
            arr[idx] = i;
            func(idx+1);
            arr[idx] = 0;
        }
    }

}

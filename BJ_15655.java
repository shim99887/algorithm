import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[] arr;
    static int N, M;
    static int[] val;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        tokens = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokens.nextToken());
        M = Integer.parseInt(tokens.nextToken());

        arr = new int[N];
        val = new int[M];

        tokens = new StringTokenizer(reader.readLine());

        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        func(0);

        System.out.print(output);
    }

    static void func(int idx){
        if(idx >= M){
            for(int i=0; i < val.length; i++){
                output.append(val[i] + " ");
            }
            output.append("\n");
            return;
        }

        for(int i=0; i < N; i++){
            if(idx == 0){
                val[idx] = arr[i];
                func(idx+1);
            }else{
                if(isIn(arr[i]) && val[idx-1] < arr[i]){
                    val[idx] = arr[i];
                    func(idx+1);
                }
            }
            val[idx] = 0;
        }
    }

    static boolean isIn(int value){
        for(int i=0; i < M; i++){
            if(val[i] == value){
                return false;
            }
        }

        return true;
    }

}

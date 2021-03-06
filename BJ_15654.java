import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {
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

        tokens = new StringTokenizer(reader.readLine());
        for(int i=0; i < arr.length; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        Arrays.sort(arr);

        val = new int[M];
//        System.out.println(Arrays.toString(arr));
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

        for(int i=0; i < arr.length; i++){
            if(isIn(arr[i])){
                val[idx] = arr[i];
                func(idx+1);
            }
            val[idx] = 0;
        }
    }

    static boolean isIn(int value){
        for(int i=0; i < val.length; i++){
            if(val[i] == value){
                return false;
            }
        }

        return true;
    }
}

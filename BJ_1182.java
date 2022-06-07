import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N, S, value = 0;
    static int[] arr, arr2;
    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new StringBuilder();

        tokens = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokens.nextToken());
        S = Integer.parseInt(tokens.nextToken());

        arr = new int[N];
        tokens = new StringTokenizer(reader.readLine());

        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        for(int i=1; i <= N; i++){
            arr2 = new int[i];
            func(0, i);
        }

        System.out.println(value);
    }

    static void func(int idx, int R){
        if(idx >= R){
            int sum = 0;
            for(int i=0; i < arr2.length; i++){
                sum += arr[arr2[i]-1];
            }

            if(sum == S){
                value++;
            }
            return;
        }

        for(int i=1; i <= arr.length; i++){
            if(idx == 0){
                arr2[idx] = i;
                func(idx+1, R);
            }else{
                if(arr2[idx-1] < i && isIn(i)){
                    arr2[idx] = i;
                    func(idx+1, R);
                }
            }
            arr2[idx] = 0;
        }
    }

    static boolean isIn(int value){
        for(int i=0; i < arr2.length; i++){
            if(arr2[i] == value){
                return false;
            }
        }

        return true;
    }

}

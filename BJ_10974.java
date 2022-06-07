import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10974 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        arr = new int[N];

        func(0);

//        Date date = new Date();

//        Date finish = new Date();

        System.out.print(output);

//        System.out.println((finish.getTime() - date.getTime())/1000);
    }

    static void func(int idx){
        if(idx >= N){
            for(int ar : arr){
                output.append(ar).append(" ");
            }
            output.append("\n");
            return;
        }

        for(int i=1; i <= N; i++){
            if(isIn(i)){
                arr[idx] = i;
                func(idx+1);
            }
            arr[idx] = 0;
        }
    }

    static boolean isIn(int value){
        for(int i=0; i < N; i++){
            if(arr[i] == value){
                return false;
            }
        }
        return true;
    }

}

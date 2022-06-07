import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_6603 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[] arr;
    static int[] val = new int[6];

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
//        reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

//        tokens = new StringTokenizer(reader.readLine());

//        do{
//            int N = Integer.parseInt(tokens.nextToken());
//        }while (N != 0)

        while(true){
            int N = sc.nextInt();

            if(N == 0){
                System.out.print(output);
                return;
            }

            arr = new int[N];

            for(int i=0; i < N; i++){
                arr[i] = sc.nextInt();
            }

            func(0);
            output.append("\n");
        }

    }

    static void func(int idx){
        if(idx >= 6){
            for(int i=0; i < val.length; i++){
                output.append(val[i] + " ");
            }
            output.append("\n");
            return;
        }

        for(int i=0; i < arr.length; i++){
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
        for(int i=0; i < val.length; i++){
            if(val[i] == value){
                return false;
            }
        }

        return true;
    }
}

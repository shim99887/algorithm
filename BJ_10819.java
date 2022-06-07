import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class BJ_10819 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N;

    static int[] arr;
    static int[] val;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        Date date = new Date();

        N = Integer.parseInt(reader.readLine());

        arr= new int[N];
        val= new int[N];

        tokens = new StringTokenizer(reader.readLine());

        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        func(0);

        Date finish = new Date();

        System.out.println(max);

//        System.out.println((finish.getTime() - date.getTime())/1000);
    }

    static void func(int idx){
        if(idx >= N){
//            System.out.println(Arrays.toString(val));
            int value = calculate();
//            System.out.println(value);
            max = Math.max(max,value);
            return;
        }

        for(int i=0; i < N; i++){
            if(isIn(i+1)){
                val[idx] = i+1;
                func(idx+1);
            }
            val[idx] = 0;
        }
    }

    static boolean isIn(int value){
        for(int i=0; i < N; i++){
            if(val[i] == value){
                return false;
            }
        }
        return true;
    }

    static int calculate(){
        int sum = 0;
        for(int i=0; i < N-1; i++){
            sum += Math.abs(arr[val[i]-1] - arr[val[i+1]-1]);
        }

        return sum;
    }
}

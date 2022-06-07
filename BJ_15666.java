import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15666 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[] arr;
    static int N, M;
    static int[] val;

    static Set<String> set;

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

//        set = new HashSet<>();
        set = new LinkedHashSet<>();

        Arrays.sort(arr);

        func(0);


        for(String l : set){
            output.append(l).append("\n");
        }

        System.out.print(output);

    }

    static void func(int idx){
        if(idx >= M){
            String line = "";
            for(int i=0; i < val.length; i++){
                line += arr[val[i]-1] + " ";
//                output.append(val[i] + " ");
            }


//            if(!list.contains(line)){
//                output.append(line);
//                output.append("\n");
//            }
//            System.out.println(Arrays.toString(val));
            set.add(line);
            return;
        }

        for(int i=0; i < N; i++){
//            if(idx == 0){
            if(idx == 0){
                val[idx] = i+1;
                func(idx+1);
            } else{
                if(val[idx-1] <= i+1){
                    val[idx] = i+1;
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

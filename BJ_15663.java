import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15663 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int[] arr;
    static int N, M;
    static int[] val;

    static List<String> list;
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
        list = new ArrayList<>();

        Arrays.sort(arr);

        func(0);

//        Object[] s = set.toArray();

//        System.out.print(output);
//        System.out.println(set);


//        for(int i=0; i < s.length;i++){
//            System.out.println(s[i]);
//        }

//        System.out.println(s.length);
        for(String l : set){
            System.out.println(l);
        }
//
//        for(int[] ar : list){
//            System.out.println(Arrays.toString(ar));
//        }
//            System.out.println(list);
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
            list.add(line);
            return;
        }

        for(int i=0; i < N; i++){
//            if(idx == 0){
            if(isIn(i+1)){

                val[idx] = i+1;
                func(idx+1);
            }
//            } else {
//                if(val[idx-1] <= arr[i]){
//                    val[idx] = arr[i];
//                    func(idx+1);
//                }
//            }
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

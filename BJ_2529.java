import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2529 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int N;
    static char[] oper;
    static int[] arr;

    static List<String> list;

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        oper = new char[N];
        arr = new int[N+1];

        tokens = new StringTokenizer(reader.readLine());

        for(int i=0; i < N; i++){
            oper[i] = tokens.nextToken().charAt(0);
        }

        for(int i=0; i < N+1; i++){
            arr[i] = -1;
        }

        list = new ArrayList<>();



        func(0);

//        System.out.println(Arrays.toString(list.get(0)));
//        System.out.println(Arrays.toString(list.get(list.size()-1)));

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }

    static void func(int idx){
        if(idx >= N+1){
            String line = "";

            for(int i=0; i < arr.length; i++){
                line += arr[i];
            }

            list.add(line);
            return;
        }

            for (int i = 0; i <= 9; i++) {
                if(idx == 0){
                    arr[idx] = i;
                    func(idx+1);
                } else {
                    switch (oper[idx-1]){
                        case '<':
                            if(isIn(i) && arr[idx-1] < i){
                                arr[idx] = i;
                                func(idx+1);
                            }
                            break;
                        case '>':
                            if(isIn(i) && arr[idx-1] > i){
                                arr[idx] = i;
                                func(idx+1);
                            }
                            break;
                    }
                }
                arr[idx] = -1;
            }
    }

    static boolean isIn(int value){
        for(int i=0; i < arr.length; i++){
            if(arr[i] == value){
                return  false;
            }
        }

        return true;
    }

}

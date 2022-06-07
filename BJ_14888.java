import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14888 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, value = 0;
    static int[] arr, oper, operArr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
//        tokens = new StringTokenizer(reader.readLine());
        arr = new int[N];
        oper = new int[4];

        tokens = new StringTokenizer(reader.readLine());
        for(int i=0; i < N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }

        tokens = new StringTokenizer(reader.readLine());
        for(int i=0; i < 4; i++){
            oper[i] = Integer.parseInt(tokens.nextToken());
        }
        operArr = new int[N-1];

        value = arr[0];

        for(int i=0; i < oper.length; i++){
            for(int j=0;j < oper[i]; j++){
                list.add(i+1);
            }
        }

        func(0);

        System.out.println(max);
        System.out.println(min);
    }

    static void func(int idx){
        if(idx > operArr.length-1){
            value = arr[0];
            for(int i=0; i < arr.length-1; i++){
                value = calculate(i);
            }
            max = Math.max(max, value);
            min = Math.min(min, value);
            return;
        }

        for(int i=1; i <= list.size(); i++){
            if(isIn(i)){
                operArr[idx] = i;
                func(idx+1);
            }
            operArr[idx] = 0;
        }
    }

    static boolean isIn(int val){
        for(int i=0; i < operArr.length; i++){
            if(operArr[i] == val){
                return false;
            }
        }
        return true;
    }

    static int calculate(int idx){
        switch (list.get(operArr[idx]-1)){
            case 1:
                return value + arr[idx+1];
            case 2:
                return value - arr[idx+1];
            case 3:
                return value * arr[idx+1];
            case 4:
                return value < 0 ? -(Math.abs(value) / arr[idx+1]) : value / arr[idx+1];
        }
        return 0;
    }

}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759 {
    static BufferedReader reader;
    static StringBuilder output;
    static StringTokenizer tokens;

    static int L, C;
    static char[] arr;
    static char[] val;

    static char[] aeiou = {'a','e','i','o','u'};

    public static void main(String[] args) throws Exception{
//        reader = new BufferedReader(new FileReader("./testcase.txt"));
        reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        output = new StringBuilder();

//        Date date = new Date();

        tokens = new StringTokenizer(reader.readLine());

        L = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());

        arr= new char[C];
        val = new char[L];

        tokens = new StringTokenizer(reader.readLine());
        for(int i=0; i < C; i++){
            arr[i] = tokens.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        func(0, 0);

        System.out.print(output);
//        Date finish = new Date();

//        System.out.println((finish.getTime() - date.getTime())/1000);
    }

    static void func(int idx, int index){
        if(idx >= L){
            int cnt = countAeiou();

            if(cnt >= 1 && val.length - cnt >= 2){
                for(int i=0; i< val.length; i++){
                    output.append(val[i]);
                }
                output.append("\n");
//                System.out.println(Arrays.toString(val));
            }

            return;
        }

        for(int i=index; i < C; i++){
            if(isIn(arr[i]) && idx <= index){
                val[idx] = arr[i];
                func(idx+1, i+1);
            }
            val[idx] = ' ';
        }
    }

    static int countAeiou(){
        int cnt = 0;
        for(int i=0; i < val.length; i++){
            for(int j=0; j < aeiou.length; j++){
                if(val[i] == aeiou[j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isIn(char c){
        for(int i=0; i < val.length; i++){
            if(val[i] == c){
                return false;
            }
        }
        return true;
    }

}

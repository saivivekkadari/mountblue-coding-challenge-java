import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'happyLadybugs' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING b as parameter.
     */

    public static String happyLadybugs(String b) {
    // Write your code here
    int arr[]=new int[26];
    boolean isEmpty=false;
    for(int i=0;i<b.length();i++){
        if(b.charAt(i)=='_'){
            isEmpty=true;
        }
        else{
            arr[b.charAt(i)-'A']++;
        }
    }
    if(isEmpty){
    for(int i=0;i<arr.length;i++){
        if(arr[i]==1){
            return "NO";
        }
    }
    return "YES";
    }
    for(int i=0;i<b.length();i++){
        boolean l=(i>0&&b.charAt(i)==b.charAt(i-1));
        boolean r=(i<b.length()-1&&b.charAt(i)==b.charAt(i+1));
        
        if(!l&&!r){
            return "NO";
        }
    }
    return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String b = bufferedReader.readLine();

                String result = Result.happyLadybugs(b);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

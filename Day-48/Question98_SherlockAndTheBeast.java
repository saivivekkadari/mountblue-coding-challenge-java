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
     * Complete the 'decentNumber' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void decentNumber(int n) {
    // Write your code here
    int fiveCount=n;
    
    while(fiveCount>=0){
        if(fiveCount%3==0&&(n-fiveCount)%5==0){
            break;
        }
        fiveCount=fiveCount-5;
    }
    if(fiveCount<0){
        System.out.println(-1);
        return;
    }
    
    StringBuilder a=new StringBuilder();
    
    for(int i=0;i<fiveCount;i++){
        a.append('5');
    }
    
    for(int i=0;i<(n-fiveCount);i++){
        a.append('3');
    }
    
    System.out.println(a.toString());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                Result.decentNumber(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

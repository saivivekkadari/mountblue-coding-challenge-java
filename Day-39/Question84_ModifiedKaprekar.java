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
     * Complete the 'kaprekarNumbers' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     */

    public static void kaprekarNumbers(int p, int q) {
    // Write your code here
    boolean isThere=false;
    for(int i=p;i<=q;i++){
        if(isKaprekar(i)){
            System.out.print(i+" ");
            isThere=true;
        }
    }
    if(!isThere){
        System.out.print("INVALID RANGE");
    }
    }
    public static boolean isKaprekar(int p){
        if(p==1){
            return true;
        }

        long  square=(long)p*p;
        
        int digits=String.valueOf(p).length();
        
        long power=1;
        for(int i=0;i<digits;i++){
            power=power*10;
        }
        
        long r=square%power;
        long l=square/power;
        
        if(p==(l+r)&&r!=0){
            return true;
        }
        else{
            return false;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}

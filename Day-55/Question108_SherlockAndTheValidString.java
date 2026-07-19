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
     * Complete the 'isValid' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isValid(String s) {
    // Write your code here
    int [] f=new int[26];
    
    for(int i=0;i<s.length();i++){
        f[s.charAt(i)-'a']++;
    }
    
    if(isEqual(f)){
        return "YES";
    }
    
    for(int i=0;i<26;i++){
        if(f[i]==0){
            continue;
        }
        f[i]--;
        if(isEqual(f)){
            return "YES";
        }
        f[i]++;
    }
    return "NO";
    
    
    

    }
    public static boolean isEqual(int [] f){
        int a=0;
        for(int i=0;i<26;i++){
            if(f[i]==0){
                continue;
            }
            
            if(a==0){
                a=f[i];
            }
            else if(f[i]!=a){
                return false;
            }
        
        }
        return true;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

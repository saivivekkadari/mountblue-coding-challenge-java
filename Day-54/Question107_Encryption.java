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
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
    String str=s.replace(" ","");
    int row=(int)Math.floor(Math.sqrt(str.length()));
    int col=(int)Math.ceil(Math.sqrt(str.length()));
    
    if(row*col<str.length()){
        row++;
    }
    
    StringBuilder result=new StringBuilder();
    
    for(int i=0;i<col;i++){
        for(int j=i;j<str.length();j+=col){
            result.append(str.charAt(j));
        }
        if(i!=col-1){
            result.append(" ");
        }
    }
    return result.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

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
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
    // Return the minimum number of characters to make the password strong
    boolean isNumberThere=false;
    boolean isLowerCaseThere=false;
    boolean isUpperCaseThere=false;
    boolean isSpecialCharacterThere=false;
    
    int missingCharCount=0;
    
    String specialChar="!@#$%^&*()_+";
    
    for(int i=0;i<password.length();i++){
        if(password.charAt(i)>='0'&&password.charAt(i)<='9'){
            isNumberThere=true;
        }
        if(password.charAt(i)>='A'&&password.charAt(i)<='Z'){
            isUpperCaseThere=true;
        }
        if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
            isLowerCaseThere=true;
        }
        if(specialChar.indexOf(password.charAt(i))!=-1){
            isSpecialCharacterThere=true;
        }
    }
    if(!isNumberThere){
        missingCharCount++;
    }
    if(!isLowerCaseThere){
        missingCharCount++;
    }
    if(!isUpperCaseThere){
        missingCharCount++;
    }
    if(!isSpecialCharacterThere){
        missingCharCount++;
    }
    return Math.max(missingCharCount,6-n);
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

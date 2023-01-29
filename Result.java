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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
    // Write your code here
    String numbers = to32bits(n);
    long number = flipper(numbers);

   return number;
    }



   public static String to32bits(long n) {
   String base2 = Long.toBinaryString(n);
      while(base2.length()<32){
          base2= '0'+base2;
      }
      return base2;
    }
      
      
public static long flipper(String base2) {
    // flips the 1s with 0s and vice versa     
    String newNum = "";
    for (int a=0 ; a<base2.length();a++){
        if(base2.charAt(a)=='1'){
            newNum+='0';
        }else{
           newNum+='1'; 
        }
    }
    
    
    // Convert the string back to a Long( and also from base 2 to base 10)
    return Long.parseLong(newNum,2);


    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

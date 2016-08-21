/* https://www.hackerrank.com/challenges/sherlock-and-array */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void sherlock(int[] arr, int sum) {
        int left = arr[0];
        int right = sum - left;
        for(int i = 1; i < arr.length - 1; i++) {
            right -= arr[i];
            if(left == right) {
                System.out.println("YES");
                return;
            }
            else {
                left += arr[i];
            }
        }
        System.out.println("NO");
        return;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numCase = sc.nextInt();
        for(int i = 0; i < numCase; i++) {
            
            int n = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0;
            for(int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            if(n == 1)
                System.out.println("YES");
            else if(n == 2)
                System.out.println("NO");
            else {
                sherlock(arr, sum);
            }
        }
    }
    

}

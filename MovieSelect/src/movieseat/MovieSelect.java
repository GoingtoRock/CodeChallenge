package movieseat;

import java.util.*;

/* Number of available cases for two adjacent seats */
public class MovieSelect {

	public static int SelectSeat (int row, String s, int count) {
		
		int sCount = 0;	
        for(int j = 0; j < s.length() - 1; j++) {
            char c = s.charAt(j);
            /* if the current seat is available and so is the next seat,
            we are guaranteed to have couple seats */
            if(c == '.' && s.charAt(j+1) == '.') {
                sCount++;
            }
        }		
        
        count += sCount;
		return count;
	}
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /* scan the number of rows */
        int row = sc.nextInt();
        int count = 0;

        for(int i = 0; i < row; i++) {
            String s = sc.next();
            count = SelectSeat(row, s, count);

        }
        System.out.println(count);
    }

}

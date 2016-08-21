package movieseat;

import static org.junit.Assert.*;

import org.junit.Test;

import movieseat.MovieSelect;

public class MovieSelectTest {

	@Test
	public void test1() {
		int row = 2;
		
		String[] s = new String[row];
		s[0] = "..";
		s[1] = "**";
		
		int count = 0;
        for(int i = 0; i < row; i++) {
            count = MovieSelect.SelectSeat(row, s[i], count);
        }
		
        assertEquals(count, 1);
	}

	@Test
	public void test2() {
		int row = 4;
		
		String[] s = new String[row];
		s[0] = "..**";
		s[1] = ".*..";
		s[2] = "*...";
		s[3] = "....";
		
		int count = 0;
        for(int i = 0; i < row; i++) {
            count = MovieSelect.SelectSeat(row, s[i], count);
        }
		
        assertEquals(count, 7);
	}

}

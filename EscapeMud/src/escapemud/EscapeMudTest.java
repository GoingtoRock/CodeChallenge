package escapemud;

import static org.junit.Assert.*;

import org.junit.Test;

import escapemud.EscapeMud;
public class EscapeMudTest {

	@Test
	public void test1() {
		
		int n = 5;
		String[] mud = new String[n];
		
		mud[4] = "10000";
		mud[3] = "09999";
		mud[2] = "02010";
		mud[1] = "99990";
		mud[0] = "01010";
		
		int result = EscapeMud.getDijkstra(n, mud);
		assertEquals(result, 6);
	}
	
	@Test
	public void test2() {
		
		int n = 5;
		String[] mud = new String[n];
		
		mud[4] = "22220";
		mud[3] = "29999";
		mud[2] = "22220";
		mud[1] = "99990";
		mud[0] = "01010";
		
		int result = EscapeMud.getDijkstra(n, mud);
		assertEquals(result, 11);
	}
	
	@Test
	public void test3() {
		
		int n = 8;
		String[] mud = new String[n];
		
		mud[7] = "99999990";
		mud[6] = "99999999";
		mud[5] = "99999999";
		mud[4] = "99999999";
		mud[3] = "99999999";
		mud[2] = "99999999";
		mud[1] = "99999999";
		mud[0] = "09999999";
		
		int result = EscapeMud.getDijkstra(n, mud);
		assertEquals(result, 100);
	}

}

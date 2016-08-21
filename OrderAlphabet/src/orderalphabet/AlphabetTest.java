package orderalphabet;
import static org.junit.Assert.*;

import org.junit.Test;

import orderalphabet.Alphabet;

public class AlphabetTest {

	@Test
	public void test1() {

		String str = "ABABAC";
		String fs = Alphabet.printAlphabet(str);
		assertEquals(fs, "CBBAAA");
	}

	@Test
	public void test2() {

		String str = "DONTFORGETTHATYOUARESPECIAL";
		String fs = Alphabet.printAlphabet(str);
		assertEquals(fs, "CDFGHILNPSUYRRAAAEEEOOOTTTT");
	}
	
}

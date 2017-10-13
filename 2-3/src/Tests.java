import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void test() {
		TwoThreeTree t = new TwoThreeTree();
	      t.insert(1);
	      t.insert(9);
	      t.insert(15);
	      t.insert(13);
	      t.insert(20);
	      t.insert(7);
	      t.insert(4);

	      t.insert(1);
	      t.insert(9);
	      t.insert(15);
	      t.insert(1);
	      t.insert(9);
	      t.insert(15);
	      t.insert(13);
	      t.insert(20);
	      t.insert(7);
	      t.insert(4);
	      t.insert(13);
	      t.insert(20);
	      t.insert(7);
	      t.insert(4);
	      t.insert(2);
	      t.insert(3);
	      t.insert(-1);
	      t.insert(0);
	      t.insert(1);
	      

	      String expected = "-1";
	      assertEquals(expected, t.search(-2));
	       expected = "1";
	      assertEquals(expected, t.search(1));
	      expected = "2 9";
	      assertEquals(expected, t.search(9));
	      expected = "7";
	      assertEquals(expected, t.search(8));
	      expected = "20";
	      assertEquals(expected, t.search(100));
	      expected = "15";
	      assertEquals(expected, t.search(15));
	      expected = "13";
	      assertEquals(expected, t.search(12));
	      

	      

	}

}

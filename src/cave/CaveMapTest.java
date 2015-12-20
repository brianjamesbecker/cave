package cave;

/**
 * Unit tests for CaveMap
 */
public class CaveMapTest {

	public void runTests() {
		testConstruction();
	}

	private void testConstruction() {
		CaveMap cave = new CaveMap(2, 2);
		verify(" 0\n  \n", cave.toString());
	}

	private void verify(String expected, String actual) {
		if (expected.equals(actual)) {
			System.out.printf("Success");
		}
		else {
			System.out.println("Failure. The actual result");
			System.out.println(actual);
			System.out.println("did not equal");
			System.out.println(expected);
		}
	}

	public static void main(String[] args) {

		CaveMapTest tester = new CaveMapTest();
		tester.runTests();
	}
}

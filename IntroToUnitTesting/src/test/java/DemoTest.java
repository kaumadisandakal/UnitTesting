import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Test;

public class DemoTest {

	// Edge case test cases for isTriangle method with valid triangles
	@Test
	public void testIsTriangle_ValidTriangle1() {
		assertTrue(Demo.isTriangle(3, 4, 5));
	}

	@Test
	public void testIsTriangle_ValidTriangle2() {
		assertTrue(Demo.isTriangle(5, 12, 13));
	}

	@Test
	public void testIsTriangle_ValidTriangle3() {
		assertTrue(Demo.isTriangle(12, 13, 5));
	}

	@Test
	public void testIsTriangle_ValidLargeTriangle() {
		assertTrue(Demo.isTriangle(1000000, 1000001, 2000000));
	}

	// Edge case test cases for invalid triangles in isTriangle method
	@Test
	public void testIsTriangle_NotATriangle1() {
		assertFalse(Demo.isTriangle(1, 2, 3));
	}

	@Test
	public void testIsTriangle_NotATriangle2() {
		assertFalse(Demo.isTriangle(5, 7, 13));
	}

	@Test
	public void testIsTriangle_NotATriangleWithZero() {
		assertFalse(Demo.isTriangle(0, 5, 5));
	}

	@Test
	public void testIsTriangle_NotATriangleWithNegativeSide() {
		assertFalse(Demo.isTriangle(-1, 3, 5));
	}

	@Test
	public void testIsTriangle_NotATriangleWithEqualSum() {
		assertFalse(Demo.isTriangle(2, 2, 4));
	}

	// Main method test case for valid triangle input
	@Test
	public void testMainProgram_ValidTriangleInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("5\n13\n12\n".getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Demo.main(new String[0]);

		String expectedOutput = "Enter side 1: \n"
				+ "Enter side 2: \n"
				+ "Enter side 3: \n"
				+ "This is a triangle.\n";

		assertEquals(expectedOutput.trim(), out.toString().trim());
	}

	// Main method test case for invalid triangle input
	@Test
	public void testMainProgram_InvalidTriangleInput() {
		ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n3\n".getBytes());
		System.setIn(in);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));

		Demo.main(new String[0]);

		String expectedOutput = "Enter side 1: \n"
				+ "Enter side 2: \n"
				+ "Enter side 3: \n"
				+ "This is not a triangle.\n";

		assertEquals(expectedOutput.trim(), out.toString().trim());
	}

	// Reset streams to prevent side effects for subsequent tests
	@After
	public void restoreSystemInputOutput() {
		System.setIn(System.in);
		System.setOut(System.out);
	}
}

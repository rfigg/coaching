package hello;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test() {
		assertEquals("failure - did not get a 'Hello World'.", "Hello World", HelloWorld.getHello());
	}

}

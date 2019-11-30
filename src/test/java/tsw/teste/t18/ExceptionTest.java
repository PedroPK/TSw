package tsw.teste.t18;

import org.junit.Test;

public class ExceptionTest {
	
	@Test(expected=Exception.class)
	public void testException() throws Exception {
		throw new Exception();
	}
	
	@Test(expected=Throwable.class)
	public void testThrowable() throws Throwable {
		throw new Throwable();
	}
	
	@Test(expected=Error.class)
	public void testError() {
		throw new Error();
	}
	
}
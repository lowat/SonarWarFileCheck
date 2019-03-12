package filecount;

import static org.junit.Assert.*;

import org.junit.Test;

public class InitTest {

	@Test
	public void test() throws Exception {
		Init init = new Init();
		init.run(false);
		if(init.getFinalCount() != 0) {
			if(init.getFinalJavaCount()!=init.getFinalCount()) {
				fail("Not all .class files have compiled");
			}
		}
		else {
			fail("Zero .class files");
		}
		
	}

}

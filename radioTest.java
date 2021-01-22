package archivosRadio;
import static org.junit.Assert.*;

import org.junit.Test;

public class radioTest {

	@Test
	public void numerictest() {
		radio ra = new radio();
		//boolean sw = ra.check("12");
		ra.encenderApagar();
	}
	
	@Test(timeout =10)
	public void onofftest() {
		radio ra = new radio();
		ra.setonOff();
	}
	
	@Test
	public void amFmtest() {
		radio ra = new radio();
		ra.setfrecuencia();
	}
	
	@Test
	public void avanzartest() {
		radio ra = new radio();
		ra.avanzar();
	}

}

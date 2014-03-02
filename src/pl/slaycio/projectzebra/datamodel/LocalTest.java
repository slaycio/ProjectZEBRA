package pl.slaycio.projectzebra.datamodel;

public class LocalTest {

	public static void main(String[] args) {
		try {
			ORMinit lacznik = new ORMinit();
			lacznik.initializeORM(Boolean.FALSE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

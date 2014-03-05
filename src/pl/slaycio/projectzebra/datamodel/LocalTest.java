package pl.slaycio.projectzebra.datamodel;


public class LocalTest {

	
	public static void main(String[] args) {
		try {
			
			ORMinit.initializeORM(Boolean.TRUE);
			System.out.println("Inicjalizacja ORM");
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package pl.slaycio.projectzebra.datamodel;

import org.h2.tools.Server;


public class LocalTest {

	
	public static Server server ; 
	
	public static void main(String[] args) {
		try {
									
			server = Server.createTcpServer();
						
			server.stop();
			server.shutdown();
			
			
			System.out.println(server.getStatus());
			//System.out.println(server.isRunning(false));
			//System.out.println(server.getService());
			//System.out.println(server.toString());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

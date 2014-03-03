package pl.slaycio.projectzebra.datamodel;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ORMinit {
	
	//private final static String DATABASE_URL = "jdbc:h2:C:\\VaadinProject\\wrk\\ProjectZEBRA\\account";
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/VaadinProject\\wrk\\ProjectZEBRA\\dbProjectZEBRA";
	public static Dao<Account, Integer> accountDao;
	
	
	public ORMinit() {
	}
		
	
	
	
	public static void initializeORM(Boolean purge) throws Exception {
				
						
		ConnectionSource connectionSource = null;
		try {
		connectionSource = new JdbcConnectionSource(DATABASE_URL);
		accountDao = DaoManager.createDao(connectionSource, Account.class);
		
		if (purge) {
		TableUtils.dropTable(connectionSource, Account.class, true);
		}
		
		TableUtils.createTableIfNotExists(connectionSource, Account.class);
				
		
		} finally {
		
		if (connectionSource != null) {
		connectionSource.close();
		}
		}
		
		
		
	}
	
		

}

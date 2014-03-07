package pl.slaycio.projectzebra.datamodel;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ORMinit {
	
	//public static final String currentLoggedUser = "currentLoggedUser";
	//private final static String DATABASE_URL = "jdbc:h2:C:\\VaadinProject\\wrk\\ProjectZEBRA\\account";
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost\\VaadinProject\\wrk\\ProjectZEBRA\\dbProjectZEBRA";
	public static Dao<Account, Integer> accountDao;
	public static Dao<FinancialInstitution, Integer> financialInstitutionDao;
	public static Dao<AccountOwner, Integer> accountOwnerDao;
	public static Dao<User, Integer> userDao;
	public static Dao<FinancialTransaction, Integer> transactionDao;
	public static Dao<TransactionCategory, Integer> transactionCategoryDao;

	
	
	public ORMinit() {
	}
		
	
	
	
	public static void initializeORM(Boolean purge) throws Exception {
				
						
		ConnectionSource connectionSource = null;
		try {
		connectionSource = new JdbcConnectionSource(DATABASE_URL);
		accountDao = DaoManager.createDao(connectionSource, Account.class);
		financialInstitutionDao = DaoManager.createDao(connectionSource, FinancialInstitution.class);
		accountOwnerDao = DaoManager.createDao(connectionSource, AccountOwner.class);
		userDao = DaoManager.createDao(connectionSource, User.class);
		transactionDao = DaoManager.createDao(connectionSource, FinancialTransaction.class);
		transactionCategoryDao = DaoManager.createDao(connectionSource, TransactionCategory.class);
		
		if (purge) {
		TableUtils.dropTable(connectionSource, Account.class, true);
		TableUtils.dropTable(connectionSource, FinancialInstitution.class, true);
		TableUtils.dropTable(connectionSource, AccountOwner.class, true);
		TableUtils.dropTable(connectionSource, User.class, true);
		TableUtils.dropTable(connectionSource, FinancialTransaction.class, true);
		TableUtils.dropTable(connectionSource, TransactionCategory.class, true);
		
		
		}
		
		TableUtils.createTableIfNotExists(connectionSource, Account.class);
		TableUtils.createTableIfNotExists(connectionSource, FinancialInstitution.class);	
		TableUtils.createTableIfNotExists(connectionSource, AccountOwner.class);
		TableUtils.createTableIfNotExists(connectionSource, User.class);
		TableUtils.createTableIfNotExists(connectionSource, FinancialTransaction.class);
		TableUtils.createTableIfNotExists(connectionSource, TransactionCategory.class);
		
		} finally {
		
		if (connectionSource != null) {
		connectionSource.close();
		}
		}
		
		
		
	}
	
		

}

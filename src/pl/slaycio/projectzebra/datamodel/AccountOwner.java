package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "account_owners")
public class AccountOwner {

	final static String GUI_TABLE_NAME = "Wlasciciele kont";
	
	public static final String NAME_FIELD_NAME = "name";
	public static final String LAST_NAME_FIELD_NAME = "last_name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String OWNER_TYPE_FIELD_NAME = "owner_type";
	public static final String SYMBOL_FIELD_NAME = "symbol";
	public static final String FINANCIAL_INSTITUTION_FIELD_NAME = "symbol";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;

	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = true)
	private String name;

	@DatabaseField(columnName = LAST_NAME_FIELD_NAME, canBeNull = true)
	private String lastName;
	
	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = true)
	private String description;

	@DatabaseField(columnName = OWNER_TYPE_FIELD_NAME, canBeNull = false)
	private String ownerType;

	@DatabaseField(columnName = SYMBOL_FIELD_NAME, canBeNull = false)
	private String symbol;
	
	@DatabaseField(columnName = FINANCIAL_INSTITUTION_FIELD_NAME, foreign = true)
	private FinancialInstitution finInstitution;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<Account> accounts;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<User> users;

	
	
public AccountOwner() {
		
	}
	

	public AccountOwner(String officialName, String name, String lastName,
			String description, String ownerType, String symbol) {

		this.name = name;
		this.lastName = lastName;
		this.description = description;
		this.ownerType = ownerType;
		this.symbol = symbol;
		this.creationDate = new Date();
		this.createdBy = "currentLoggedUser";
		
		this.saveUsingDAO();
	}

	public int getId() {
		this.refreshUsingDAO();
		return id;
	}

	public void setId(int id) {
		this.id = id;
		this.saveUsingDAO();
	}

	public String getName() {
		this.refreshUsingDAO();
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.saveUsingDAO();
	}

	public String getLastName() {
		this.refreshUsingDAO();
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		this.saveUsingDAO();
	}

	
	public String getDescription() {
		this.refreshUsingDAO();
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		this.saveUsingDAO();
	}

	public String getOwnerType() {
		this.refreshUsingDAO();
		return ownerType;
	}

	public void setOwnerType(String entityType) {
		this.ownerType = entityType;
		this.saveUsingDAO();
	}

	public String getSymbol() {
		this.refreshUsingDAO();
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
		this.saveUsingDAO();
	}

	public FinancialInstitution getFinInstitution() {
		this.refreshUsingDAO();
		return finInstitution;
	}


	public void setFinInstitution(FinancialInstitution finInstitution) {
		this.finInstitution = finInstitution;
		this.saveUsingDAO();
	}


	public ForeignCollection<Account> getAccounts() {
		this.refreshUsingDAO();
		return accounts;
	}


	public void setAccounts(ForeignCollection<Account> accounts) {
		this.accounts = accounts;
		this.saveUsingDAO();
	}


	public ForeignCollection<User> getUsers() {
		this.refreshUsingDAO();
		return users;
	}


	public void setUsers(ForeignCollection<User> users) {
		this.users = users;
		this.saveUsingDAO();
	}


	public Date getCreationDate() {
		this.refreshUsingDAO();
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
		this.saveUsingDAO();
	}

	public String getCreatedBy() {
		this.refreshUsingDAO();
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
		this.saveUsingDAO();
	}
	
	public void saveUsingDAO() {
		try {
			ORMinit.accountOwnerDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUsingDAO() {
		try {
			ORMinit.accountOwnerDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.accountOwnerDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.accountOwnerDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
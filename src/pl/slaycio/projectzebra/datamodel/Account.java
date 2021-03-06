package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.math.BigDecimal;

@DatabaseTable(tableName = "accounts")
public class Account {

	final static String GUI_TABLE_NAME = "Konta w instytucjach finansowych";

	public static final String NAME_FIELD_NAME = "name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String TYPE_FIELD_NAME = "account_type";
	public static final String OWNER_FIELD_NAME = "owner";
	public static final String INSTITUTION_FIELD_NAME = "financial_institution";
	public static final String SYMBOL_FIELD_NAME = "symbol";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String BALANCE_FIELD_NAME = "balance";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;

	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
	private String name;

	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = true)
	private String description;

	@DatabaseField(columnName = TYPE_FIELD_NAME, canBeNull = false)
	private String accountType;

	@DatabaseField(columnName = OWNER_FIELD_NAME, canBeNull = false)
	private String owner;

	@DatabaseField(columnName = INSTITUTION_FIELD_NAME, foreign = true)
	private FinancialEntity finInstitution;
	
	@DatabaseField(columnName = SYMBOL_FIELD_NAME, canBeNull = false)
	private String symbol;
	
	@DatabaseField(columnName = CURRENCY_FIELD_NAME, canBeNull = false)
	private String currency;
	
	@DatabaseField(columnName = BALANCE_FIELD_NAME, canBeNull = false)
	private BigDecimal balance;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;

	Account() {
	}

	public Account(String name, String description, String accountType, String owner,
			FinancialEntity finInstitution, String symbol) {
		this.name = name;
		this.description = description;
		this.accountType = accountType;
		this.owner = owner;
		this.finInstitution = finInstitution;
		this.symbol = symbol;
		this.currency = "PLN";
		this.balance = new BigDecimal("0");
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

	public String getDescription() {
		this.refreshUsingDAO();
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		this.saveUsingDAO();
	}

	public String getAccountType() {
		this.refreshUsingDAO();
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
		this.saveUsingDAO();
	}

	public String getOwner() {
		this.refreshUsingDAO();
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
		this.saveUsingDAO();
	}

	public FinancialEntity getFinInstitution() {
		this.refreshUsingDAO();
		return finInstitution;
	}

	public void setFinInstitution(FinancialEntity finInstitution) {
		this.finInstitution = finInstitution;
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

	public String getCurrency() {
		this.refreshUsingDAO();
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
		this.saveUsingDAO();
	}

	public BigDecimal getBalance() {
		this.refreshUsingDAO();
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
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
			ORMinit.accountDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUsingDAO() {
		try {
			ORMinit.accountDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.accountDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.accountDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
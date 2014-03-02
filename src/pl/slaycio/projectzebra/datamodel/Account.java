package pl.slaycio.projectzebra.datamodel;

import java.util.Date;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {

	final static String GUI_TABLE_NAME = "Konta w instytucjach finansowych";

	public static final String NAME_FIELD_NAME = "name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String TYPE_FIELD_NAME = "account_type";
	public static final String INSTITUTION_FIELD_NAME = "financial_institution";
	public static final String SYMBOL_FIELD_NAME = "symbol";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
	private String name;

	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = false)
	private String description;

	@DatabaseField(columnName = TYPE_FIELD_NAME, canBeNull = false)
	private String accountType;

	@DatabaseField(columnName = INSTITUTION_FIELD_NAME, canBeNull = false)
	private String finInstitution;
	
	@DatabaseField(columnName = SYMBOL_FIELD_NAME, canBeNull = false)
	private String symbol;
	
	@DatabaseField(columnName = CURRENCY_FIELD_NAME, canBeNull = false)
	private String currency;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;

	Account() {
	}

	public Account(String name, String description, String accountType,
			String finInstitution, String symbol) {
		this.name = name;
		this.description = description;
		this.accountType = accountType;
		this.finInstitution = finInstitution;
		this.symbol = symbol;
		this.currency = "PLN";
		this.creationDate = new Date();
		this.createdBy = "currentLoggedUser";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getFinInstitution() {
		return finInstitution;
	}

	public void setFinInstitution(String finInstitution) {
		this.finInstitution = finInstitution;
	}

		
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
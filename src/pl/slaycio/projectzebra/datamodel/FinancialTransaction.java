package pl.slaycio.projectzebra.datamodel;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "transactions")
public class FinancialTransaction {

	
	final static String GUI_TABLE_NAME = "Transakcje finansowe";

	public static final String TRANSACTION_DATE_FIELD_NAME = "transaction_date";
	public static final String CATEGORY_ID_FIELD_NAME = "category_id";
	public static final String FROM_ACCOUNT_FIELD_NAME = "from_account_id";
	public static final String FROM_AMOUNT_FIELD_NAME = "from_amount";
	public static final String FROM_CURRENCY_FIELD_NAME = "from_currency";
	public static final String TABLE_EXCHANGE_RATE_FIELD_NAME = "table_exchange_rate";
	public static final String USER_EXCHANGE_RATE_FIELD_NAME = "user_exchange_rate";
	public static final String TO_ACCOUNT_FIELD_NAME = "to_account_id";
	public static final String TO_AMOUNT_FIELD_NAME = "to_amount";
	public static final String TO_CURRENCY_FIELD_NAME = "to_currency";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;
	
	@DatabaseField(columnName = TRANSACTION_DATE_FIELD_NAME, canBeNull = false)
	private Date transactionDate;

	@DatabaseField(columnName = CATEGORY_ID_FIELD_NAME, foreign = true)
	private TransactionCategory categoryId;

	@DatabaseField(columnName = FROM_ACCOUNT_FIELD_NAME, foreign = true)
	private Account fromAccount;

	@DatabaseField(columnName = FROM_AMOUNT_FIELD_NAME, canBeNull = false)
	private BigDecimal fromAmount;

	@DatabaseField(columnName = FROM_CURRENCY_FIELD_NAME, canBeNull = false)
	private String fromCurrency;
	
	@DatabaseField(columnName = TABLE_EXCHANGE_RATE_FIELD_NAME, canBeNull = false)
	private BigDecimal tableExchangeRate;
	
	@DatabaseField(columnName = USER_EXCHANGE_RATE_FIELD_NAME, canBeNull = true)
	private BigDecimal userExchangeRate;
	
	@DatabaseField(columnName = TO_ACCOUNT_FIELD_NAME, foreign = true)
	private Account toAccount;
	
	@DatabaseField(columnName = TO_AMOUNT_FIELD_NAME, canBeNull = false)
	private BigDecimal toAmount; 
	
	@DatabaseField(columnName = TO_CURRENCY_FIELD_NAME, canBeNull = false)
	private String toCurrency;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	
	
	public FinancialTransaction() {
	
	}



	public FinancialTransaction(int id, Date transactionDate,
			TransactionCategory categoryId, Account fromAccount,
			BigDecimal fromAmount, String fromCurrency,
			BigDecimal tableExchangeRate, BigDecimal userExchangeRate,
			Account toAccount, BigDecimal toAmount, String toCurrency,
			Date creationDate, String createdBy) {

		this.transactionDate = transactionDate;
		this.categoryId = categoryId;
		this.fromAccount = fromAccount;
		this.fromAmount = fromAmount;
		this.fromCurrency = fromCurrency;
		this.tableExchangeRate = tableExchangeRate;
		this.userExchangeRate = userExchangeRate;
		this.toAccount = toAccount;
		this.toAmount = toAmount;
		this.toCurrency = toCurrency;
		this.creationDate = new Date();
		this.createdBy = "currentLoggedUser";
	}



	public int getId() {
		this.refreshUsingDAO();
		return id;
	}



	public void setId(int id) {
		this.id = id;
		this.saveUsingDAO();
	}



	public Date getTransactionDate() {
		this.refreshUsingDAO();
		return transactionDate;
	}



	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
		this.saveUsingDAO();
	}



	public TransactionCategory getCategoryId() {
		this.refreshUsingDAO();
		return categoryId;
	}



	public void setCategoryId(TransactionCategory categoryId) {
		this.categoryId = categoryId;
		this.saveUsingDAO();
	}



	public Account getFromAccount() {
		this.refreshUsingDAO();
		return fromAccount;
	}



	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
		this.saveUsingDAO();
	}



	public BigDecimal getFromAmount() {
		this.refreshUsingDAO();
		return fromAmount;
	}



	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
		this.saveUsingDAO();
	}



	public String getFromCurrency() {
		this.refreshUsingDAO();
		return fromCurrency;
	}



	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
		this.saveUsingDAO();
	}



	public BigDecimal getTableExchangeRate() {
		this.refreshUsingDAO();
		return tableExchangeRate;
	}



	public void setTableExchangeRate(BigDecimal tableExchangeRate) {
		this.tableExchangeRate = tableExchangeRate;
		this.saveUsingDAO();
	}



	public BigDecimal getUserExchangeRate() {
		this.refreshUsingDAO();
		return userExchangeRate;
	}



	public void setUserExchangeRate(BigDecimal userExchangeRate) {
		this.userExchangeRate = userExchangeRate;
		this.saveUsingDAO();
	}



	public Account getToAccount() {
		this.refreshUsingDAO();
		return toAccount;
	}



	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
		this.saveUsingDAO();
	}



	public BigDecimal getToAmount() {
		this.refreshUsingDAO();
		return toAmount;
	}



	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
		this.saveUsingDAO();
	}



	public String getToCurrency() {
		this.refreshUsingDAO();
		return toCurrency;
	}



	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
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
			ORMinit.transactionDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public void updateUsingDAO() {
		try {
			ORMinit.transactionDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.transactionDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.transactionDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

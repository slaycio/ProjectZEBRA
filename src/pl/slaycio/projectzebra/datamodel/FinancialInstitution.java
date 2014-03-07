package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "financial_institutions")
public class FinancialInstitution {

	final static String GUI_TABLE_NAME = "Podmioty rynku finansowego";

	public static final String OFFICIAL_NAME_FIELD_NAME = "official_name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String ENTITY_TYPE_FIELD_NAME = "institution_type";
	public static final String SYMBOL_FIELD_NAME = "symbol";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;

	@DatabaseField(columnName = OFFICIAL_NAME_FIELD_NAME, canBeNull = false)
	private String officialName;
	
	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = true)
	private String description;

	@DatabaseField(columnName = ENTITY_TYPE_FIELD_NAME, canBeNull = false)
	private String institutionType;

	@DatabaseField(columnName = SYMBOL_FIELD_NAME, canBeNull = false)
	private String symbol;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<Account> accounts;

	FinancialInstitution() {
	}

	public FinancialInstitution(String officialName, String name, String lastName,
			String description, String institutionType, String symbol) {

		this.officialName = officialName;
		this.description = description;
		this.institutionType = institutionType;
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

	public String getOfficialName() {
		this.refreshUsingDAO();
		return officialName;
	}

	public void setOfficialName(String officialName) {
		this.officialName = officialName;
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


	public String getInstitutionType() {
		this.refreshUsingDAO();
		return institutionType;
	}
	
	public void setInstitutionType(String institutionType) {
		this.institutionType = institutionType;
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
	
	public ForeignCollection<Account> getAccounts() {
		this.refreshUsingDAO();
		return accounts;
	}

	public void setAccounts(ForeignCollection<Account> accounts) {
		this.accounts = accounts;
		this.saveUsingDAO();
	}

	public void saveUsingDAO() {
		try {
			ORMinit.financialInstitutionDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUsingDAO() {
		try {
			ORMinit.financialInstitutionDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.financialInstitutionDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.financialInstitutionDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
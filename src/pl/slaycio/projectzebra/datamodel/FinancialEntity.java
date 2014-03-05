package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "financial_entities")
public class FinancialEntity {

	final static String GUI_TABLE_NAME = "Podmioty rynku finansowego i osoby fizyczne";

	public static final String OFFICIAL_NAME_FIELD_NAME = "official_name";
	public static final String NAME_FIELD_NAME = "name";
	public static final String LAST_NAME_FIELD_NAME = "last_name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String ENTITY_TYPE_FIELD_NAME = "entity_type";
	public static final String SYMBOL_FIELD_NAME = "symbol";
	public static final String CURRENCY_FIELD_NAME = "currency";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;

	@DatabaseField(columnName = OFFICIAL_NAME_FIELD_NAME, canBeNull = false)
	private String officialName;

	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = true)
	private String name;

	@DatabaseField(columnName = LAST_NAME_FIELD_NAME, canBeNull = true)
	private String lastName;

	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = true)
	private String description;

	@DatabaseField(columnName = ENTITY_TYPE_FIELD_NAME, canBeNull = false)
	private String entityType;

	@DatabaseField(columnName = SYMBOL_FIELD_NAME, canBeNull = false)
	private String symbol;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	@ForeignCollectionField(eager = false)
    ForeignCollection<Account> accounts;

	FinancialEntity() {
	}

	public FinancialEntity(String officialName, String name, String lastName,
			String description, String entityType, String symbol) {

		this.officialName = officialName;
		this.name = name;
		this.lastName = lastName;
		this.description = description;
		this.entityType = entityType;
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

	public String getEntityType() {
		this.refreshUsingDAO();
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
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
	
	public void saveUsingDAO() {
		try {
			ORMinit.financialEntityDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUsingDAO() {
		try {
			ORMinit.financialEntityDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.financialEntityDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.financialEntityDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
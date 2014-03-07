package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "transaction_categories")
public class TransactionCategory {

	
	final static String GUI_TABLE_NAME = "Kategorie transakcji";

	public static final String NAME_FIELD_NAME = "name";
	public static final String DESC_FIELD_NAME = "description";
	public static final String CATEGORY_FIELD_NAME = "master_category_id";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";

	@DatabaseField(generatedId = true, index = true)
	private int id;
	
	@DatabaseField(columnName = NAME_FIELD_NAME, canBeNull = false)
	private String name;

	@DatabaseField(columnName = DESC_FIELD_NAME, canBeNull = true)
	private String description;
	
	@DatabaseField(columnName = CATEGORY_FIELD_NAME, foreign = true)
	private TransactionCategory masterCategory;
	
	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	
	public TransactionCategory() {


	}
	
	

	public TransactionCategory(int id, String name, String description,
			TransactionCategory masterCategory, Date creationDate,
			String createdBy) {


		this.name = name;
		this.description = description;
		this.masterCategory = masterCategory;
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


	public TransactionCategory getMasterCategory() {
		this.refreshUsingDAO();
		return masterCategory;
	}


	public void setMasterCategory(TransactionCategory masterCategory) {
		this.masterCategory = masterCategory;
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
			ORMinit.transactionCategoryDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUsingDAO() {
		try {
			ORMinit.transactionCategoryDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.transactionCategoryDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.transactionCategoryDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}

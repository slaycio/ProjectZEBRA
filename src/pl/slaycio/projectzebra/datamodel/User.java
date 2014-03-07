package pl.slaycio.projectzebra.datamodel;

import java.sql.SQLException;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {

	final static String GUI_TABLE_NAME = "U¿ytkownicy";
	
	public static final String USER_FIELD_NAME = "user";
	public static final String PASSWORD_FIELD_NAME = "password";
	public static final String OWNER_FIELD_NAME = "owner";
	public static final String CR_DATE_FIELD_NAME = "creation_date";
	public static final String CR_BY_FIELD_NAME = "created_by";
	
	@DatabaseField(generatedId = true, index = true)
	private int id;
	
	@DatabaseField(columnName = USER_FIELD_NAME, canBeNull = false)
	private String user;
	
	@DatabaseField(columnName = PASSWORD_FIELD_NAME, canBeNull = false)
	private String password;
	
	@DatabaseField(columnName = OWNER_FIELD_NAME, foreign = true)
	private AccountOwner owner;

	@DatabaseField(columnName = CR_DATE_FIELD_NAME, canBeNull = false)
	private Date creationDate;

	@DatabaseField(columnName = CR_BY_FIELD_NAME, canBeNull = false)
	private String createdBy;
	
	
	public User() {
		
	}

	public User(String user, String password,AccountOwner owner) {
		this.user = user;
		this.password = password;
		this.owner = owner;
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
	
	public String getUser() {
		this.refreshUsingDAO();
		return user;
	}

	public void setUser(String user) {
		this.user = user;
		this.saveUsingDAO();
	}

	public String getPassword() {
		this.refreshUsingDAO();
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
		this.saveUsingDAO();
	}

	public AccountOwner getOwner() {
		this.refreshUsingDAO();
		return owner;
	}

	public void setOwner(AccountOwner owner) {
		this.owner = owner;
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
			ORMinit.userDao.create(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public void updateUsingDAO() {
		try {
			ORMinit.userDao.update(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUsingDAO() {
		try {
			ORMinit.userDao.delete(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void refreshUsingDAO() {
		try {
			ORMinit.userDao.refresh(this);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}

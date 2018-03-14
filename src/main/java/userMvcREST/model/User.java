package userMvcREST.model;

public class User {
	// based on rdo_crud User Class v 2.0
	private Integer id;
	private String user_name;
	private String email;
	private String password;
	private String function;
	private String cust_lic;
	private Integer lic_val;
	private String cust_name;
	
	// Constructors
	public User(Integer id) {
		super();
		this.id = id;
	}
	
	public User(String user_name) {
		super();
		this.user_name = user_name;
	}
	
	public User(Integer id,String user_name,String email,
			String password,String function,String cust_lic,
			Integer lic_val,String cust_name) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.email = email;
		this.password = password;
		this.function = function;
		this.cust_lic = cust_lic;
		this.lic_val = lic_val;
		this.cust_name = cust_name;
		
	}
	
	public User() {
		super();
	}

	// Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getCust_lic() {
		return cust_lic;
	}
	public void setCust_lic(String user_lic) {
		this.cust_lic = user_lic;
	}
	public Integer getLic_val() {
		return lic_val;
	}
	public void setLic_val(Integer lic_val) {
		this.lic_val = lic_val;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}	
}

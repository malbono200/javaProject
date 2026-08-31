package bean;

public class MemberBean {
	private String id;
    private String pwd;
    private String name;
    private String email;
    
    public MemberBean() {
    	
    }

    public MemberBean(String id, String pwd, String name, String email) {
    	this.id = id;
    	this.pwd = pwd;
    	this.name = name;
    	this.email = email;
    }    
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpwd() {
		return pwd;
	}
	public void setpwd(String pw) {
		this.pwd = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

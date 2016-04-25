
public class Actors{

	//private ArrayList<String> namesDirectors;
	//private ArrayList<String> namesFilms;
	private String firstname;
	private String familyname;
	private String stgname;
	private String dob;
			
	public Actors(){		
	}
	
	

	public String getStgname() {
		return stgname;
	}
		
	
	public void setStgname(String stgname) {
		this.stgname= stgname;
	}
		
	
	public String getFirstname() {
		return firstname;
	}
		
	
	public void setFirstname(String firstname) {
		this.firstname= firstname;
	}
	
	public String getFamilyname() {
		return familyname;
	}
		
	
	public void setFamilyname(String familyname) {
		this.familyname= familyname;
	}
		
	
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getDob() {
		return dob;
	}
	

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Actor details - ");
		sb.append("FirstName:" + getFirstname());	
		sb.append("LastName:" + getFamilyname());
		sb.append("StageName:" + getFamilyname());
		sb.append("Dob:" + getDob());		
		sb.append(".");
		return sb.toString();
	}
}

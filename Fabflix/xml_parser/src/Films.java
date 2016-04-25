

public class Films {

	private String t;

	private int year;
	
	private String dirn;

	private String cat;
	
	public Films(){
		
	}
	
	public void Employee(String t, int year, String dirn,String cat) {
		this.t = t;
		this.year = year;
		this.dirn  = dirn;
		this.cat = cat;
		
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}


	public String getDirn() {
		return dirn;
	}

	public void setDirn(String dirn) {
		this.dirn = dirn;
	}	
	
	
	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}	
	
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Film Details - ");
		sb.append("Name:" + getT());
		sb.append(", ");
		sb.append("Year:" + getYear());
		sb.append(", ");
		sb.append("Director:" + getDirn());
		sb.append(", ");
		sb.append("Genre:" + getCat());
		sb.append(".");
		
		return sb.toString();
	}
}

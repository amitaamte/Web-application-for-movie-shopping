


public class Directors{

	//private ArrayList<String> namesDirectors;
	//private ArrayList<String> namesFilms;
	private String dirname;
	private String t;
	private String year;
	private String category;
		
	public Directors(){		
	}
	
	
	public String getName() {
		return dirname;
	}
		
	
	public void setName(String name) {
		this.dirname = name;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getTitle() {
		return t;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getYear() {
		return year;
	}
		
	
	public void setTitle(String t) {
		this.t = t;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Director details - ");
		sb.append("Name:" + getName());		
		sb.append("Title:" + getTitle());
		sb.append("Year:" + getYear());
		sb.append("Category:" + getCategory());
		sb.append(".");
		
		return sb.toString();
	}
}

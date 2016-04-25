import java.awt.List;
import java.util.HashMap;
import java.util.Set;

public class Casts {
	
	public HashMap Loading(HashMap hm1) throws Exception{	
		/*Set<String> keys = hm1.keySet();
		for(String i: keys){
			System.out.println(hm1.get(i));*/
		return hm1;
		}
	
	
	public HashMap Loading1(HashMap hm2) throws Exception{	
		/*Set<String> keys = hm2.keySet();
		for(String j: keys){
			System.out.println(hm2.get(j));
		}*/
		return hm2;
	}
	
	
		private String t;
		private String a;
					
		public Casts(){		
		}
		
		public void setStagename(String a) {
			this.a = a;
		}
		
		public String getStagename() {
			return a;
		}
		
		public String getTitle() {
			return t;
		}
		
		public void setTitle(String t) {
			this.t = t;
		}
		


		public String toString1(HashMap<String, List> hm1, HashMap<String, List>hm2) {
			StringBuffer sb = new StringBuffer();
			Set<String> keys = hm1.keySet();
			for(String i : keys){
				System.out.println(hm1.get(i));
			}
			
		    
			/*sb.append("Cast details - ");
			sb.append("StageName:" + getStagename());		
			sb.append("Title:" + getTitle());
			sb.append(".");*/
			String sn = getStagename();
			
			String title = getTitle();
			
			return sb.toString();		
		}
}
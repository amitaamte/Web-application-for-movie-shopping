import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;


public class LoaddB{	
	
	  public void LoadingNow(List mymain) throws Exception{	
				
		
		// SQL Driver
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				// Connect to the test database
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root",
						"webapps");
		  
   				Iterator it = mymain.iterator();
				while(it.hasNext()) {
				
				   Directors newDirector = (Directors)it.next();				   
				   String director = newDirector.getName();
				   //System.out.println( director);
				   String genre = newDirector.getCategory();
				  // System.out.println(genre); 
				   String year = newDirector.getYear();
				   //System.out.println(year);
				   String title = newDirector.getTitle();
				  // System.out.println(title);
				   
				
				   
				   try{
					   CallableStatement cs = connection.prepareCall("{CALL insert_movie(?,?,?,?,?,?)}");

				
					   cs.setNull(1, Types.NULL);
						cs.setString(2, title);
						cs.setString(3, year);
						cs.setString(4, director);
						cs.setString(5, genre);
						cs.registerOutParameter(6, java.sql.Types.VARCHAR);
				
						System.out.println("Before the execute");
						cs.execute();
						System.out.println("After the execute");
					
				   }
				
				   catch(Exception e){
					   System.out.println(e);
				   }
	  
		
				}
	  }
	  	}




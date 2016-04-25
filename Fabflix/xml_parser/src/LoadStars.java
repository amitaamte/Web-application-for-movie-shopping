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


public class LoadStars {

	public void Loading(List myactors) throws Exception{	


		// SQL Driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Connect to the test database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root",
				"webapps");

		Iterator it = myactors.iterator();
		while(it.hasNext()) {

			Actors newActor = (Actors)it.next();				   
			String firstname = newActor.getFirstname();
			//System.out.println( director);
			String familyname = newActor.getFamilyname();
			// System.out.println(genre); 
			String dob = newActor.getDob();
			//System.out.println(year);
			String stgname = newActor.getStgname();


			try{
				CallableStatement cs = connection.prepareCall("{CALL add_star(?,?,?,?,?)}");


				//if both first and last name doesn't exist, enter stage name 
				if(firstname.equals("")&& familyname.equals(""))
				{
					if (stgname.contains(" "))
					{
						String[] splited = stgname.split("\\s+");
						firstname = splited[0];
						familyname = splited[1];	   
					}
					//if only one stage name, then enter it as family name
					else
					{
						familyname = stgname;

					}
				}

				//if date of birth is empty, insert as 1900-01-01
				if(dob.equals("")||dob.equals("n.a.")||dob.equals("*")||dob.equals("~1945")||dob.equals("19bb")||dob.equals("dob"))
				{
					String dob1= "1900-01-01";
					dob=dob1;
				}
				//if date of birth is only year, append it with 01-01
				else if (dob.length()!="yyyyMMdd".length())
				{
					String x= new String();
					x="-01-01";
					String dob1= dob+x;
					dob=dob1;
				}

				cs.setNull(1, Types.NULL);
				cs.setString(2, firstname);
				cs.setString(3, familyname);
				cs.setString(4,dob);
				cs.registerOutParameter(5,java.sql.Types.VARCHAR);

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











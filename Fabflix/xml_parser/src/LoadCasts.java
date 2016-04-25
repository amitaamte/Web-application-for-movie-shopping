import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoadCasts {
	public void Loading(HashMap hm1) throws Exception{	
		Set<String> keys = hm1.keySet();
		for(String i: keys){
			System.out.println(hm1.get(i));
		}
	}
	
		public void Loading1(HashMap hm2) throws Exception{	
			Set<String> keys = hm2.keySet();
			for(String j: keys){
				System.out.println(hm2.get(j));
			}
		}
		/*
		// SQL Driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		// Connect to the test database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root",
				"webapps");

		/*Iterator it = hm1.iterator();
		while(it.hasNext()) {

			//Actors newActor = (Actors)it.next();				   
			
			
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
			}*/


		}
	


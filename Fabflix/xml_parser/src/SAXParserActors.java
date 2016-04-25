

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class SAXParserActors extends DefaultHandler{

	List myactors;
	
	private String tempVal;
	
	//to maintain context
	private Actors tempEmp;
	public static HashMap<String, List<String>> hm2 = new HashMap<String, List<String>>();
	
	
	public SAXParserActors(){
		myactors = new ArrayList();
	}
	
	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse("actors63.xml", this);
			
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){
		
		//System.out.println("No of Actors '" + myactors.size() + "'.");
		
		/*Iterator it = myactors.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}*/
		
		Set<String> keys = hm2.keySet();
		for(String i: keys){
			System.out.println(i);
		}
	}
	

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("actor")) {
			//create a new instance of employee
			tempEmp = new Actors();
			//tempEmp.setType(attributes.getValue("type"));
		}
	}
	

	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		myactors = new ArrayList();

		if(qName.equalsIgnoreCase("actor")) {
			//add it to the list
			
			
		}else if (qName.equalsIgnoreCase("firstname")) {
			tempEmp.setFirstname(tempVal);
		}else if (qName.equalsIgnoreCase("familyname")) {
			tempEmp.setFamilyname(tempVal);
		}else if (qName.equalsIgnoreCase("dob")) {
			tempEmp.setDob(tempVal);
			/*if(tempVal.equals(""))
			{
				String dob= "1900-01-01";
				tempVal = dob;
				System.out.println(tempVal);
			}
			else if (tempVal.length()!="yyyyMMdd".length())
			   {
				   String x= new String();
					x="-01-01";
					String dob1= tempVal+x;
					System.out.println(dob1);
			   }*/
		}
		else if (qName.equalsIgnoreCase("stagename")) {
			String sn = tempVal;
			//System.out.println(sn);
			tempEmp.setStgname(tempVal);
			/*if(tempVal.contains(" "))
			{
			String[] splited = tempVal.split("\\s+");
			   String firstname = splited[0];
			   System.out.println(firstname);
			   String familyname = splited[1];
			   System.out.println(familyname);	
		}
			else
			{
				String familyname=tempVal;
				System.out.println(familyname);
			}*/
			
			myactors.add(tempEmp);
			hm2.put(sn, myactors);
		}
		}
	
	/*public List ReturnResult(){
		return myactors;	
	
	}*/		
	
	public HashMap<String, List<String>> ReturnResult(){
		return hm2;	
	}		
	
	

//Function to parse elements of tempEmp and write to DB

public static void main(String[] args) throws Exception{
	SAXParserActors spe = new SAXParserActors();
	spe.runExample();
	Casts newobj2 = new Casts();
	newobj2.Loading1(hm2);
	
	
}

}




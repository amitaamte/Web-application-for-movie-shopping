
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class SAXParserCasts extends DefaultHandler{

	List myEmpls;
	
	private String tempVal;
	private String cast_name;
	
	
	
	//to maintain context
	public Casts tempEmp;
	
	
	public SAXParserCasts(){
		myEmpls = new ArrayList();
	}
	
	public void runExample() {
		parseDocument();
		//printData();
	}

	private void parseDocument() {
		
		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
		
			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			
			//parse the file and also register this class for call backs
			sp.parse("casts124.xml", this);
			
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
	/*private void printData(){
		
		System.out.println("No of Entries '" + myEmpls.size() + "'.");
		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
		System.out.println(it.next().toString());
	}
	}*/
	

	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("dirfilms")) {
			//System.out.println("I entered directorfilms start element");
			//create a new instance of employee
			//tempEmp = new Directors();
			//tempEmp.setType(attributes.getValue("type"));
		}
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}
	
	
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		//System.out.println("I entered the end element handler");
		if(qName.equalsIgnoreCase("dirfilms")) {
			//System.out.println("entered dirfilms!");
			//add it to the list
			//myEmpls.add(tempEmp);
			
		} else if (qName.equalsIgnoreCase("filmc")) {
			//System.out.println("entered filmc!");
		}
			//{cast_name = new String(tempVal);}
			//tempEmp.setName(tempVal);
		else if (qName.equalsIgnoreCase("m")) {
			//System.out.println("entered m!");				
		}
		else if(qName.equalsIgnoreCase("t")){
			tempEmp = new Casts();
			tempEmp.setTitle(tempVal);
			//System.out.println(tempVal);
		}else if(qName.equalsIgnoreCase("a")){
			tempEmp.setStagename(tempVal);
			//System.out.println(tempVal);
			//WritetoDB(tempEmp);
			myEmpls.add(tempEmp);
		}
	}
		
	/*
		public List ReturnResult(){
			return myEmpls;			
		}	*/	
		
	
	//Function to parse elements of tempEmp and write to DB
	
	public static void main(String[] args) throws Exception{
		SAXParserCasts spe = new SAXParserCasts();
		spe.runExample();
		/*LoaddB newobj = new LoaddB();
		newobj.LoadingNow(spe.ReturnResult());*/
	}	
}

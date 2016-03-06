package Test.java;
import java.io.*;
import java.util.*;
public class Phone {
	/*
	 * This class has 5 member functions.
	 * 1) To see if the file is valid. (If the file is empty)
	 * 2) To add an Entry
	 * 3) To delete an Entry
	 * 4) To get the number from the name of the user
	 * 5) To modify the entry entered by the user
	 */
	String name,number;
	File tempFile= new File("temp.txt");
	
	/*
	 * Pre Condition: The name and number are passed in by the user to add
	 * Post Condition: The name and number are added to the file
	 */
	public void addEntry(String name,String number){
		Properties property = new Properties();
		try{
			OutputStream outputStream = new FileOutputStream("src/main/java/phone.properties",true);
			property.setProperty(name,number);
			property.store(outputStream,null);
			outputStream.close();
		}
		
		catch(IOException ex){
			System.out.println("Unable to open file : "+ex);
		}	
		
		
		
	}
	/*
	 *Pre Condition: The name is provided by the user.
	 *Post Condition: The name of the user is deleted from the Directory, if present. 
	 */
	public void DeleteEntry(String name){
		
		Properties property = new Properties();
		try{
			InputStream inputStream = new FileInputStream("src/main/java/phone.properties");   //deleting
			property.load(inputStream);
			property.remove(name);
			inputStream.close();
			
			OutputStream outputStream = new FileOutputStream("src/main/java/phone.properties"); //after deletion
			property.store(outputStream , null);
			outputStream.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
		
	}
	
	/*
	 * Pre Condition: The name is passed in by the user.
	 * Post Condition: The number is returned, if present. If not presend, then NULL is returned.
	 */
	public String getNumber(String name){
		String number="";
		Properties property = new Properties();
		try{
			InputStream inputStream  = new FileInputStream("src/main/java/phone.properties");
			property.load(inputStream);
			number = property.getProperty(name);
			inputStream.close();
			
			//System.out.println(number);
			
			
		}
		
		catch(Exception e){
			System.out.println("File not found");
		}
		return number;
		
	}
	/*
	 * Pre condition: The name and number are passed in by the user/
	 * Post condition: The name and number are modified, if present.
	 */
	public void changeEntry(String name,String number){
		
		Properties property = new Properties();
		try{		
			InputStream inputStream = new FileInputStream("src/main/java/phone.properties");
			property.load(inputStream);
			property.replace(name, number);
			inputStream.close();
			
			OutputStream outputStream = new FileOutputStream("src/main/java/phone.properties"); 
			property.store(outputStream, null);
			outputStream.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
	}
}

package Test.java;
import java.io.*;
import java.util.*;
import java.util.*;
public class Phone {
	/*
	 * This class has 5 member functions.
	 * 1) To see if the file is empty
	 * 2) To add an Entry
	 * 3) To delete an Entry
	 * 4) To get the number from the name of the user
	 * 5) To modify the entry entered by the user
	 */
	
	/*
	 * Pre condition: File exits.
	 * Post condition: Return true if file is not empty.
	 */
	public boolean checkFile(){
		boolean answer=true;
		Properties property = new Properties();
		try{
			InputStream inputStream = new FileInputStream("src/main/resources/phone.properties");
			property.load(inputStream);
			if(inputStream.equals(null)){
				answer=false;
			}
		}
		catch(IOException ex){
			System.out.println("Unable to open file : "+ex);
		}	
		return answer;
	}
	/*
	 * Pre Condition: The name and number are passed in by the user to add
	 * Post Condition: The name and number are added to the file
	 */
	public void addEntry(String name,String number){
		Properties property = new Properties();
		try{
			/*
			 * true prevents the folder to get re-written
			 */
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties",true);
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
			InputStream inputStream = new FileInputStream("src/main/resources/phone.properties");  
			property.load(inputStream);
			/*
			 * String check is used to see if the name that is passed by the user is present or not.
			 */
			String check = property.getProperty(name);
			if(check==null){
				System.out.println("ERROR! The name not found");
				return;
			}
			property.remove(name);
			inputStream.close();
			/*
			 * Writes to the file after deletion is done.
			 */
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties"); 
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
			InputStream inputStream  = new FileInputStream("src/main/resources/phone.properties");
			property.load(inputStream);
			number = property.getProperty(name);
			inputStream.close();			
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
			InputStream inputStream = new FileInputStream("src/main/resources/phone.properties");
			property.load(inputStream);
			/*
			 * String check is used to see if the name that is passed by the user is present or not.
			 */
			String check = property.getProperty(name);
			String new_name,new_number;
			if(check==null){
				System.out.println("ERROR! The name not found");
				return;
			}
			/*
			 * Takes new input from user and changes the value
			 */
			Scanner inp = new Scanner(System.in);
			System.out.println("Enter the new name : ");
			new_name=inp.nextLine();
			name=new_name;
			System.out.println("Enter the new number : ");
			new_number=inp.nextLine();
			property.remove(name);
			property.setProperty(new_name, new_number);
			inputStream.close();
			/*
			 * Writes to the file after deletion is done.
			 */
			OutputStream outputStream = new FileOutputStream("src/main/resources/phone.properties"); 
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

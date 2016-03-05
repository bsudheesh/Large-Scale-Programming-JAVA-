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
	 * Pre Condition: The file exists.
	 * Post Condition: Will return -1 if the file is empty, or will return 0 is file is present
	 */
	public int checkValid(){
		File fileName= new File("file.txt");
		int temp=0;
		try{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int length=bufferedReader.read();
			if(length==-1){
				System.out.println("ERROR. The file is empty");
				temp= -1;
			}		
			bufferedReader.close();
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
		return temp;
	}
	
	/*
	 * Pre Condition: The name and number are passed in by the user to add
	 * Post Condition: The name and number are added to the file
	 */
	public void addEntry(String name,String number){
		File fileName= new File("file.txt");
		try{
			FileWriter fileWriter  = new FileWriter(fileName,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String new_Line=name;
			new_Line=new_Line.concat(" "+number);
			bufferedWriter.write(new_Line);
			bufferedWriter.newLine();	
			bufferedWriter.close();
			
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
		File fileName = new File("file.txt");
		String line=null;
		/*
		 * The number for the corresponding name is stored in number
		 * by calling function getNumber().
		 * The name and number are concatinated to match the pattern as present in the file.
		 */
		String number=getNumber(name);
		String new_name = name.concat(" "+number);
		List<String> list = new ArrayList<String>();
		/*
		 * A list of strings is declared. The values that are not equal to the name are added to the list.
		 */
		int count=0;
		/*
		 * The variable count is used to see if the name entered is found or not.
		 * If the value of count dosn't change, the user is notified that the number is not found
		 */
		try{
			FileReader fileReader = new FileReader(fileName);			
			BufferedReader bufferedReader = new BufferedReader(fileReader);			
			String line_to_delete=new_name;
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(line_to_delete)){
					count++;
					continue;
				}
				else{
					list.add(line);
				}
			}
			bufferedReader.close();
			if(count==0){
				System.out.println("ERROR! " +name + " is not in the Directory");
				return;
			}
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			/*
			 * Writing all the components of the list to the file.
			 */
			for(int i=0;i<list.size();i++){
				bufferedWriter.write(list.get(i));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			System.out.println(name + " is deleted.");
			
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
		Scanner x;
		int count=0;
		/*
		 * The variable count is used to see if the name entered is found or not.
		 * If the value of count dosn't change, the user is notified that the number is not found
		 */
		String a="",b="";
		/*
		 * The file is read string by string.
		 * When the name is found the number is entered.
		 */
		try{
			x=new Scanner(new File("file.txt"));			
			while(x.hasNext()){
				a = x.next();
				if(a.equals(name)){
					count++;
					b= x.next();
					break;
				}
			}
			
		}
		catch(Exception e){
			System.out.println("File not found");
		}
		if(count==0){
			System.out.println("ERROR! " + name + " is not in Directory");
			return "NULL";
		}
		else{
			return b;
		}
		
	}
	/*
	 * Pre condition: The name and number are passed in by the user/
	 * Post condition: The name and number are modified, if present.
	 */
	public void changeEntry(String name,String number){
		
		File fileName = new File("file.txt");
		String line=null;		
		String new_name = name.concat(" "+number);
		/*
		 * The number for the corresponding name is stored in number
		 * by calling function getNumber().
		 * The name and number are concatinated to match the pattern as present in the file.
		 */
		int count=0;
		List<String> list = new ArrayList<String>();
		/*
		 * When the matched line is found, the new name and number entered
		 * by the user is stored in place of the line in the Directory.
		 */
		try{
			FileReader fileReader = new FileReader(fileName);			
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(new_name)){
					count++;
					Scanner in =new Scanner (System.in);
					System.out.println("Enter the new name to be entered : ");
					String new__name;
					new__name=in.nextLine();
					System.out.println("Enter the new number to be entered : ");
					String new_number;
					new_number=in.nextLine();
					new__name=new__name.concat(" "+new_number);
					list.add(new__name);
				}
				else{
					list.add(line);
					
				}
			}
			bufferedReader.close();
			if(count==0){
				System.out.println("ERROR!!! The items not found in Directory");
			}
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			/*
			 * All contents of the list are not written to the file.
			 */
			for(int i=0;i<list.size();i++){
				bufferedWriter.write(list.get(i));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
	}
}

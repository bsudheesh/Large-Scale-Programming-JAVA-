import java.io.*;
import java.util.*;
public class Phone {
	String name,number;
	
	File tempFile= new File("temp.txt");
	public void addEntry(String name,String number){
		//FileReader fileReader = new FileReader(fileName);
		File fileName= new File("file.txt");
		try{
			FileWriter fileWriter  = new FileWriter(fileName,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(name);
			bufferedWriter.write(" ");
			bufferedWriter.write(number);
			bufferedWriter.newLine();	
			bufferedWriter.close();
			
		}
		catch(IOException ex){
			System.out.println("Unable to open file : "+ex);
		}		
		
		
	}
	public void DeleteEntry(String name){
		File fileName = new File("file.txt");
		File tempFile =new File("temp.txt");
		String line=null;
		String number=getNumber(name);
		String new_name = name.concat(" "+number);
		boolean successful=false;
		try{
			FileReader fileReader = new FileReader(fileName);
			FileWriter fileWriter = new FileWriter(tempFile,true);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String line_to_delete=new_name;
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(line_to_delete)){
					continue;
				}
				else{
					bufferedWriter.write(line);
					bufferedWriter.newLine();
					successful=true;
				}
			}
			bufferedReader.close();
			bufferedWriter.close();
			if(successful){
				tempFile.renameTo(fileName);
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
		
	}
	public String getNumber(String name){
		Scanner x;
		String a="",b="";
		try{
			x=new Scanner(new File("file.txt"));
			while(x.hasNext()){
				a = x.next();
				if(a.equals(name)){
					b= x.next();
				}
			}
			
		}
		catch(Exception e){
			System.out.println("File not found");
		}
		if(b.equals("")){
			return "NULL";
		}
		else{
			return b;
		}
		
	}
	public void changeEntry(String name,String number){
		File fileName = new File("file.txt");
		File tempFile =new File("temp.txt");
		String line=null;
		boolean successful=false;
		try{
			FileReader fileReader = new FileReader(fileName);
			FileWriter fileWriter = new FileWriter(tempFile,true);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(name)||line.equals(number)){
					Scanner in =new Scanner (System.in);
					System.out.println("Enter the new name to be entered : ");
					String new_name;
					new_name=in.nextLine();
					System.out.println("Enter the new number to be entered : ");
					String new_number;
					new_number=in.nextLine();
					new_name=new_name.concat(" "+new_number);
					bufferedWriter.write(new_name);
					bufferedWriter.newLine();
				}
				else{
					bufferedWriter.write(line);
					bufferedWriter.newLine();
					successful=true;
				}
			}
			bufferedReader.close();
			bufferedWriter.close();
			if(successful){
				tempFile.renameTo(fileName);
			}
		}
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
	}
}

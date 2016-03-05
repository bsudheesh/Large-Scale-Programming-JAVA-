import java.io.*;
import java.util.*;
public class Phone {
	String name,number;
	File tempFile= new File("temp.txt");
	
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
			
			
		}
		
		catch(FileNotFoundException ex){
			System.out.println("Unable to oepn file");
		}
		catch(IOException ex){
			System.out.println("File not opened.");
		}
		return temp;
	}
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
		List<String> list = new ArrayList<String>();
		boolean successful=false;
		try{
			FileReader fileReader = new FileReader(fileName);			
			BufferedReader bufferedReader = new BufferedReader(fileReader);			
			String line_to_delete=new_name;
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(line_to_delete)){
					continue;
				}
				else{
					list.add(line);
				}
			}
			bufferedReader.close();
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
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
		File tempFile =new File("file.txt");
		String line=null;		
		String new_name = name.concat(" "+number);
		List<String> list = new ArrayList<String>();
		try{
			FileReader fileReader = new FileReader(fileName);			
			BufferedReader bufferedReader = new BufferedReader(fileReader);	
			
			while((line=bufferedReader.readLine())!=null){
				if(line.equals(new_name)){
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
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
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

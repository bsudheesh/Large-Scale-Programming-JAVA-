package Main.java;
import Test.java.Phone;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args){
		String name,number,repeat;
		System.out.println("HELLO");
		System.out.println("\tPress 1 for Add entry. \tPress 2 for Delete entry.\tPress 3 to get number. \tPress 4 to change contact");
		int choice;
		Phone object=new Phone();		
		do{
			System.out.println("Enter your choice : ");
			Scanner in = new Scanner(System.in);
			choice=in.nextInt();
			if(choice ==1){
				//String name,number;
				Scanner name_object = new Scanner(System.in);
				Scanner number_object= new Scanner(System.in);
				System.out.println("Enter the name : ");
				name=name_object.nextLine();
				System.out.println("Enter the number : ");
				number=number_object.nextLine();
				object.addEntry(name, number);
			}
			int length = object.checkValid();
			if(length==-1){
				System.out.println("ERROR!!. The File is empty");
			}
			else if(length==0){
				if(choice==2){
							
						Scanner name_object= new Scanner(System.in);
						System.out.println("Enter the name to be deleted : ");
						name=name_object.nextLine();
						object.DeleteEntry(name);
				}
				
				else if(choice==3){
					Scanner name_object= new Scanner(System.in);
					System.out.println("Enter the name whose number is to be found : ");
					name = name_object.nextLine();
					number=object.getNumber(name);
					System.out.println("The number is : " + number);
				}
				else if(choice==4){
					Scanner name_object= new Scanner(System.in);
					Scanner number_object= new Scanner(System.in);
					System.out.println("Enter the name to be modified : ");
					name=name_object.nextLine();
					System.out.println("Enter the number to be modified : ");
					number=number_object.nextLine();
					object.changeEntry(name, number);
								
				}
			}
			else{
				System.out.println("Wrong choice entered");
			}
			System.out.println("Do you want to continue : (yes, y)");
			Scanner reapeat_object=new Scanner (System.in);
			repeat=reapeat_object.nextLine();
		}while((repeat.equals("yes"))||(repeat.equals("y")));
	}
	
}

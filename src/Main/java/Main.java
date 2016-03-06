package Main.java;
import Test.java.Phone;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args){
		/* name is for the name entered the user.
		 * number is for the number to be entered by user
		 * repeat is to allow user to do different functions multiple times
		 */
		String name,number,repeat;
		System.out.println("HELLO");
		System.out.println("\tPress 1 for Add entry. \tPress 2 for Delete entry.\tPress 3 to get number. \tPress 4 to change contact");
		int choice;
		Phone object=new Phone();	
		/* 
		 * User has the following options, press
		 * 1 To add an entry to the file
		 * 2 To delete an entry to the file
		 * 3 To get the number for the name
		 * 4 Modify existing name and number to the file
		 */
		do{
			System.out.println("Enter your choice : ");
			Scanner in = new Scanner(System.in);
			choice=in.nextInt();
			if(choice ==1){
				/*
				 * Allows user to add entries to the file
				 */
				Scanner name_object = new Scanner(System.in);
				Scanner number_object= new Scanner(System.in);
				System.out.println("Enter the name : ");
				name=name_object.nextLine();
				System.out.println("Enter the number : ");
				number=number_object.nextLine();
				/*
				 * The name and the number entered is passed in to add to the file
				 */
				object.addEntry(name, number);
			}
			/*
			 * Inorder for the files to delete, return number or change it, they must not be empty.
			 * checkFile() will check to see if the files are empty
			 */
			else if(object.checkFile()){
				if(choice==2){
							/*
							 * Allows user to delete entry from the file	
							 */
							Scanner name_object= new Scanner(System.in);
							System.out.println("Enter the name to be deleted : ");
							name=name_object.nextLine();
							object.DeleteEntry(name);
					}
					
				else if(choice==3){
						/*
						 * Allows user to get the number for the corresponding name
						 */
						Scanner name_object= new Scanner(System.in);
						System.out.println("Enter the name whose number is to be found : ");
						name = name_object.nextLine();
						number=object.getNumber(name);
						if(number==null){
							System.out.println("ERROR! The name entered is not found");
						}
						/*
						 * The name is passed as an argument and the number is returned back
						 */
						else{
							System.out.println("The number is : " + number);
						}
					}
				else if(choice==4){
						/* 
						 * Allows user to modify existing contact
						 */
						Scanner name_object= new Scanner(System.in);
						Scanner number_object= new Scanner(System.in);
						System.out.println("Enter the name to be modified : ");
						name=name_object.nextLine();
						System.out.println("Enter the number to be modified : ");
						number=number_object.nextLine();
						/*
						 * The name and number is passed as an argument to be modified.
						 */
						object.changeEntry(name, number);
						object.DeleteEntry(name);
									
					}
			}
			else if(!object.checkFile()){
				System.out.println("ERROR!! The file is empty");
			}
			
			else{
				/*
				 * If the user choice is invalid.
				 */
				System.out.println("Wrong choice entered");
			}
			System.out.println("Do you want to continue : (yes, y)");
			Scanner reapeat_object=new Scanner (System.in);
			repeat=reapeat_object.nextLine();
			/*
			 * This loop will execute till the user wants it to run.
			 * User may press "yes" or "y" to execute this statement.
			 */
		}while((repeat.equals("yes"))||(repeat.equals("y")));
	}
	
}

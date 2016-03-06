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
		do{
			System.out.println("Enter your choice : ");
			Scanner in = new Scanner(System.in);
			choice=in.nextInt();
			if(choice ==1){
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
			else if(choice==2){
							
						Scanner name_object= new Scanner(System.in);
						System.out.println("Enter the name to be deleted : ");
						/*
						 * The name is passed as an arugment to be deleted
						 */
						name=name_object.nextLine();
						object.DeleteEntry(name);
				}
				
			else if(choice==3){
					Scanner name_object= new Scanner(System.in);
					System.out.println("Enter the name whose number is to be found : ");
					name = name_object.nextLine();
					number=object.getNumber(name);
					if(number.equals(null)){
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

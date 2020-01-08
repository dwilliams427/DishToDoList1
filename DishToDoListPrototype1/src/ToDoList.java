package DishToDoListPrototype1;
import java.util.ArrayList; 
import java.util.Scanner;



public class ToDoList {
	public static int itemCount = 0;
	
	//create new list of dishes
	public static ArrayList <Dish> dishList = new  ArrayList();
	
	// import scanner for user input
	static Scanner keyboard = new Scanner(System.in);
	

	public ToDoList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {		
		
		mainMenu();		
		
	}
	
	public static void mainMenu() throws Exception {
		char option = 'x';
		
		System.out.println("Hello and Welcome to your Dish Organizer. \n  What would you like to do?");
		System.out.println("V � View All Dishes\r\n" + 
				"A � Add Dish\r\n" + 
				"D � Delete Dish\r\n" +  
				"X � Exit\n");
						
		option = keyboard.nextLine().toUpperCase().charAt(0); 
	
		switch (option) 
        {
            case 'V':  viewAllDishes();            		 
                     break;
            case 'A':  addDish();             		  
                     break;
            case 'D':  deleteDish();            	
                     break;	       
            case 'X':  mainMenu();
                     break;
          
            default: System.out.println("Invalid option. Try again.");
                       mainMenu();
                     break;             
        }
	}
	
	public static void viewAllDishes() {
		
		if (dishList.size() == 0) {
			System.out.println("No dishes yet. Please add one now");
		}
		else {
			
			System.out.println("Here are your dishes:\n");
			
			for (int i =0; i < dishList.size(); i++) {
				System.out.println(dishList.get(i) + " \n");
				itemCount++;
			}
			
			mainMenu(); //exit
			
		}
	}
	
	public static void addDish() {
		String dishName = "";
		
		System.out.println("Enter your dish name now:\n");
		dishName = keyboard.nextLine(); // TODO: add user validation
		
		Dish newDish = new Dish(dishName); // create new dish with new name
		
		dishList.add(newDish); // add to list
		
		mainMenu();
		
	}
	
	public static void deleteDish() {
		int choice = 0;
		/*
		 * gives each dish in the list a number that 
		 * will be used to select which dish to delete, 
		 * instead of parsing by string, which will require 
		 * much more user validation
		 */
		int count = 1;
		
		System.out.println("Here are your current dishes:\n");
		
		for (int i =0; i < dishList.size(); i++) {
			System.out.println(count + ": " + dishList.get(i) + " \n");
			count++;
		}
		
		System.out.println("Select a dish by number:\n");
			
		choice = keyboard.nextInt(); //TODO: add user validation
		
		
	}

}

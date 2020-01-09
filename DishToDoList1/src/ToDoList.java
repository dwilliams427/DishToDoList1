import java.util.ArrayList; 
import java.util.Scanner;



public class ToDoList {	
	//create new list of dishes
	public static ArrayList <Dish> dishList = new ArrayList<Dish>();
	
	// import scanner for user input
	static Scanner keyboard = new Scanner(System.in);	

	public ToDoList() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {		
		System.out.println("Hello and Welcome to your Dish Organizer. \nWhat would you like to do?");
		mainMenu();				
	}
	
	public static void mainMenu() throws Exception {
		keyboard.reset();//TODO: clear buffer/scanner
		
		char option = 'x';		
		
		System.out.println("V   View All Dishes\r\n" + 
				"A   Add Dish\r\n" + 
				"D   Delete Dish\r\n" +  
				"X   Exit\n");						
		try
		{
		option = keyboard.nextLine().toUpperCase().charAt(0);
		} catch (Exception e)
		{
			e.getMessage();
			return;
		}
		
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
	
	public static void viewAllDishes() throws Exception {
		
		if (dishList.size() == 0) {
			System.out.println("No dishes yet. Please add one now");
			
			addDish();
		}
		else {			
			System.out.println("Here are your dishes:\n");
			
			for(Dish dish:dishList) {
				System.out.println(dish.getName());				
			}			
			mainMenu(); //exit			
		}
	}
	
	public static void addDish() throws Exception {
		keyboard.reset(); //clear scanner
		String dishName = "";
		
		System.out.println("Enter your dish name now:\n");
		
		try {
			dishName = keyboard.nextLine();
		}catch (Exception e) {
			e.getMessage();
			return;
		}		
		Dish newDish = new Dish(dishName); // create new dish with new name
		
		dishList.add(newDish); // add to list
		
		mainMenu();
		
	}
	
	public static void deleteDish() throws Exception {
		keyboard.reset(); // clear scanner
		int choice = 0;
		/*
		 * gives each dish in the list a number that 
		 * will be used to select which dish to delete, 
		 * instead of parsing by string, which will require 
		 * much more user validation
		 */
		
		if (dishList.size() == 0) { //if no dishes, add dish
			System.out.println("No dishes yet. Please add one now");
			
			addDish();
		}
		else {		
			System.out.println("Here are your current dishes:\n");
			
			for (int i =0; i < dishList.size(); i++) {
				System.out.println((i + 1) + ": " + dishList.get(i).getName() + " \n");				
			}			
			System.out.println("Select a dish by number:\n");
				
			try
			{
				choice = keyboard.nextInt();
			} catch (Exception e)
			{
				e.getMessage();
				return;
			}
			
			dishList.remove(choice - 1); // remove selected dish by subtracting 1 from input to = correct index
			
//			print out the new list			
			for (int i =0; i < dishList.size(); i++) {
				System.out.println((i + 1) + ": " + dishList.get(i).getName() + " \n");				
			}
			keyboard.reset();
			mainMenu();// exit
		}
	}

}

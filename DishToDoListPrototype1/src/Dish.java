package DishToDoListPrototype1;

public class Dish {
	
	// Potential dish attributes
	String name = "";
	String description = "";
	int rating = 0;
	

	public Dish(String n) {
		name = n;
//		description = d;
//		rating = r;
	}
	
	//getters and setters
	public void setName (String n) { n = name;}
	public String getName() {return name;}
//	public void setDescription (String d) { d = description;}
//	public String getDescription() {return description;}
//	public void setRating (int r) { r = rating;}
//	public int getRating() {return rating;}

}

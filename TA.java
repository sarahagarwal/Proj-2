/*
 * The TA class represents a Teaching Assistant with attributes such as first
 *  name, last name, number of hours worked, number of graded projects, and 
 *  pay. It provides methods to initialize TA object with first name and last 
 *  name, check if the TAs are equals, retrieve first name, last name, number 
 *  of hours worked, number of graded projects,  and pay, as well as methods 
 *  to add hours worked and graded projects.
 */


package taPayrollManagerSystem;

public class TA {

    private String firstName; // First name of the TA
    private String lastName; // Last name of the TA
    protected int numHours; // Number of hours worked
    protected int gradedProjects; // Number of graded projects
    private double pay; // Pay of the TA

    
   //Constructs a TA object with the specified first name and last name.
    public TA(String firstName, String lastName) {
    	
        //Initializes number of hours worked, number of graded projects,
    	//and pay to 0.

        this.firstName = firstName;
        this.lastName = lastName;
        numHours = 0;
        gradedProjects = 0;
        pay = 0.0;
        
    }

   //Checks if the current TA object is equal to another object based on
   //their first and last names.
    @Override
    public boolean equals(Object obj) {
    	
        //returns true if the objects are equal, false otherwise.

    	boolean result = false;
    	
        if (this == obj) {
        	
        	result = true;
            
        }
        
        if (obj == null || getClass() != obj.getClass()) {
        	
        	result = false;

        }
        
        TA other = (TA) obj;
        result = firstName.equals(other.firstName) && lastName.equals(other.lastName);
        return result;
        
    }

    
     // retrieves and returns The first name of the TA.
    public String getFirstName() {
    	
        return firstName;
        
    }

//Adds the specified number of hours to the total number of hours worked.    
    public void addNumHours(int hours) {
    	
        numHours += hours;
        
    }

    //  Retrieves and returns the total number of hours worked by the TA.
    public int getNumHours() {
    	
        return numHours;
        
    }

    //Retrieves and returns the last name of the TA.
    public String getLastName() {
    	
        return lastName;
        
    }

    // Adds the specified number of graded projects to the total number 
    //of graded projects.
    public void addGradedProjects(int projects) {
    	
        gradedProjects += projects;
        
    }

    //Retrieves and returns the total number of graded projects for the TA.
    public int getGradedProjects() {
    	
        return gradedProjects;
        
    }

   //Retrieves and returns the pay of the TA.
    public double getPay() {
    	
        return pay;
        
    }
}
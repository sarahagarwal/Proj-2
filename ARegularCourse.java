package taPayrollManagerSystem;

//I, Sarah Agarwal, pledge on my honor that I have not given on received
//any unauthorized assistance on this assignment. 

/*
 * The ARegularCourse class represents a regular course in the university
 * curriculum. It manages the teaching assistants (TAs) assigned to the course,
 * including undergraduate and graduate TAs. It provides methods to add TAs,
 * manage office hours, grade projects, and calculate paycheck amounts for TAs.
 */


public class ARegularCourse {

	private String department; // Department of the course
    private int courseNumber; // Number of the course
    private int TAMaxNum; // Maximum number of TAs allowed for the course
    private LarryList TAs; // List of TAs assigned to the course
    private int currElem; // Current number of TAs assigned
    private boolean diffCourse = false; //Flag indicating if course is diff

	
	// Constructs an ARegularCourse object with the specified department, course
    // number, and maximum number of TAs allowed. Initializes course with the
    // given parameters and an empty list of TAs.
    public ARegularCourse(String department, int courseNumber, int TAMaxNum) {
    
        this.department = department; // Set the department
        this.courseNumber = courseNumber; // Set the course number
        this.TAMaxNum = TAMaxNum; // Set the maximum number of TAs allowed
        TAs = new LarryList(TAMaxNum); // Initialize list of TAs
        currElem = 0; // Initialize current number of TAs
    
    }
    
    // Marks the course as a different course.
    public void diffCourse() {
    	diffCourse = true;
    }

 // Retrieves the name of the course by combining the department and course
    // number.
    public String getCourseName() {
    	
    	return department + " " + courseNumber;
    }

 // Adds an undergraduate TA to the course with the specified first name,
 // last name, and hourly salary.
 public boolean addUGTA(String firstName, String lastName, double hourlySalary){
	 
     boolean result = false;
     
     // Check if provided inputs are valid
     if (firstName != null && lastName != null && !firstName.isEmpty() && 
    		 !lastName.isEmpty() && hourlySalary > 0) {
    	 
         boolean found = false;
         
         // Check if the TA already exists
         for (int i = 0; i < currElem; i++) {
        	 
             TA newTa = (TA) TAs.get(i);
             
             if (newTa.getFirstName().equals(firstName) && 
            		 newTa.getLastName().equals(lastName)) {
            	 
                 found = true;
                 
             }
         }
         
         // If the TA doesn't exist, proceed with adding
         if (!found) {
        	 
             // Check if the list of TAs is not full
        	 //if its not full, add the TA
             if (!TAs.isFull()) {
            	 
                 UGTA newTA = new UGTA(firstName, lastName, hourlySalary);
                 TAs.add(newTA);
                 currElem++;
                 result = true;
                 
             } else {
            	 
                 // If list is full, and it's a different course, resize list
            	 //then add the TA
                 if (diffCourse) {
                	 
                     TAs.resize();
                     TAMaxNum *= 2;
                     UGTA newTA = new UGTA(firstName, lastName, hourlySalary);
                     TAs.add(newTA);
                     currElem++;
                     result = true;
                     
                 }
             }
         }
     }
     return result;
 }

 // Adds a graduate TA (GradTA) to the course with the specified first name,
 // last name, and yearly salary.
 public boolean addGradTA(String firstName, String lastName, double yearlySalary) {
	 
     boolean result = false;
     
     // Check if provided inputs are valid
     if (firstName != null && lastName != null && !firstName.isEmpty() && 
    		 !lastName.isEmpty() && yearlySalary > 0) {
    	 
         boolean found = false;
         
         // Check if the TA already exists
         for (int i = 0; i < currElem; i++) {
        	 
             TA newTa = (TA) TAs.get(i);
             if (newTa.getFirstName().equals(firstName) && 
            		 newTa.getLastName().equals(lastName)) {
            	 
                 found = true;
                 
             }
         }
         // If the TA doesn't exist, proceed with adding
         if (!found) {
        	 
             // Check if the list of TAs is not full
        	 //if not full, add TA
             if (!TAs.isFull()) {
            	 
                 GradTA newTA = new GradTA(firstName, lastName, yearlySalary);
                 TAs.add(newTA);
                 currElem++;
                 result = true;
                 
             } else {
            	 
                 // If list is full, and it's a different course, resize list
            	 //then add the TA
                 if (diffCourse) {
                	 
                     TAs.resize();
                     TAMaxNum *= 2;
                     GradTA newTA = new GradTA(firstName, lastName, yearlySalary);
                     TAs.add(newTA);
                     currElem++;
                     result = true;
                     
                 }
             }
         }
     }
     return result;
 }
 
 // Retrieves and returns the maximum number of TAs allowed for the course.

    public int getTACapacity() {
    	
    	return TAMaxNum;
    }

 // Calculates the extra capacity for additional TAs that can be added to the
    // course.
    public int extraCapacity() {

    	return getTACapacity() - currElem;
    }

    //Adds office hours to a TA with the specified first name, last name, and
    //number of hours. If successful, updates the TA's total number of hours worked
    public boolean holdSomeOfficeHours(String firstName, String lastName, int numHours) {
    	
        boolean result = false;
        
        // Check if provided inputs are valid
        if (firstName != null && !firstName.isEmpty() && lastName != null && 
        		!lastName.isEmpty() && numHours > 0) {
        	
            // Loop through the list of TAs
            for (int i = 0; i < TAs.numElement; i++) {
            	
                TA ta = (TA)TAs.get(i);
                
                // check the TA with matching first and last names
                if (ta.getFirstName().equals(firstName) && 
                		ta.getLastName().equals(lastName)) {
                	
                    int currHours = ta.getNumHours();
                    
                    // Add the provided number of hours to the TA's total hours
                    ta.addNumHours(numHours);
                    
                    // If the total hours changed, update the result
                    if (currHours != ta.getNumHours()) {
                    	
                        result = true;
                        
                    }
                }
            }
        }
        return result;
    }
    
    //Retrieves and returns the total number of office hours held by a TA with 
    //the specified first name and last name.
    public int numOfficeHoursHeld(String firstName, String lastName) {
    	
        int result = -1; // Initialize result to -1
        
        // Check if provided inputs are valid
        if (firstName != null && !firstName.isEmpty() && lastName != null 
        		&& !lastName.isEmpty()) {
        	
            // Loop through the list of TAs
            for (int i = 0; i < TAs.numElement; i++) {
            	
                TA ta = (TA)TAs.get(i);
                
                // Find the TA with matching first and last names
                if (ta.getFirstName().equals(firstName) && 
                		ta.getLastName().equals(lastName)) {
                	
                    result = ta.getNumHours(); // Get total hours worked by  TA
                }
            }
        }
        return result;
    }

    //Grades projects for a TA with the specified first name and last name. Updates
    //the total number of graded projects for the TA.
    public boolean gradeProjects(String firstName, String lastName, int numProjects) {
    	
        boolean result = false; // Initialize result to false
        
        // Check if provided inputs are valid
        if (firstName != null && !firstName.isEmpty() && lastName != null && 
        		!lastName.isEmpty() && numProjects > 0 && numProjects % 2 == 0) {
        	
            // Loop through the list of TAs
            for (int i = 0; i < TAs.numElement; i++) {
            	
                TA ta = (TA)TAs.get(i);
                
                // Find the TA with matching first and last names
                if (ta.getFirstName().equals(firstName) &&
                		ta.getLastName().equals(lastName)) {
                	
                    int graded = ta.getGradedProjects(); // Get total graded projects
                    ta.addGradedProjects(numProjects); // Add provided number of projects
                    
                    // If the total graded projects changed, update the result
                    if (graded != ta.getGradedProjects()) {
                    	
                        result = true;
                        
                    }
                }
            }
        }
        return result;
    }

    // Retrieves and returns the total number of projects graded by a TA with 
    //the specified first name and last name.
    public int numProjectsGraded(String firstName, String lastName) {
    	
        int result = -1; // Initialize result to -1
        
        // Check if provided inputs are valid
        if (firstName != null && !firstName.isEmpty() && lastName != null && 
        		!lastName.isEmpty()) {
        	
            // Loop through the list of TAs
            for (int i = 0; i < TAs.numElement; i++) {
            	
                TA ta = (TA)TAs.get(i);
                
                // Find the TA with matching first and last names
                if (ta.getFirstName().equals(firstName) && 
                		ta.getLastName().equals(lastName)) {
                	
                    result = ta.getGradedProjects(); // Get the total graded projects
                    
                }
            }
        }
        return result;
    }


    //Retrieves and returns the paycheck amount for a TA with the specified first
    //name and last name.
    public double getPaycheckAmount(String firstName, String lastName) {
    	
        double result = -1.0; // Initialize result to -1.0
        
        // Check if provided inputs are valid
        if (firstName != null && !firstName.isEmpty() && lastName != null &&
        		!lastName.isEmpty()) {
        	
            // Loop through the list of TAs
            for (int i = 0; i < TAs.numElement; i++) {
            	
                TA ta = (TA)TAs.get(i);
                
                // Find the TA with matching first and last names
                if (ta.getFirstName().equals(firstName) && 
                		ta.getLastName().equals(lastName)) {
                	
                    result = ta.getPay(); // Get the paycheck amount of the TA
                    
                }
            }
        }
        return result;
    }
}

/*
 * The UGTA class represents an Undergraduate Teaching Assistant, which is a
 * specialized type of TA. It extends the TA class and adds functionality
 * specific to undergraduate TAs, such as hourly salary. It provides methods
 * to initialize UGTA object with first name, last name, and hourly salary, 
 * add hours worked (with a limit of 20 hours per week), add graded projects 
 * (with a limit based on remaining hours), and calculate pay based on total
 *  hours worked and graded projects.
 */

//I, Sarah Agarwal, pledge on my honor that I have not given on received
//any unauthorized assistance on this assignment. 

package taPayrollManagerSystem;

public class UGTA extends TA {

    private double hourlySalary; // Hourly salary of the UGTA

  
    //Constructs an UGTA object with the specified first name, last name, and
    //hourly salary. Initializes the UGTA with first name, last name, and 
    //hourly salary.
    public UGTA(String firstName, String lastName, double hourlySalary) {
    	
        super(firstName, lastName); //The first and last name of the UGTA.
        this.hourlySalary = hourlySalary; //The hourly salary of the UGTA.
    }
    

   //Adds the specified number of hours to the total number of hours worked, 
   //with a limit of 20 hours per week.
    @Override
    public void addNumHours(int hours) {
    	
        if (numHours + hours <= 20) {
            numHours += hours;
        }
        
    }

    //Adds the specified number of graded projects to the total number of 
    //graded projects, with a limit based on remaining hours available.
    @Override
    public void addGradedProjects(int projects) {
    	
        if ((gradedProjects + projects) / 2 <= (20 - numHours)) {
            gradedProjects += projects;
        } 
        
    }

  //Calculates the pay of the UGTA based on total hours worked and graded
   //projects.
    @Override
    public double getPay() {
    	
    	//returns the pay of the UGTA
        return (numHours + gradedProjects / 2) * hourlySalary;
        
    }
}
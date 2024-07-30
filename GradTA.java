/*
 * The GradTA class represents a Graduate Teaching Assistant, which is a 
 * specialized type of TA. It extends the TA class and adds functionality 
 * specific to graduate TAs, such as yearly salary. It provides methods to 
 * initialize GradTA object with first name, last name, and yearly salary, 
 * add hours worked, add graded projects (with a limit of 150 projects), and 
 * calculate pay based on yearly salary.
 */


//I, Sarah Agarwal, pledge on my honor that I have not given on received
//any unauthorized assistance on this assignment. 


package taPayrollManagerSystem;

public class GradTA extends TA {

    private double yearlySalary; // Yearly salary of the GradTA

    
     //Constructs a GradTA object with the specified first name, last name, &
     //yearly salary. Initializes the GradTA with first name, last name, and
     //yearly salary.
    public GradTA(String firstName, String lastName, double yearlySalary) {
    	
        super(firstName, lastName); // The first and last name of the GradTA.
        this.yearlySalary = yearlySalary; // The yearly salary of the GradTA.
        numHours = 0; // Initializes the number of hours worked to 0.
        
    }

    //Adds the specified number of hours to the total number of hours worked.
    @Override
    public void addNumHours(int hours) {
    	
        numHours += hours;
        
    }

   
     //Adds the specified number of graded projects to the total number of
     //graded projects, with a limit of 150 projects.
    @Override
    public void addGradedProjects(int projects) {
    	
        if (gradedProjects + projects <= 150) {
            gradedProjects += projects;
        }
        
    }

    //Calculates and returns the pay of the GradTA based on yearly salary.
    @Override
    public double getPay() {
    	
        return yearlySalary / 21; // Divides the yearly salary by 21.
        
    }
}


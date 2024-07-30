package taPayrollManagerSystem;

//I, Sarah Agarwal, pledge on my honor that I have not given on received
//any unauthorized assistance on this assignment. 

/*
 * SomeUniversity class represents a university system. It provides static methods
 * to create regular and differential courses.
 */

public class SomeUniversity {
	
    // Flag indicating if the course is a differential course
	private boolean diffCourse = false;

	//Creates a regular course with the specified department, course number, and
    // maximum number of TAs.
    public static ARegularCourse createARegularCourse(String department,
                                                  int courseNumber,
                                                  int TAMaxNum) {
    	
    	ARegularCourse regCourse = null;

    	//checks for invalid parameters
    	if ( department != null && !department.isEmpty() && courseNumber > 99 && TAMaxNum > 0 ) {
    		
    		regCourse = new ARegularCourse ( department, courseNumber, TAMaxNum );
    	}
    	
    	return regCourse;
    }

    //Creates a differential course with the specified department, course number,
    //and maximum number of TAs. Sets the differential course flag.
    public static ARegularCourse createADifferentialCourse(String department,
                                                       int courseNumber,
                                                       int TAMaxNum) {
    	
    	ARegularCourse diffCourse = null;
    	
    	//checks for invalid parameters
    	if( department != null && !department.isEmpty() && courseNumber > 99 && TAMaxNum > 0 ) {
    		
    		diffCourse = new ARegularCourse(department, courseNumber, TAMaxNum);
    		diffCourse.diffCourse();
    		
    	}
    	
    	return diffCourse;
    }

}

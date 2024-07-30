/*
 * The LarryList class represents a data structure that can grow in size 
 * when needed. It is used in the ARegularCourse class to store the TAs.
 *  It provides methods to add elements, set elements at
 * specific positions, get the current capacity amount, check if it's full,
 * determine how many more elements can be added, retrieve elements at specific
 * positions, and resize the internal array when needed.
 */

//I, Sarah Agarwal, pledge on my honor that I have not given on received
//any unauthorized assistance on this assignment. 


package taPayrollManagerSystem;

public class LarryList {

    private Object[] array; // Internal array to hold elements
    int numElement = 0; // Number of elements currently in the array

    
     //Constructs a LarryList object with the specified initial capacity. If the
     //provided capacity is less than or equal to 0, it initializes the array
     //with a default capacity of 1.
    public LarryList(int capacity) {
    	
        if (capacity <= 0) { // If capacity is invalid, set default capacity
        	
            array = new Object[1];
            
        } else {
        	
            array = new Object[capacity];
            
        }
        
    }

     //Adds a new element to the LarryList and returns true if the element was 
     //successfully added, false otherwise.
    public boolean add(Object newElement) {
    	
        boolean result = false;
        
        if (numElement != array.length) { // Check if array has space
        	
            if (newElement != null) { // Ensure element is not null
            	
                array[numElement] = newElement;
                result = true;
                numElement++;
                
            }
        }
        
        return result;
        
    }

     //Sets the element at the specified position in the LarryList and 
     //returns true if the element was successfully set, false otherwise.
    public boolean set(int pos, Object newElt) {
    	
        boolean result = false;
        
     // Ensure element is not null and position is valid
        if (newElt != null && pos < numElement) { 
        	
            array[pos] = newElt;
            result = true;
            
        }
        
        return result;
    }

    //Retrieves and returns the current capacity amount of the LarryList.
    public int getCurrCapacityAmt() {
    	
        return array.length;
        
    }

   //Checks if the LarryList is full, and returns true if it is full, 
    //false otherwise.
    public boolean isFull() {
    	
        return numElement == getCurrCapacityAmt();
        
    }

    //Calculates and returns the number of elements that can be added
    //to the LarryList
    public int numCanBeAdded() {
    	
        return getCurrCapacityAmt() - numElement;
        
    }

   //Retrieves and returns the element at the specified position
    // in the LarryList. returns null if the position is out of bounds.
    public Object get(int pos) {
    	
        if (pos < numElement) { // Ensure position is valid
        	
            return array[pos];
            
        }
        
        return null;
    }

    //Resizes the internal array of the LarryList to twice its current size.
    public void resize() {
    	
        Object[] newArr = new Object[array.length * 2]; // Create new array with double capacity
        
        for (int i = 0; i < array.length; i++) { // Copy elements to new array
        	
            newArr[i] = array[i];
            
        }
        
        array = newArr; // Assign new array to internal array
        
    }
}
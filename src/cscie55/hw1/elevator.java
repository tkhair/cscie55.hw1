package cscie55.hw1;


public class elevator
{
	final int maxFloors = 7; //constant for the number of floors in the building
 		
	private int currentFloor; //tracks current floor
        private int direction; //tracks direction of elevator travel
	private int passengers; 
	private int [] floorPeople = new int[maxFloors]; //tracks number of passengers for each floor
        private int capacity; //max capacity of the elevator
 	public void move( int direction ) 
	{
            if (direction == 1)	//going up
                {
                    if ( currentFloor + 1 > maxFloors - 1 ) //if currentFloor=7 elevator can't gp higher
                        {
                            System.out.println ("Can't go higher");
                        }
            else
                {
                    currentFloor = currentFloor + 1;
                }
        }
            if (direction == 0)	// going down	
		{
			if ( currentFloor - 1 < 0 )
			{
                            System.out.println ("Can't go to the basement");  
			}
			else
			{
                            currentFloor = currentFloor - 1; 
			}
		}	
	}
       
	public void boardPassenger( int floor )
	{
		if ( floor > maxFloors )
                    {
                        System.out.println("This floor doesn't exist. Max is 7.");	
                    }
 		else
		{
                    if ( passengers < capacity )
			{
                            floorPeople[floor - 1]++;
                            passengers++;
                            //System.out.println("Boarding one passenger for floor " + floor + "\n");
			}
                    else
			{
                            System.out.println("Maximum capacity is exeeded");
			}
		} 
	}	

	
	public String toString()
	{
		return ("Right now elevator has " +  passengers + " passengers." + "\n" + "Current floor is " + (currentFloor + 1));
	}


	public void stop( )
	{
		System.out.println("Stop is on the " + (currentFloor + 1) + " floor"); 
		passengers = passengers - floorPeople[currentFloor];
		floorPeople[currentFloor] = 0;
		System.out.println(this);
	}


	public elevator()
	{
            currentFloor = 0; 
            passengers = 0;
            capacity = 10;
        }


	public static void main(String[] args)
	{
		elevator myElevator = new elevator();
                myElevator.boardPassenger(2);
                myElevator.boardPassenger(2);
                myElevator.boardPassenger(3);
		System.out.println(myElevator);	

		
		for( int i = 1; i < myElevator.maxFloors; i++ )//up
                {
                    myElevator.move(1);
                        if( myElevator.floorPeople[i] >= 1 )
                        {
                            myElevator.stop();
                        }
		}
	
		for( int y = myElevator.maxFloors; y > 1 ; y-- )//down
		{
                    myElevator.move(0);
                    if( myElevator.floorPeople[y - 1] >= 1 )
                        {
                            myElevator.stop();
                        }
		}
	}

}

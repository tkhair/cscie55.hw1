package cscie55.hw1;


public class Elevator
{
	final int maxFloors = 7; 
	final int capacity; 		
	private int currentFloor; 
	private int passengers; 
	private int [] floorPeople = new int[maxFloors]; //number of passengers for each floor.
	

 	public void move( int direction )
	{
		if (direction == 0)	// going down	
		{
			if ( currentFloor - 1 < 0 )
			{
				System.out.println("Can't go to the basement");  
			}
			else
			{
				currentFloor = currentFloor - 1; 
			}
		}
		
 		if (direction == 1)	//going up
        {
            if ( currentFloor + 1 > maxFloors - 1 ) //if currentFloor is the seventh floor (array #6), then make sure we cannot go to the eight floor(array #7)
                {
                    System.out.println("Cannot go that high!");
                }
            else
                {
                    currentFloor = currentFloor + 1;
                }
        }
	}

	public Elevator()
	{
		currentFloor = 0; 
		passengers = 0;
        capacity = 10;

    }
	
	public String toString()
	{
		return ("Right now elevator has " +  passengers + " passengers." + "\n" + "Current floor is " + (currentFloor + 1) + "\n");
	}



	public void stop( )
	{
		System.out.println("Stop is on the " + (currentFloor + 1) + "floor"); 
		passengers = passengers - floorPeople[currentFloor];
		floorPeople[currentFloor] = 0;
		System.out.println(this);
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
					System.out.println("Boarding one passenger for floor " + floor + "\n");
				}
				else
				{
					System.out.println("Maximum capacity is exeeded");
				}
		} 
	}	


	public static void main(String[] args)
	{
		Elevator myElevator = new Elevator();
        myElevator.boardPassenger(2);
        myElevator.boardPassenger(2);
        myElevator.boardPassenger(3);
		System.out.println(myElevator);	

		//up
		for( int i = 1; i < myElevator.maxFloors; i++ )
		{
            myElevator.move(1);
            if( myElevator.floorPeople[i] >= 1 ){
                myElevator.stop();
            }
		}


		//down
		for( int y = myElevator.maxFloors; y > 1 ; y-- )
		{
            myElevator.move(0);
            if( myElevator.floorPeople[y - 1] >= 1 )
            {
                myElevator.stop();
            }
		}
	}

}

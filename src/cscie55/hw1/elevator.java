/*
CSCI E-55 HW1
Tatiana Khair
*/

package cscie55.hw1;

import java.text.MessageFormat;

public class elevator {

    final int maxFloors = 7; //constant for the number of floors in the building
    private int currentFloor; //tracks current floor
    private int[] floorPeople; //tracks number of passengers for each floor
    private int capacity; //max capacity of the elevator
    private int totalPassengers; //Currently boareded passengers in elevator for all floors
    
    public elevator() {
        //direction = ElevatorDirection.Up;
        currentFloor = 0;
        capacity = 10;
        totalPassengers = 0;
        floorPeople = new int[maxFloors];
    }

    public enum ElevatorDirection { //direction is better to be enum type

        Down,
        Up
    }
    
    public void move(ElevatorDirection direction) {
        if (direction == ElevatorDirection.Up) //going up
        {
            if (currentFloor + 1 > maxFloors - 1) //if currentFloor=7 elevator can't go higher
            {
                direction = ElevatorDirection.Down;
                //System.out.println("Can't go higher");
            } else {
                currentFloor ++;
            }
        } 
        if (direction == ElevatorDirection.Down)
        {
            if (currentFloor - 1 < 0) {
                direction = ElevatorDirection.Up;
                //System.out.println("Can't go to the basement");
            } else {
                currentFloor--;
                
            }
        }
        System.out.println(MessageFormat.format("Floor {0}: {1} passengers", currentFloor, floorPeople[currentFloor]));
    }

    public void boardPassenger(int floor, int passengers) {
        if (floor > maxFloors) {
            System.out.println("This floor doesn't exist. Max is " + maxFloors);
        } else if (totalPassengers + passengers > capacity) {
            System.out.println("Elevator is overloaded. Max is " + capacity + " passengers that can use elevator");
        } else {
            totalPassengers = totalPassengers + passengers;
            floorPeople[floor - 1] = passengers;
            /*
             if (passengers < capacity) {
             floorPeople[floor - 1]++;
             passengers++;
             //System.out.println("Boarding one passenger for floor " + floor + "\n");
             } else {
             System.out.println("Maximum capacity is exeeded");
             }
             */
        }
    }

    public String toString() {
        return ("Floor " + (currentFloor + 1) + ": " + totalPassengers + " passengers" + "\n");
    }

    public void stop() {
//System.out.println("Stop is on the " + (currentFloor + 1) + " floor");
        totalPassengers = totalPassengers - floorPeople[currentFloor];
        floorPeople[currentFloor] = 0;
        System.out.println(this);
    }

    public static void main(String[] args) {
        elevator myElevator = new elevator();
        myElevator.boardPassenger(3,2);
        myElevator.boardPassenger(5,1);
        System.out.println(myElevator);
        for (int i = 1; i < myElevator.maxFloors; i++)//up
        {
            myElevator.move(ElevatorDirection.Up);
            if (myElevator.floorPeople[i] >= 1) {
                myElevator.stop();
            }
        }
        for (int y = myElevator.maxFloors; y > 1; y--)//down
        {
            myElevator.move(ElevatorDirection.Down);
            if (myElevator.floorPeople[y - 1] >= 1) {
                myElevator.stop();
            }
        }
    }
    

}

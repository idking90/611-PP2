//***********************************************************************
//*																		*
//* CIS611					Fall 2018									*
//*																		*
//*						Program Assignment PP2							*
//*																		*
//*						Dice simulation game							*
//*																		*
//*						Created 05 Oct 2018								*
//*																		*
//*						Saved in RunDice.java							*
//*																		*
//***********************************************************************

import java.util.*;
import javax.swing.*;
public class RunDice {

//class variables ************************************
	static int rollNum = 1;
	static boolean six;
	static boolean five;
	static boolean four;
   static Die[] die = new Die[5];
	
//constructor
	public RunDice() {
		//fill this in
	}
	
	
	public static void main(String[] args) {
     JOptionPane.showMessageDialog(null, "Welcome to the Ship, Captain, and Crew dice game!", 
     "Ship, Captain, and Crew", JOptionPane.INFORMATION_MESSAGE);
     initDie();
	 roll();

	 //finalScore(); //***at some point, this is how I think we show final score/whehter they won, as well as whether to restart the game
	}//end main*********************************************

//behavioral methods****************************************

	public static void initDie() {
     for (int i = 0; i < die.length; i++) {
			die[i] = new Die();
     }		
	}
   
   public static void roll() {
   
     while (rollNum <= 3) {
     System.out.println(rollNum); 
			for (int i = 0; i < die.length; i++) {
				if (die[i].getKeep() == false) {
					die[i].setNumber(die[i].genRandomNumber());
				}
			}
        
			for (int i = 0; i < die.length; i++) {
//after each roll, check if there's a 6, 5, or 4
			  if (die[i].getNumber() == 6 && six == false) {
			    die[i].setKeep(true);
				six = true;						
           }
             
		     if (die[i].getNumber() == 5 && six == true && five == false) {
			    die[i].setKeep(true);
			    five = true;			
           }
	
			  if (die[i].getNumber() == 4 && six == true && five == true && four == false) {
		       die[i].setKeep(true);
				 four = true;
           }  
			}
            
           JOptionPane.showMessageDialog(null, 
               "Dice #1: " + die[0].getNumber()  + " Result: " + die[0].getKeep() + "\n"
			    + "Dice #2: " + die[1].getNumber()  + " Result: " + die[1].getKeep() + "\n"
			    + "Dice #3: " + die[2].getNumber()  + " Result: " + die[2].getKeep() + "\n"
			    + "Dice #4: " + die[3].getNumber()  + " Result: " + die[3].getKeep() + "\n"
		       + "Dice #5: " + die[4].getNumber()  + " Result: " + die[4].getKeep(),
             "Results!", JOptionPane.INFORMATION_MESSAGE);
             
           if (six == true && five == true && four == true) {
            JOptionPane.showMessageDialog(null, "You got the Captain, Ship, and Crew (6, 5, and 4)!",
            "X Marks The Spot!", JOptionPane.INFORMATION_MESSAGE);
            
            //Queries user if they want to roll again (provided they already got 6, 5, and 4)
            if (rollNum < 3) {
              int playerChoice = JOptionPane.showConfirmDialog(null, "Do you want to roll again?", "Roll again?", JOptionPane.YES_NO_OPTION);
                if (playerChoice == JOptionPane.YES_OPTION) {
                rollNum++;
                } else {
                    break;
                  }
                
            } else {
                //Prevents an endless loop of showing results if the player got all three dice already after three rolls
                rollNum++;
              }

           } else if (rollNum < 3) {
              JOptionPane.showMessageDialog(null, "You haven't gotten the required dice yet (6, 5, and 4). Rolling again...",
              "Not Yet!", JOptionPane.INFORMATION_MESSAGE);
              rollNum++;        
             } else {
              JOptionPane.showMessageDialog(null, "You didn't get the dice you needed (6, 5, and 4).",
                "Too Bad!", JOptionPane.INFORMATION_MESSAGE);
                break;
               }
      //Test statement 
      System.out.println(rollNum);       
    }
    
  } 



	
	public static int calculateScore() {
		int theScore = 0;
		
		return theScore;
	}
	
	public static void finalScore() {
		
	}

}//end class************************************************
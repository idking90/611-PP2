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
   static String outputMessage ="";
	
//constructor
	public RunDice() {
		//TBD
	}
	
//main method************************************************	
   public static void main(String[] args) {
      JOptionPane.showMessageDialog(null, "Welcome to the Ship, Captain, and Crew dice game!", 
      "Ship, Captain, and Crew", JOptionPane.INFORMATION_MESSAGE);
      initDie();
      roll();
	   finalScore();
	} 
	//end main*********************************************

//behavioral methods****************************************

	public static void initDie() {
     for (int i = 0; i < die.length; i++) {
			die[i] = new Die();
			
			System.out.println("Initialize die" + i +"=" + die[i].getNumber()); //error checking for initial creation of dice
     }		
	}
   
	public static void roll() {
      int diceToRoll = die.length;
      
      //the first roll shows 0 for all the dice without this included here       
      rollOnlyKeepFalseDie();
		
		while (rollNum <=3) {
			System.out.println("Start Roll number " + rollNum); //error checking message

			for (int i = 0; i < die.length; i++) {
//after each roll, first check for 6
				 if (die[i].getNumber() == 6 && six == false) {
				    die[i].setKeep(true);
					 six = true;
					 diceToRoll--;
				 }          
			}
//if a 6 has already been found, now look for 5
			if(six) {
			 	for (int i=0; i<die.length; i++) {
				   if (die[i].getNumber() == 5 && five == false) {
				      die[i].setKeep(true);
						five = true;
						diceToRoll--;
			     	}
				}
			}
//last, loop through array a third time looking for 4 if 5 and 6 have been found already
			if (six && five) {
				for (int i=0; i<die.length; i++) {
					if (die[i].getNumber() == 4 && four == false) {
					   die[i].setKeep(true);
					   four = true;
						diceToRoll --;
			      }
				}
			}

//show results for each dice after each roll

			
		for (int i = 0; i < die.length; i++) {
		   outputMessage += "Dice # " + (i + 1) + ": " + die[i].getNumber() + " | Keep it? " ;
			if(die[i].getKeep()) {
			   outputMessage += "YES. NO MORE ROLLS WITH THIS DICE \n";
			}
			else {
				outputMessage += "NO \n";
			}
		}
		if (rollNum <3) {
		   outputMessage += "Next roll will have " + diceToRoll + " dice rolled.";
		}
	    JOptionPane.showMessageDialog(null, outputMessage, "Results!", JOptionPane.INFORMATION_MESSAGE);
	    outputMessage = "";

//handling whether game is over or not
      if (six && five && four) { //game is complete
         JOptionPane.showMessageDialog(null, "You got the Captain, Ship, and Crew (6, 5, and 4)!",
         "X Marks The Spot!", JOptionPane.INFORMATION_MESSAGE);
         if (rollNum < 3) { //ask player whether to continue
            int currentScore = calculateScore();   
            int playerChoice = JOptionPane.showConfirmDialog(null, "Do you want to roll again? \nCurrent score is " + currentScore +
            													". You would be rolling " + diceToRoll + " dice.",
            													"Roll again?", JOptionPane.YES_NO_OPTION);
            if (playerChoice == JOptionPane.YES_OPTION) {
               //rollNum++;
               rollOnlyKeepFalseDie();
            } else { //chose to end the game                 
              break;
              }
	     	} else { //this was the third roll, add to rollNum to break the loop
            	//rollNum++;
           }
      } else {//player didn't win the game   	
	        if (rollNum < 3) {
	    	  JOptionPane.showMessageDialog(null, "You haven't gotten the required dice yet (6, 5, and 4). Rolling again...",
	                "Not Yet!", JOptionPane.INFORMATION_MESSAGE);
	        //rollNum++;
	    	  rollOnlyKeepFalseDie();
	    	  } else {
	    		 JOptionPane.showMessageDialog(null, "You didn't get the dice you needed (6, 5, and 4).",
	                    "Bummer!", JOptionPane.INFORMATION_MESSAGE);
	    		 //will force out of the loop
	    	   }
	     }
        
	   System.out.println("Finishing roll loop " + rollNum);
	   rollNum++; //I think it's cleaner to do it this way than have rollNum++ scattered all about the different conditions where that might happen
	   }//end while(rollNum <=3)

	System.out.println("Done all rolls");
   }//end roll()
	

	public static int calculateScore() {
		int theScore = 0;
		if (six && five && four) {
			for (int i=0; i<die.length; i++) {
				if (!die[i].getKeep()) { //add the "extra" die to the score that we didn't keep
				theScore += die[i].getNumber();
				}
			}
		}	
		return theScore;
	}
	
	public static void finalScore() {
		JOptionPane.showMessageDialog(null, "The game is over! Your score is " + calculateScore(), "Final Score", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void rollOnlyKeepFalseDie() {
	   for (int i=0; i < die.length; i++) {
			if (!die[i].getKeep()) {
		      die[i].setNumber(die[i].genRandomNumber());
			}
		}
	}

}//end class************************************************
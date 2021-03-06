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
//*						Saved in Die.java							*
//*																		*
//***********************************************************************

import java.util.*;
import javax.swing.*;
public class Die {

//class variables****************************
 	private int number;
	private boolean keep;
	
//constructor********************************
	public Die() {
     this.number = 0;
	  this.keep = false;
	}
	
//get set methods**************************************
	public boolean getKeep() {
      return keep;
	}
	
	public void setKeep(boolean newKeepValue) {
      keep = newKeepValue;
	}
	
	public int getNumber() {
      return number;
	}
   
   public void setNumber(int newNumber) {
      number = newNumber;
   }
	
   //generates random number for the dice roll result
	public int genRandomNumber() {
	   Random diceRoll = new Random();
	   int diceNumber = diceRoll.nextInt(7);
	     
	     //repeats process if diceRoll equals 0 because Random.nextInt is 0-inclusive
	   while (diceNumber == 0) {
	      diceNumber = diceRoll.nextInt(7);
	   }
	   return diceNumber;
   }   
}
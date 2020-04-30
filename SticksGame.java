/* 
Name: Ryan Owings
STICK GAME
Description:Starts with 8 sticks 
            says hello, asks for user's name, Flips coin 
            cpu and player go till pile is 0
Input: User enters name, how many sticks to take out
Output: Welcome to the program, says bye using user's name, sticks left
*/
import java.util.Random;
import javax.swing.JOptionPane;
public class SticksGame
{
   public static void main(String[] args)
   {
      String name; // Users name will be stored here
      
      int pileNum =8; //Number of sticks left in the pile
      
      String sticksRemove; //Sticks to be removed this turn(String)
      
      int intSticks; //Sticks to be removed after conversion
      
      int randomStick; //Uses rand to get random num from 1-3
      
      int coinFlip; //Records result of coin flip(h = 1, t=2)
      
      int coinFlipGuess; //Records user's choice(h = 1, t=2)
      
      String coinGuess; //Records user's choice(String)
      
      int turn=1; //Who's turn is it?(player = 1, Computer = 2)
      
      int numGame =0; // number of games that were played
      
      int numWon =0; // number of games that the player won

      Random rand = new Random(); // random number object
      
      //Prints out the welcome message
      JOptionPane.showMessageDialog(null, "Welcome to the Stick Game!");
      
      //Asks user for name and stores it in name
      name = JOptionPane.showInputDialog("Enter Name:");
      
      String keepPlayingChoice;
      
      
      do
      {
         pileNum = 8;
         while(pileNum >0) //loop that ends with pile is 0
         {
            if(turn ==1)
            {
               //PLAYER=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=
               intSticks = playerTurn(pileNum);            
               pileNum = pileNum - intSticks; //Removes the desired 
                                              //  number of sticks
               turn = 2;
            
            }
            //COMPUTER_Trial 1=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=
            else
            {
                randomStick = comTurn(pileNum);
                //Displays number Computer chose to remove
                JOptionPane.showMessageDialog(null, "Computer removed "
                                              + randomStick + " Stick(s)");
                //Removes the desired number of sticks
                pileNum = pileNum - randomStick;
                turn = 1;
   
            }
            
             //Displays number of sticks left in pile
            JOptionPane.showMessageDialog(null, "Sticks left: "+pileNum);
    
         
         }
         numWon = numWon + whoWon(turn);//did player win
         numGame++;//add to existing game count
         
               
         
         keepPlayingChoice = JOptionPane.showInputDialog("Would you like"+
                              " to play again? Type NO to stop playing.");
         //keepPlayingChoice = keepPlayingChoice.toUpper();
       } while (!keepPlayingChoice.equals("NO")&&!keepPlayingChoice.equals("no"));
       
      //Prints goodbye message with user's name included
      JOptionPane.showMessageDialog(null, "You won "+numWon+"/"+numGame
                                                              +" games");
      JOptionPane.showMessageDialog(null, "See ya soon "+name+" <3");
    }
    
    
    public static int playerTurn(int pileNum)
    {
      String sticksRemove;
      int intSticks;
      do
      {
         //Asks user how many sticks to remove
         sticksRemove =JOptionPane.showInputDialog("Sticks to Remove:");
         //Convets input to int
         intSticks = Integer.parseInt(sticksRemove);
      }while(intSticks != 1 && intSticks != 2 && intSticks != 3 
                                       || (pileNum - intSticks) <0);
      return intSticks;
     }
     
     public static int comTurn(int pileNum)
     {
         Random rand = new Random(); // random number object
         int randomStick;
         if(pileNum <4)
         {
            randomStick = rand.nextInt(pileNum); //Random number 0-2
            randomStick++; //Adds one to randomStick
         }
               
         else //if there are lots of sticks left take more (2-3)
         {
            randomStick = rand.nextInt(2); //Random number 0-1
            randomStick++; //Adds one to randomStick 
            randomStick++; //Adds one to randomStick 
         }
         return randomStick;

     }
     
     public static int whoWon(int turn)
     {
         if(turn==2) // if turn is 2 then the player last went so they lose
         {
            JOptionPane.showMessageDialog(null, "You lose, Computer wins");
            return 0;
         }  
         else
         {
            JOptionPane.showMessageDialog(null, "YOU WIN!");
            return 1;
         }    
         
      }     


}

      
      
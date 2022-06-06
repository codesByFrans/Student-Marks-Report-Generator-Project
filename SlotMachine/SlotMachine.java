package SlotMachine;
import java.util.Random;
import java.util.Scanner;

public class SlotMachine 
{
    public static void main(String[] args)
    {//Main method
        
        //Declaring variables
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        String user;
        String user2="";
        int wallet;
        wallet=100;
        int credits;
        
        do 
        {
            //Generation of random numbers
            int jackpot1 = random.nextInt(10);
            int jackpot2 = random.nextInt(10);
            int jackpot3 = random.nextInt(10);
            
            System.out.println("""
                           ==================================
                           WELCOME TO 'YOU WILL ALWAYS LOSE'
                           ==================================
                           WIN BIG OR GO HOME WITH NOTHING..
                           ==================================
                           GET 3 OF THE SME NUMBERS TO WIN DOUBLE WHAT YOU PLAYED
                           ==================================""");
            System.out.println("YOU CURRENTLY HAVE " + wallet + ", HOW MUCH WOULD YOU LIKE TO PLAY?");
            credits = keyboard.nextInt();
            
           //Conditions for game continuation
            if (credits>100) 
            {
                System.out.println("""
                                   TOU SEEM TO BE TOO BROKE TO DO THAT, GOOD BYE
                                   YOU HAVE CASHED OUT 100 CREDITS
                                   COME LOSE AGAIN SOON!!!!!!HAHAHAHAHAH
                                   """);
                break;
            }else 
            {
                System.out.println("""
                                   YOURS NUMBERS ARE.........
                                   ========================== """);
                System.out.println(jackpot1 + "  "+ jackpot2 + "  "+ jackpot3);
                
                if (jackpot1 == jackpot2 && jackpot2 == jackpot3 && jackpot1 == jackpot3) 
                {
                    int win;
                    win = credits * 2;
                    
                    System.out.println("YOU HAVE WON " + win + "CREDITS!!!!");
                    System.out.println("=================================");
                    wallet+=win;
                    
                    System.out.println("""
                                       WOULD YOU LIKE TO PLAY AGAIN? Y/N:
                                       ==================================
                                       """);
                    user = keyboard.next().toUpperCase();
                    if (user.equals("Y")) 
                    {
                        System.out.println("""
                           ==================================
                           WELCOME TO 'YOU WILL ALWAYS LOSE'
                           ==================================
                           WIN BIG OR GO HOME WITH NOTHING..
                           ==================================
                           GET 3 OF THE SME NUMBERS TO WIN DOUBLE WHAT YOU PLAYED
                           ==================================""");
                        System.out.println("YOU CURRENTLY HAVE " + wallet + ", HOW MUCH WOULD YOU LIKE TO PLAY?");
                        
                        credits = keyboard.nextInt();
                    }
                    
                }else
                {
                    wallet = wallet-credits;
                  
                    if(wallet <= 0){
                        System.out.println("YOU HAVE CASHED OUT " + wallet + " CREDITS");
                        System.out.println("COME LOSE AGAIN SOON!!!!!HAHAHAHAHA");
                        break;
                    }
                    
                    System.out.println("""
                                           YOU LOST THAT ONE!!!!!!HAHAHAHAHA
                                           =================================
                                           WOULD YOU LIKE TO PLAY AGAIN????Y/N
                                           =================================
                                           """);
                    user2 = keyboard.next().toUpperCase();
                    if (user2.equals("Y")) 
                    {
                        continue;
                        
                        
                    }else if(user2.equals("N"))
                    {
                        System.out.println("YOU HAVE CASHED OUT " + wallet + " CREDITS");
                        System.out.println("COME LOSE AGAIN SOON!!!!!HAHAHAHAHA");
                        break;
                    }
               
                }
            }
            
        } while (wallet>0 && credits!=0 && user2.equals("Y"));
     
    }//End of Main method
    
}

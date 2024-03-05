package codSoft_Int;
import java.util.Random;
import java.util.Scanner;

class Game
{
    public int number;
    public int inputnumber;
    public int noOfGuesses=0;


    public int getNoOfGuesses()
    {
        return noOfGuesses;
    }


    public void setNoOfGuesses(int noOfGuesses)
    {
        this.noOfGuesses = noOfGuesses;
    }


    Game()
    {
        Random rand=new Random();
        this.number=rand.nextInt(100);
    }
    void takeUserInput()
    {
        System.out.println("Enter the number for Checking ");
        Scanner a=new Scanner(System.in);
        inputnumber=a.nextInt();

    }

   boolean isCorrectNumber()
   {
    noOfGuesses++;
    if(inputnumber==number)
    {
        System.out.format("your number, Number is %d\n Congratulation! you guess the right number at %d attemps\n",number,noOfGuesses);
        return true;
    }
    else if(inputnumber<number)
    {
        System.out.println("Your Number is lower ");
    }
    else if(inputnumber>number)
    {
        System.out.println("Your Number is high");
    }
        return false;
   }

}
public class Check_Num
{
    public static void main(String[] args)
    {
        Game g=new Game();
        boolean b=false;
        while(!b) {
            g.takeUserInput();
            b=g.isCorrectNumber();
            System.out.println(b);
        }
    }
}
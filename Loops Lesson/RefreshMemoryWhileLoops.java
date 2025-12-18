import java.util.Scanner;

public class RefreshMemoryWhileLoops {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int num = -1; 
      int sum = 0;
      while (num != 0) { 
          System.out.print("Enter a number: ");
          num = sc.nextInt();

          if(num != 0){
            sum += num;
          }

          System.out.println("You entered: " + num);
      }
      System.out.println("The sum of the numbers entered is: " + sum);
      System.out.println("You have exited the loop. Goodbye!!");
  }
}

import java.util.Scanner;

public class RefreshMemoryDoWhileLoops {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int num = 0;
    do { 
        System.out.print("Guess the number: ");
        num = sc.nextInt();

        if(num != 8){
          System.out.printf("%d is not the right number. Try Again!\n", num);
        }
        
    } while (num != 8);

    System.out.printf("Hurray you guessed the right number which is %d", num);
  }
}

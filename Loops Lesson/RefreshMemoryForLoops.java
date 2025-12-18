import java.util.Scanner;

public class RefreshMemoryForLoops {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);


    System.out.print("Enter a number: ");
    int n = sc.nextInt();

    int i = 1;
    for (;i > 0;) {

      System.out.println(n + " x " + i + " = " + (n * i));

      if (i == 10) {
          break;
      }
        i++;
    }
  }
}

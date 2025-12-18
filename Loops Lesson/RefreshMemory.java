import java.util.Scanner;

public class RefreshMemory {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter first number: ");
    int num1 = sc.nextInt();

    System.out.print("Enter second number: ");
    int num2 = sc.nextInt();

    System.out.print("Enter third number: ");
    int num3 = sc.nextInt();


    int largest = (num1 >= num2 && num1 >= num3) ? num1 : (num2 >= num1 && num2 >= num3)? num2 : num3;

    System.out.println("The largest number is: " + largest);

    int smallest = (num1 <= num2 && num1 <= num3) ? num1 : (num2 <= num1 && num2 <= num3)? num2 : num3;

    System.out.println("The smallest number is: " + smallest);

    double average = (double)(num1 + num2 + num3) / 3;
    System.out.printf("The average of the three numbers is: %.2f", average);
  }
}

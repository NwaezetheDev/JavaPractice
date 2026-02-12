import java.util.Scanner;

class Calculator{
  
  int result; // this is the property of the calc object (the data the object stores)

  public int add(int a, int b) //these are the parameters (the data given to the method)
  {
    result = a + b; //this is the behaviour of the calc object (what the object can do)
    return result;
  }

  public int sub(int a, int b)
  {
    result = a - b;

    return result;
  }
}

public class oopLesson {
  public static void main (String [] args){
    Calculator calc = new Calculator();

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter first number: ");
    int num1 = sc.nextInt();

    System.out.print("Enter second number: ");
    int num2 = sc.nextInt();

   System.out.printf("The sum of the numbers is: %d%n", calc.add(num1, num2));
   System.out.printf("The difference between the numbers is: %d", calc.sub(num1, num2));
  }
}

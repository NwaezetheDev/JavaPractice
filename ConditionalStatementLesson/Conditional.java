import java.util.Scanner;

public class Conditional {
  public static void main(String[]args){

  Scanner sc = new Scanner(System.in);
  
  System.out.print("Enter Unit(C/F): ");
  char unit = sc.next().toUpperCase().charAt(0);
  
  System.out.print("Enter Temperature: ");
  int temp = sc.nextInt();

  System.out.println("Original temp: " + temp + "°"+ unit);

  double fahrenheit;
  double celcius;

  
    if (unit== 'C'){
      if(temp > 100){
      fahrenheit = (temp * 1.8) + 32;
      System.out.println("The answer in Fahrenheit is: " + fahrenheit + "°F");
    } else {
      System.out.printf("The answer in Celcius is: %2f°C", (double)temp);
    }
  } else if (unit== 'F'){
      if(temp < 32){
      celcius = (temp - 32) * ((double)5/9);
      System.out.println("The answer in Celcius is: " + celcius + "°C");
    } else {
      System.out.printf("The answer in Fahrenheit is: %2f°F", (double)temp);
    }
  }else {
      System.out.println("Invalid unit entered! Please enter C or F.");
  }
}

}

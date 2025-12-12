
public class StringConversion {
  public static void main(String[]args){
    byte age1 = 10;
    byte age2 = 15;
    byte age3 = 20;

    byte result = (byte)(age1 + age2 + age3);
    int newResult = result;
    System.out.println("Addition result: " + newResult);

    int subtraction = age2 - age1;
    System.out.println("Subtraction is: " + subtraction);

    System.out.println("Is the original total greater than 100?" + (result > 100));

    System.out.println("Are all age values greater than 18? " + (age1 > 18 && age2 > 18 && age3 > 18));
  }
  
}

public class hello{
  public static void main(String [] args){
    //This is Q1 answers
    String name = "Michael";
    int age = 20;
    float height = 185f;
    boolean student = true;


    //This is Q2 answers
      int a = 10;
      int b = 20;
      int temp;

      temp = a;
      a = b;
      b = temp;

    //This Q3 answers
      char m = 'M';

    //This is Q4 answer
    int length = 10;
    int width = 8;
    double area = length * width;
    double perimeter = (2 * length) + (2 * width);

    //This Q5 answer
    byte num = 1;
    short x = 20;
    int y = 200;
    long z = 50_00_00l;
    float f = 3.4f;
    double d = 40.5;
    char c = 'c';
    boolean g = true;

    //This Q6 Answers
    double price1 = 20;
    double price2 = 35;
    int quantity = 50;
    double result = (price1 + price2) * quantity;


    // This is Q1 printed result
    System.out.println("Hello my name is " + name + " and i am " + age + " years old. I am " + height + "cm. Am i a student? " + student );

    // This is Q2 printed result
    System.out.println("New values: a = " + a + ", b = " + b );

      // This is Q3 printed result
    System.out.println("The first letter of my name is: " + m );

    // This is Q4 printed result
    System.out.println("The area is: " + area + ". The perimeter is: " + perimeter);

    // This is Q5 printed result
    System.out.println(num + " is a byte \n"
                      + x + " is a short \n"
                      + y + " is an integer \n"
                      + z + " is a long \n"
                      + f + " is a float \n"
                      + d + " is a double \n"
                      + c + " is a char \n"
                      + g + " is a boolean \n"
    );

    // This is Q6 printed result
    System.out.println("Total Price is: " + result );

        //This is Q7 answers
    int o = 2;
    int p = 3;
    int q = 4;

    if (o>= p && o >= q) {
        System.out.println(o + " is the largest number");
    } else if (p >= o && p >= q){
      System.out.println(p + " is the largest number");
    } else {
      System.out.println(q + " is the largest number");
    }
  }
} 

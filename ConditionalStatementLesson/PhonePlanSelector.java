import java.util.Scanner;

public class PhonePlanSelector {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    System.out.print("Please enter your data usage(in GB): ");
    float usage = sc.nextFloat();

    boolean valid;

    if (usage > 0 && usage <= 5) {
        System.out.println("The plan you should go for is plan A($30/month for up to 5GB)");
    } else if (usage >5 && usage <= 15) {
        System.out.println("The plan you should go for is plan B($45/month for up to 15GB)");
    } else if (usage > 15) {
        System.out.println("The plan you should go for is plan C($70/month for unlimited)");
    } else {
      System.out.println("Enter a valid data usage in positive whole numbers");
      valid = true;
    }
  }
}

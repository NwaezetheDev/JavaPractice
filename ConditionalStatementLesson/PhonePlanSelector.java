import java.util.Scanner;

public class PhonePlanSelector {
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);

    System.out.print("Please enter your data usage(in GB): ");
    float usage = sc.nextFloat();

    float decimalPart = usage - (int)usage;

    // Start with original usage, update it when rounding occurs
    float roundedUsage = usage;

    // Rule 1: round down if decimal < 0.25 (explicit cast)
    if (decimalPart < 0.25) {
        roundedUsage = (int)usage;
        System.out.println("Rounded down (explicit cast): " + roundedUsage + " GB");
    }

    // Rule 2: round up if decimal > 0.75 (ternary operator)
    roundedUsage = (decimalPart > 0.75)
        ? ((int)usage + 1)           // round UP
        : roundedUsage;              // keep whatever it was

    if (decimalPart > 0.75) {
        System.out.println("Rounded up (ternary): " + roundedUsage + " GB");
    }

    // Print final rounded usage
    System.out.println("Final rounded usage: " + roundedUsage + " GB");

    // Rule 3: If rounded usage is exactly 10 → force more expensive plan
    if (roundedUsage == 10) {
        System.out.println("Special rule applied → Choose PLAN B ($45/month)");
        return;
    }

    // Plan selection using rounded usage
    if (roundedUsage > 0 && roundedUsage <= 5) {
        System.out.println("The plan you should go for is Plan A ($30/month)");
    } 
    else if (roundedUsage > 5 && roundedUsage <= 15) {
        System.out.println("The plan you should go for is Plan B ($45/month)");
    } 
    else if (roundedUsage > 15) {
        System.out.println("The plan you should go for is Plan C ($70/month)");
    } 
    else {
        System.out.println("Enter a valid positive usage number.");
    }
  }
}

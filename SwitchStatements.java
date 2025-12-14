import java.util.Scanner;

public class SwitchStatements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bill amount ($): ");
        double bill = sc.nextDouble();

        System.out.print(
            "Do you want to tip the restaurant? Type YES to continue or NO to skip: "
        );
        String answer = sc.next();

        if(answer.equalsIgnoreCase("YES")) {
            System.out.print(
                "Enter service rating (1-5 stars, each with a dedicated tip):\n" +
                "1 Star = 5%, 2 Star = 10%, 3 Star = 15%, 4 Star = 18%, 5 Star = 20%\n" +
                "Your rating: "
            );
            int rate = sc.nextInt();

            double tipPercentage;
            switch(rate) {
                case 1: tipPercentage = 0.05; break;
                case 2: tipPercentage = 0.10; break;
                case 3: tipPercentage = 0.15; break;
                case 4: tipPercentage = 0.18; break;
                case 5: tipPercentage = 0.20; break;
                default:
                    System.out.print("Enter custom tip percentage (as decimal, e.g., 0.12): ");
                    tipPercentage = sc.nextDouble();
            }

            // Calculate tip and new bill
            double tipAmount = bill * tipPercentage;

            // Round tip amount down or up depending on decimal part (<0.5 down, >=0.5 up)
            tipAmount = (tipAmount - (int)tipAmount < 0.5) 
                        ? (int)tipAmount 
                        : (int)tipAmount + 1;

            double newBill = bill + tipAmount;

            System.out.printf(
                "Tip amount: $%.2f\nNew bill total: $%.2f\n",
                tipAmount, newBill
            );

            // Ternary for high spender
            String highSpenderMsg = (newBill > 100) 
                ? "High spender!" 
                : "Thank you for patronizing this restaurant, you may now proceed to payment.";
            System.out.println(highSpenderMsg);

        } else {
            System.out.println("No tip selected. Thank you for patronizing this restaurant.");
        }
    }
}

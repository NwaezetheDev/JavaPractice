import java.util.Scanner;

public class SmartUtilityBillingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter monthly electricity usage (kWh): ");
        double usage = sc.nextDouble();

        System.out.println("Original usage: " + usage + " kWh");

        // ----- Rounding Rules -----
        double decimal = usage - (int) usage;

        if (decimal < 0.30) {
            usage = (int) usage; // explicit cast (round down)
        }

        usage = (decimal >= 0.70) ? (int) usage + 1 : usage; // ternary round up

        System.out.println("Rounded usage: " + usage + " kWh");

        // ----- Customer Type -----
        System.out.print("Enter customer type (R / C / I): ");
        char type = sc.next().toUpperCase().charAt(0);

        double rate;

        switch (type) {
            case 'R':
                rate = 0.12;
                break;
            case 'C':
                rate = 0.15;
                break;
            case 'I':
                rate = 0.18;
                break;
            default:
                System.out.println("Invalid customer type.");
                return;
        }

        // ----- Base Bill -----
        double baseBill = usage * rate;
        double finalBill = baseBill;

        // ----- Adjustments -----
        if (usage > 500 && type == 'R') {
            finalBill -= finalBill * 0.05; // 5% discount
        } else if (usage > 1000 || type == 'I') {
            finalBill += finalBill * 0.08; // 8% surcharge
        }

        // ----- Output -----
        System.out.printf("Base bill: $%.2f%n", baseBill);
        System.out.printf("Final bill: $%.2f%n", finalBill);

        String alert = (finalBill > 250)
                ? "High Usage Alert!"
                : "Thank you for using our service.";

        System.out.println(alert);
    }
}

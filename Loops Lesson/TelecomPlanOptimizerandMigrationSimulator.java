import java.util.Scanner;

public class TelecomPlanOptimizerandMigrationSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Customers: ");
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("INVALID INPUT");
            return;
        }

        int validCount = 0, invalidCount = 0, migrationCount = 0;
        double totalRevenue = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customerId: ");
            String customerId = sc.next();
            System.out.print("Enter plan code (A/B/C): ");
            char planCode = sc.next().toUpperCase().charAt(0);
            System.out.print("Enter usage (GB): ");
            double usageGB = sc.nextDouble();

            boolean invalid = false;
            if (usageGB < 0 || !(planCode == 'A' || planCode == 'B' || planCode == 'C')) {
                invalid = true;
            }

            if (invalid) {
                System.out.println("Customer: " + customerId);
                System.out.println("Invalid record");
                System.out.println("----");
                invalidCount++;
                continue;
            }

            // ----- Rounding Rules -----
            double roundedUsage;
            double decimal = usageGB - (int) usageGB;
            roundedUsage = (decimal < 0.25) ? (int) usageGB : usageGB;
            roundedUsage = (decimal > 0.75) ? (int) usageGB + 1 : roundedUsage;

            // ----- Base plan rates -----
            double baseA = 30, baseB = 45, baseC = 70;
            double overA = 8, overB = 4, overC = 0;

            double[] planBase = {baseA, baseB, baseC};
            double[] planOver = {overA, overB, overC};
            char[] planCodeArr = {'A', 'B', 'C'};

            // ----- Migration simulator -----
            char originalPlan = planCode;
            char recommendedPlan = planCode;
            double finalCharge = 0;

            boolean stable;
            do {
                stable = true;
                double bestCharge = Double.MAX_VALUE;
                char bestPlan = recommendedPlan;

                for (int p = 0; p < 3; p++) {
                    char candidate = planCodeArr[p];
                    double base = planBase[p];
                    double over = planOver[p];
                    double overage = 0;

                    if (candidate == 'C') overage = 0;
                    else if (roundedUsage > ((candidate == 'A') ? 5 : 15)) {
                        double extra = roundedUsage - ((candidate == 'A') ? 5 : 15);
                        overage = (extra == (int) extra) ? (int) extra * over : extra * over;
                    }

                    double total = base + overage;
                    if (total < bestCharge || (total == bestCharge && base < planBase[bestPlan == 'A' ? 0 : bestPlan == 'B' ? 1 : 2])) {
                        bestCharge = total;
                        bestPlan = candidate;
                    }
                }

                if (bestPlan != recommendedPlan) {
                    recommendedPlan = bestPlan;
                    stable = false;
                }
                finalCharge = (recommendedPlan == 'A') ? baseA : (recommendedPlan == 'B') ? baseB : baseC;
                double extraUsage = (recommendedPlan == 'A') ? 5 : (recommendedPlan == 'B') ? 15 : roundedUsage;
                if (roundedUsage > extraUsage) {
                    double overageRate = (recommendedPlan == 'A') ? overA : (recommendedPlan == 'B') ? overB : 0;
                    double extra = roundedUsage - extraUsage;
                    double overage = (extra == (int) extra) ? (int) extra * overageRate : extra * overageRate;
                    finalCharge += overage;
                }

            } while (!stable);

            if (recommendedPlan != originalPlan) migrationCount++;

            validCount++;
            totalRevenue += finalCharge;

            System.out.printf("Customer: %s%n", customerId);
            System.out.printf("Original Plan: %c%n", originalPlan);
            System.out.printf("Original Usage: %.2f GB%n", usageGB);
            System.out.printf("Rounded Usage: %.2f GB%n", roundedUsage);
            System.out.printf("Recommended plan: %c%n", recommendedPlan);
            double base = (recommendedPlan == 'A') ? baseA : (recommendedPlan == 'B') ? baseB : baseC;
            double overage = (recommendedPlan == 'A') ? ((roundedUsage > 5) ? ((roundedUsage == (int) roundedUsage ? (int)(roundedUsage - 5) * overA : (roundedUsage - 5) * overA)) : 0)
                    : (recommendedPlan == 'B') ? ((roundedUsage > 15) ? ((roundedUsage == (int) roundedUsage ? (int)(roundedUsage - 15) * overB : (roundedUsage - 15) * overB)) : 0)
                    : 0;
            System.out.printf("Base charge: $%.2f%n", base);
            System.out.printf("Overage charge: $%.2f%n", overage);
            System.out.printf("Final charge: $%.2f%n", finalCharge);
            System.out.println("----");
        }

        System.out.printf("TOTAL CUSTOMERS: %d%n", n);
        System.out.printf("VALID CUSTOMERS: %d%n", validCount);
        System.out.printf("INVALID RECORDS: %d%n", invalidCount);
        System.out.printf("TOTAL REVENUE: $%.2f%n", totalRevenue);
        System.out.printf("MIGRATIONS SUGGESTED: %d%n", migrationCount);
    }
}

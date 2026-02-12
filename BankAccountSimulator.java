import java.util.Scanner;

class BankInfo {
    private String accountHolderName;
    private String password;

    public BankInfo(String accountHolderName, String password) {
        this.accountHolderName = accountHolderName;
        this.password = password;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getPassword() {
        return password;
    }
}

class BankAmount {
    private double balance = 0.0;

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0");
            return balance;
        }
        balance += amount;
        return balance;
    }

    // uses a for loop (practice)
    public double deposit(double amount, int times) {
        if (amount <= 0 || times <= 0) {
            System.out.println("Amount and times must be greater than 0");
            return balance;
        }

        for (int i = 1; i <= times; i++) {
            balance += amount;
        }
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Amount must be greater than 0");
            return balance;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return balance;
        }
        balance -= amount;
        return balance;
    }
}

public class BankAccountSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Create an account");

        System.out.print("Enter your name: ");
        String createdName = sc.nextLine();

        System.out.print("Create a password: ");
        String createdPassword = sc.nextLine();

        BankInfo bk = new BankInfo(createdName, createdPassword);
        BankAmount ba = new BankAmount();

        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("\nLogin");

            System.out.print("Enter your name: ");
            String name = sc.nextLine();

            System.out.print("Enter your password: ");
            String pass = sc.nextLine();

            if (bk.getAccountHolderName().equals(name) && bk.getPassword().equals(pass)) {
                System.out.println("Welcome " + name);
                loggedIn = true;

                boolean running = true;
                do {
                    System.out.println("\n1. Deposit Once");
                    System.out.println("2. Deposit multiple times");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Check Balance");
                    System.out.println("5. Exit");

                    int option = 0;

                    // option validation (while loop)
                    while (true) {
                        System.out.print("Choose an option (1-5): ");
                        if (sc.hasNextInt()) {
                            option = sc.nextInt();
                            sc.nextLine(); // clear newline
                            if (option >= 1 && option <= 5) break;
                        } else {
                            sc.nextLine(); // clear bad input
                        }
                        System.out.println("Invalid option, try again.");
                    }

                    switch (option) {
                        case 1: {
                            double enteredAmount = readPositiveDouble(sc, "Enter amount: ");
                            System.out.println("New balance is: " + ba.deposit(enteredAmount));
                            break;
                        }
                        case 2: {
                            double multipleAmount = readPositiveDouble(sc, "Enter amount: ");
                            int times = readPositiveInt(sc, "Enter number of times: ");
                            System.out.println("New balance is: " + ba.deposit(multipleAmount, times));
                            break;
                        }
                        case 3: {
                            double withdrawAmount = readPositiveDouble(sc, "Enter amount to withdraw: ");
                            System.out.println("New balance is: " + ba.withdraw(withdrawAmount));
                            break;
                        }
                        case 4:
                            System.out.println("Current balance: " + ba.getBalance());
                            break;

                        case 5:
                            System.out.println("Goodbye!");
                            running = false;
                            break;
                    }

                } while (running);

            } else {
                System.out.println("You entered the wrong info. Try again.");
            }
        }

        sc.close();
    }

    // while loop input validation helpers
    private static double readPositiveDouble(Scanner sc, String prompt) {
        double value = 0;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine(); // clear newline
                if (value > 0) return value;  
            } else {
                sc.nextLine(); // clear bad input
            }
            System.out.println("Value must be greater than 0. Try again.");
        }
    }

    private static int readPositiveInt(Scanner sc, String prompt) {
        int value = 0;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine(); // clear newline
                if (value > 0) 
                  return value;
            } else {
                sc.nextLine(); // clear bad input
            }
            System.out.println("Value must be greater than 0. Try again.");
        }
    }
}

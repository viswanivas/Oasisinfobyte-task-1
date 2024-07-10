import java.util.Scanner;

class ATM3 {
    private static int balance = 0;
    private static final int pin = 1234;
    private static boolean pinGenerated = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
			System.out.println("Welcome to SBI ATM");
            System.out.print("Enter your pin: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin != pin) {
                System.out.println("Wrong Pin");
            } else {
                homePage(scanner);
            }
        }
    }
    private static void homePage(Scanner scanner) {
        while (true) {
            System.out.println("ATM Home Page");
            System.out.println("1. Generate Pin");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Select an Option: ");
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    generatePin(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void generatePin(Scanner scanner) {
        if (pinGenerated) {
            System.out.println("Pin is already generated.");
        } else {
            System.out.print("Enter new pin: ");
            int newPin = scanner.nextInt();
            if (newPin != pin) {
                System.out.println("Pin generation successful.");
                pinGenerated = true;
            } else {
                System.out.println("New pin should be different from default pin.");
            }
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Select account type (1. Savings, 2. Current): ");
        int accountType = scanner.nextInt();

        if (accountType != 1 && accountType == 2) {
            System.out.println("Invalid account type.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter number of 500s: ");
        int notes500 = scanner.nextInt();
        System.out.print("Enter number of 200s: ");
        int notes200 = scanner.nextInt();
        System.out.print("Enter number of 100s: ");
        int notes100 = scanner.nextInt();

        int amount = (notes500 * 500) + (notes200 * 200) + (notes100 * 100);
        balance += amount;

        System.out.println("Amount deposited successfully.");
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }
}


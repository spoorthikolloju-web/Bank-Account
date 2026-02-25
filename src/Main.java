import java.util.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


                Scanner sc = new Scanner(System.in);

                System.out.print("Enter your Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Account Number: ");
                String accNo = sc.nextLine();

                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();

                System.out.println("\nSelect Account Type:");
                System.out.println("1. Savings");
                System.out.println("2. Current");
                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                if (choice == 1) {

                    savings account = new savings(name, accNo, balance);

                    System.out.println("\n1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Fixed Deposit");
                    System.out.print("Choose operation: ");
                    int op = sc.nextInt();

                    if (op == 1) {
                        System.out.print("Enter amount to withdraw: ");
                        double amt = sc.nextDouble();
                        account.transaction(amt);
                    } else if (op == 2) {
                        System.out.print("Enter amount to deposit: ");
                        double amt = sc.nextDouble();
                        account.deposit(amt);
                    } else if (op == 3) {
                        System.out.print("Enter FD amount: ");
                        double amt = sc.nextDouble();
                        System.out.print("Enter tenure (years): ");
                        int years = sc.nextInt();
                        account.FD(amt, years);
                    }

                    account.display();
                } else if (choice == 2) {

                    current account = new current(name, accNo, balance);

                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);

                    account.display();
                } else {
                    System.out.println("Invalid choice.");
                }

                sc.close();}
            }

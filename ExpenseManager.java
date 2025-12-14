import java.util.ArrayList;
import java.util.Scanner;


public class ExpenseManager {
    public static void main(String[] args) {

        ArrayList<Expense> expenses = new ArrayList<Expense>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi there! Insert your last expense.");
        boolean insertExpense = true;

        do {
        System.out.println("Enter expense description: ");
        String description = scanner.nextLine();

        System.out.println("Enter expense amount: ");
        double amount = scanner.nextDouble();  
        scanner.nextLine();
        System.out.println("Enter expense category: ");
        String category = scanner.nextLine();

        expenses.add(new Expense(description, amount, category));

        System.out.println("Ok, good! Wanna insert another one?");
        String choice = scanner.nextLine();
        
        if (choice.equals("no")) {
            insertExpense = false;
        }
       } while (insertExpense);

       System.out.println("=== ALL YOUR EXPENSES ===");
       for (Expense e : expenses) {
        System.out.println(e.description + " - " + e.amount + "€ " + e.category );
       }

        scanner.close();
    }
}

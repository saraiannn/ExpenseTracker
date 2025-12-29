import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {
    public static void main(String[] args) {

        ArrayList<Expenses> expenses = new ArrayList<Expenses>();
        ArrayList<Incomes> incomes = new ArrayList<Incomes>();

        Scanner scanner = new Scanner(System.in);
        String selectedOption;

        do {
            System.out.println("Please select an option:");
            System.out.println("- Add expense/income");
            System.out.println("- Check expenses/incomes");
            System.out.println("- Balance");
            System.out.println("- Filter by category");
            System.out.println("- Highest expense/income");
            System.out.println("- Lowest expense/income");
            System.out.println("- Quit");
            selectedOption = scanner.nextLine();

            if (selectedOption.equalsIgnoreCase("add")) {
                System.out.println("Expense or income?"); 
                String exp_inc = scanner.nextLine();
                if (exp_inc.equalsIgnoreCase("expense")){
                    System.out.println("Enter expense description: ");
                    String expenseDescription = scanner.nextLine();
                    System.out.println("Enter expense amount: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter expense category: ");
                    String expenseCategory = scanner.nextLine();
                    expenses.add(new Expenses(expenseDescription, expenseAmount, expenseCategory));
                } else if (exp_inc.equalsIgnoreCase("income")) {
                    System.out.println("Enter income source: ");
                    String incomeSource = scanner.nextLine();
                    System.out.println("Enter income amount: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter income description: ");
                    String incomeDescription = scanner.nextLine();
                    incomes.add(new Incomes(incomeSource, incomeAmount, incomeDescription));
                }

            } else if (selectedOption.equalsIgnoreCase("check")) {
                System.out.println("Expense or income?");
                String exp_inc = scanner.nextLine();
                if (exp_inc.equalsIgnoreCase("expense")){
                    for (Expenses e : expenses) {
                        System.out.println(e.expenseDescription + " " + e.expenseAmount + "€ " + e.expenseCategory);
                    }
                } else if (exp_inc.equalsIgnoreCase("income")) {
                    for (Incomes i : incomes) {
                        System.out.println(i.incomeSource + " " + i.incomeAmount + "€ " + i.incomeDescription);
                    }
                }    

            } else if (selectedOption.equalsIgnoreCase("balance")) {
                double depositSum = 0;
                    for (Incomes i : incomes) {
                        depositSum += i.incomeAmount;
                    }
                double withdrawalSum = 0;
                    for (Expenses e : expenses) {
                        withdrawalSum += e.expenseAmount;
                    }
                double balance = depositSum - withdrawalSum;
                System.out.println("Balance is: " + balance);
            } else if (selectedOption.equalsIgnoreCase("filter")) {
                /*System.out.println("Choose a category:");
                String category = scanner.nextLine();*/

            } else if (selectedOption.equalsIgnoreCase("highest")) {
                System.out.println("Expense or income?"); 
                String exp_inc = scanner.nextLine();
                if (exp_inc.equalsIgnoreCase("expense")){
                    double maxExpense = 0;
                    for (Expenses e : expenses) {
                        if (e.expenseAmount > maxExpense) {
                            maxExpense = e.expenseAmount;
                        }
                    }
                    System.out.println("Highest expense is: " + maxExpense);
                } else if (exp_inc.equalsIgnoreCase("income")) {
                    double maxIncome = 0;
                    for (Incomes i : incomes) {
                        if (i.incomeAmount > maxIncome) {
                            maxIncome = i.incomeAmount;
                        }
                    }
                    System.out.println("Highest income is: " + maxIncome);
                }
            } else if (selectedOption.equalsIgnoreCase("lowest")) {
                System.out.println("Expense or income?"); 
                String exp_inc = scanner.nextLine();
                if (exp_inc.equalsIgnoreCase("expense")){
                    double minExpense = expenses.get(0).expenseAmount;
                    for (Expenses e : expenses) {
                        if (e.expenseAmount < minExpense) {
                            minExpense = e.expenseAmount;
                        }
                    }
                    System.out.println("Lowest expense is: " + minExpense);
                } else if (exp_inc.equalsIgnoreCase("income")) {
                    double minIncome = incomes.get(0).incomeAmount;
                    for (Incomes i : incomes) {
                        if (i.incomeAmount < minIncome) {
                            minIncome = i.incomeAmount;
                        }
                    }
                    System.out.println("Lowest income is: " + minIncome);
                }
            }

        } while (!selectedOption.equalsIgnoreCase("quit"));

    scanner.close();

    }
    
}

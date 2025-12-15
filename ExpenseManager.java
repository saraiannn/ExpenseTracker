import java.util.ArrayList;
import java.util.Scanner;


public class ExpenseManager {
    public static void main(String[] args) {

        ArrayList<Expenses> expenses = new ArrayList<Expenses>();
        ArrayList<Incomes> incomes = new ArrayList<Incomes>();

        System.out.println("Hi there!\nDo you wanna add a recent expense or income?");

        Scanner scanner = new Scanner(System.in);

        String addExpenseOrIncome = scanner.nextLine();

            if (addExpenseOrIncome.equals("expense")) {

                boolean insertExpense = true;

                    do {
                        System.out.println("Enter expense description: ");
                        String description = scanner.nextLine();

                        System.out.println("Enter expense amount: ");
                        double amount = scanner.nextDouble();  
                        scanner.nextLine();

                        System.out.println("Enter expense category: ");
                        String category = scanner.nextLine();

                        expenses.add(new Expenses(description, amount, category));

                        System.out.println("Ok, good! Wanna insert another one?");
                        String choiceExpense = scanner.nextLine();
                        
                        if (choiceExpense.equals("no")) {
                            insertExpense = false;
                        }
                    } while (insertExpense);
            } else if(addExpenseOrIncome.equals("income")){

                boolean insertIncome = true;

                    do {
                        System.out.println("Enter income source: ");
                        String incomeSource = scanner.nextLine();

                        System.out.println("Enter income amount: ");
                        double incomeAmount = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.println("Enter income description: ");
                        String incomeDescription = scanner.nextLine();
                        
                        incomes.add(new Incomes(incomeSource, incomeAmount, incomeDescription));

                        System.out.println("Ok, good! Wanna insert another one?");
                        String choiceIncome = scanner.nextLine();

                        if (choiceIncome.equals("no")) {
                            insertIncome = false;
                        }
                    } while(insertIncome);
            }   
        System.out.println("Do you wanna check them?");
        String yOn = scanner.nextLine();
        
        if(yOn.equals("yes")) {
            System.out.println("Expense or income?");
            String seeExpenseOrIncome = scanner.nextLine();

            if(seeExpenseOrIncome.equals("expense")) {
                System.out.println("|*** ALL YOUR EXPENSES ***|");
                    for (Expenses e : expenses) {
                        System.out.println(e.expenseDescription + " -" + e.expenseAmount + "€ " + e.expenseCategory);
                    } 
            } else if(seeExpenseOrIncome.equals("income")) {
                 System.out.println("|*** ALL YOUR INCOMES ***|");
                    for (Incomes i : incomes) {
                        System.out.println(i.incomeSource + " +" + i.incomeAmount + "€ " + i.incomeDescription);
                    }
            }
        
        }
        scanner.close();
    }   
}
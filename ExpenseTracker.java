import java.util.*;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Expense exp = new Expense();
        
        System.out.println("\nWelcome to Expense Tracker!");
        
        while (true) {
            System.out.println("\nYou have the following options:\n1. Add Expense\n2. View Expense\n3. Delete Expense\n4. Calculate Total Expense\n5. Exit");
            System.out.print("\nPlease enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter expense name: ");
                    String expName = sc.nextLine();
                    System.out.print("Enter amount: ");
                    int expAmount = sc.nextInt();
                    //When nextInt() is used, it does not consume the newline character, causing nextLine() to be skipped.
                    sc.nextLine(); //added to clear the buffer
                    System.out.print("Enter date: ");
                    String expDate = sc.nextLine();
                    exp.add(expName, expAmount, expDate);
                    break;
                case 2:
                    exp.view();
                    break;
                case 3:
                    System.out.print("\nEnter expense name to delete: ");
                    String delexpName = sc.nextLine();
                    exp.delete(delexpName);
                    break;
                case 4:
                    exp.totalExpense();
                    break;
                case 5:
                    System.out.println("Exiting expense tracker");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, enter again.");
            }
        }
    }
}

class Expense {
    private static ArrayList<String> listName = new ArrayList<>();
    private static ArrayList<Integer> listAmount = new ArrayList<>();
    private static ArrayList<String> listDate = new ArrayList<>();
    private static int total = 0;

    public static void add(String name, int amount, String date) {
        listName.add(name);
        listAmount.add(amount);
        listDate.add(date);
        total += amount;
    }

    public static void view() {
        if (listName.isEmpty()) {
            System.out.println("\nNo expenses recorded.");
            return;
        }
        for (int i = 0; i < listName.size(); i++) {
            System.out.println("\nExpense: " + listName.get(i) + "\nAmount: " + listAmount.get(i) + "\nDate: " + listDate.get(i));
        }
    }

    public static void delete(String task) {
        for (int i = 0; i < listName.size(); i++) {
            if (listName.get(i).equalsIgnoreCase(task)) {
                total -= listAmount.get(i);
                listName.remove(i);
                listAmount.remove(i);
                listDate.remove(i);
                System.out.println("\nExpense deleted successfully.");
                return;
            }
        }
        System.out.println("\nExpense not found.");
    }

    public static void totalExpense() {
        System.out.println("\nTotal expense: " + total);
    }
}

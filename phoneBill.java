import java.util.Scanner;
import java.text.DecimalFormat;

class HelloWorld {
    public static void main(String[] args) {

        // Creating a Scanner object to read input from the user
        Scanner scan = new Scanner(System.in);
        // Creating a DecimalFormat object to format currency values
        DecimalFormat money = new DecimalFormat("$0.00");

        // Initializing variables
        double monthlyCost = 0;
        int monthlyData = 0;
        int moreData = 0;
        int extra = 0;
        double total;
        boolean greenPackage = false;
        boolean coupon = false;
        boolean bluePackage = false;
        boolean purplePackage = false;

        // Prompting the user to enter the color of the package they received
        System.out.println("Welcome to the Phone Bill calculator! Please enter the color of the package you received: ");
        String packageType = scan.nextLine();

        // Processing the package type entered by the user
        if (packageType.equalsIgnoreCase("green")) {
            greenPackage = true;
            // Asking the user if they have a coupon and processing their response
            System.out.println("Do you also have a coupon to go with your package? Please enter yes or no (This will only take $20 off if you have a total bill of $75 or more): ");
            String choice = scan.next();

            if (choice.equalsIgnoreCase("yes")) {
                coupon = true;
            }

            // Setting values for a green package
            monthlyCost = 49.99;
            monthlyData = 2;
            moreData = 15;

            // Prompting the user for additional data usage
            System.out.println("How many GB of data do you need in total this month?: ");
            extra = scan.nextInt();

        } else if(packageType.equalsIgnoreCase("blue")){
            // Setting values for a blue package
            bluePackage = true;
            monthlyCost = 70;
            monthlyData = 4;
            moreData = 10;

            // Prompting the user for additional data usage
            System.out.println("How many GB of data do you need in total this month?: ");
            extra = scan.nextInt();

        } else if (packageType.equalsIgnoreCase("purple")) {
            // Setting values for a purple package
            purplePackage = true;
            monthlyCost = 99.95;
        }

        // Calculating the total bill based on the package type and additional data usage
        if (greenPackage || bluePackage){
            total = monthlyCost + (moreData * (extra - monthlyData));
            if (greenPackage && coupon && total >= 75){
                // Deducting $20 if the user has a coupon and the total bill is $75 or more
                total -= 20;
            }
            // Printing the total bill for the month
            System.out.println("Your total from this month is " + money.format(total));
        } else if (purplePackage) {
            // Printing the total bill for the month for a purple package
            total = monthlyCost;
            System.out.println("Your total from this month is " + money.format(total));
        } else {
            // Handling invalid package names entered by the user
            System.out.println("Sorry, that wasn't  valid package name. Please try running the program again.");
        }
    }
}
import java.lang.reflect.Array;
import java.util.Scanner;

public class CapsuleHotelproject {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        // Start-up section
        // State the welcome message
        //Allow user to type in number of rooms
        //Define array with what the user put in
        //Use results from array to state how many rooms are unoccupied

        System.out.println("Welcome to the Capsule Hotel!");
        System.out.println("=".repeat(30));
        System.out.println("Enter the number of capsules available.");
        int numCapsules = console.nextInt();
        String[] guests = new String[numCapsules];
        System.out.println("There are " + numCapsules + " capsules in the facility.");

        //Create Guest Menu
        // "=" .repeat(30)
        // Menu options
        // Create set: 1. Check In 2. Check Out 3. View Guests 4.Exit
        // Let user type in num[1-4] to choose option.
        while (true) {

            System.out.println("Guest Menu");
            System.out.println("=".repeat(10));
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. View Guests");
            System.out.println("4. Exit");
            System.out.println("Choose an option [1-4]:");
            int userChoice = console.nextInt();

            //Check-in function
            // "Guest Check In" header
            // "=".repeat(14)
            //1.Let user type in name 2. Name will display as "Guest Name: <userinput>
            //1. Let user type number based on numCapsules. 2. Will either state room is either occupied/unoccupied
            //have array for guests that have registered

            if (userChoice == 1) {
                System.out.println("Guest Check In");
                System.out.println("=".repeat(12));
                System.out.println("Enter your name:");
                Scanner guestChIn = new Scanner(System.in);
                String guestNamein = guestChIn.nextLine();
                System.out.println("Guest Name: " + guestNamein);
                System.out.println("Enter the desired capsule number:");
                int capNumberIn = console.nextInt();


                if (capNumberIn > numCapsules) {
                    System.out.println("Invalid Room Number!");


                } else if (capNumberIn == 25 ) {
                    System.out.println("Capsule #[1-" + numCapsules + "]: " + capNumberIn);
                    System.out.println("Error :(");
                    System.out.println("Capsule #" + capNumberIn + " is occupied.");
                } else if (capNumberIn != 25) {
                    System.out.println("Capsule #[1-" + numCapsules + "]: " + capNumberIn);
                    System.out.println("Success :)");
                    System.out.println(guestNamein + " is booked in capsule #" + capNumberIn + ".");
                    guests[capNumberIn] = guestNamein;
                }
            }
            //Check Out Function
            //"Guest Check Out" Header
            //"=".repeat(14)
            //Capsule #[1-<capsule input from guest before menu>]: <desired capsule # from guest>
            // if 76 (or number above 50?), then the room is already unoccupied or not able to check out.
            //Error :( + Capsule <#> is unoccupied
            // if 26 (or number belo2 50?), then the room is occupied and can be checked out from.
            // Success :) + <Guest Name> checked out from Capsule <#>
            //have array for guests that have checked out
            //make sure that unoccupied rooms stay unoccupied until someone checks in
            if (userChoice == 2) {
                System.out.println("Guest Check Out");
                System.out.println("=".repeat(12));
                System.out.println("Enter your name:");
                Scanner guestChOut = new Scanner(System.in);
                String guestNameOut = guestChOut.nextLine();
                System.out.println("Guest Name: " + guestNameOut);
                System.out.println("Enter the desired capsule number:");
                int capNumberOut = console.nextInt();

                if (capNumberOut > numCapsules) {
                    System.out.println("Invalid Room Number!");


                } else if (capNumberOut == 76) {
                    System.out.println("Capsule #[1-" + numCapsules + "]: " + capNumberOut);
                    System.out.println("Error :(");
                    System.out.println("Capsule #" + capNumberOut + " is unoccupied.");
                } else if (capNumberOut != 76) {
                    System.out.println("Capsule #[1-" + numCapsules + "]: " + capNumberOut);
                    System.out.println("Success :)");
                    System.out.println(guestNameOut + " checked out from capsule #" + capNumberOut + ".");
                }
            }
            //View guest function
            //"View Guests" header
            // "=".repeat(10)
            //Capsule #[1-<guest input BEFORE menu>]: <guest input AFTER choosing 3
            //Array: Capsule #:Guest Name OR [unoccupied]
            if (userChoice == 3) {
                System.out.println("View Guests");
                System.out.println("=".repeat(10));
                System.out.println("Enter the desired capsule number:");
                int capNumberView = console.nextInt();
                System.out.println("Capsule #[1-" + numCapsules + "]: " + capNumberView);

                int[] capNumberList = {capNumberView - 5, capNumberView - 4, capNumberView - 3, capNumberView - 2, capNumberView - 1, capNumberView, capNumberView + 1, capNumberView + 2, capNumberView + 3, capNumberView + 4, 5 + capNumberView};





                for (int i = 0; i < capNumberList.length; i++) {
                    int currentCapsuleNumber = capNumberList[i];
                    String currentGuests = guests[currentCapsuleNumber];
                    if (currentGuests == null) {
                        currentGuests = "[unoccupied]";
                    }
                    if (capNumberView > numCapsules || capNumberView < 0) {
                        currentGuests = "invalid";
                        System.out.println(" ");


                    }

                    System.out.println(currentCapsuleNumber + ": " + currentGuests);

                }
            }


            //Exit menu
            //Include "are you sure... all data will be lost"
            //include section for user to gove input: y for yes and n for no
            if (userChoice == 4) {
                System.out.println("Are you sure you want to exit?");
                System.out.println("All data will be lost.");
                System.out.println("Exit [y/n]: ?");
                Scanner guestViewList = new Scanner(System.in);
                String YorN = guestViewList.nextLine();
                if (YorN.equals("y")) {
                    System.out.println("Exit [y/n]: " + YorN);
                    System.out.println("Goodbye!");
                    break;
                } else if (YorN.equals("n")) {

                }
            }
        }
    }

    }

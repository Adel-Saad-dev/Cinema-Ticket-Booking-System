
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    static char[][] seats;
    static String[] movieNames;

    public static void main(String[] args) {

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        seats = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = 'O';
            }
        }

        System.out.print("Enter number of movies: ");
        int numberOfMovies = input.nextInt();

        movieNames = new String[numberOfMovies];

        input.nextLine();

        for (int i = 0; i < numberOfMovies; i++) {
            System.out.print("Enter movie name " + (i + 1) + ": ");
            movieNames[i] = input.nextLine();
        }

        int choice;

        do {
            System.out.println("\n===== CINEMA MENU =====");
            System.out.println("1. Display Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show All Movies");
            System.out.println("5. Show Available and Booked Seats");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    displaySeats();
                    break;

                case 2:
                    bookSeat();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    showMovies();
                    break;

                case 5:
                    showStatus();
                    break;

                case 0:
                    System.out.println("Thank you! Goodbye.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 0);
    }

    public static void displaySeats() {

        System.out.println("\nCinema Seats:");

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bookSeat() {

        System.out.print("Enter row number: ");
        int row = input.nextInt();

        System.out.print("Enter seat number: ");
        int column = input.nextInt();

        if (row < 1 || row > seats.length ||
                column < 1 || column > seats[0].length) {

            System.out.println("Invalid Seat.");

        } else if (seats[row - 1][column - 1] == 'X') {

            System.out.println("Seat already booked.");

        } else {

            seats[row - 1][column - 1] = 'X';
            System.out.println("Seat booked successfully!");
        }
    }

    public static void cancelBooking() {

        System.out.print("Enter row number: ");
        int row = input.nextInt();

        System.out.print("Enter seat number: ");
        int column = input.nextInt();

        if (row < 1 || row > seats.length ||
                column < 1 || column > seats[0].length) {

            System.out.println("Invalid Seat.");

        } else if (seats[row - 1][column - 1] == 'O') {

            System.out.println("This seat is not booked.");

        } else {

            seats[row - 1][column - 1] = 'O';
            System.out.println("Booking cancelled successfully!");
        }
    }

    public static void showMovies() {

        System.out.println("\nAvailable Movies:");

        for (int i = 0; i < movieNames.length; i++) {
            System.out.println((i + 1) + ". " + movieNames[i]);
        }
    }

    public static void showStatus() {

        int booked = 0;
        int available = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == 'X') {
                    booked++;
                } else {
                    available++;
                }
            }
        }

        System.out.println("Booked Seats: " + booked);
        System.out.println("Available Seats: " + available);

        double occupancy = (double) booked /
                (seats.length * seats[0].length) * 100;

        System.out.println("Occupancy: " + occupancy + "%");

        if (occupancy > 80) {
            System.out.println("Almost Full!");
        }
    }
}

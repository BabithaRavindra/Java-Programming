import java.util.Scanner;

class MovieTicket {
    private String movieName;
    private int ticketPrice;

    public MovieTicket(String movieName, int ticketPrice) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }

    public void displayDetails() {  
        System.out.println("Movie Name: " + movieName);
        System.out.println("Ticket Price: ₹" + ticketPrice);
    }

    public void applyDiscount(int discount) {
        ticketPrice -= discount;
        System.out.println("Discount Applied. New Ticket Price: ₹" + ticketPrice);
    }
}

public class Lab_Program_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the movie name: ");
        String movieName = scanner.nextLine();
        System.out.print("Enter the ticket price: ");
        int ticketPrice = scanner.nextInt();
        System.out.print("Enter the discount amount: ");
        int discount = scanner.nextInt();


        MovieTicket ticket = new MovieTicket(movieName, ticketPrice);
        ticket.displayDetails();
        ticket.applyDiscount(discount);
        scanner.close(); 
    }
}

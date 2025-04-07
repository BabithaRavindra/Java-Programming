class Movie {
    private final String title;
    private final String genre;
    private final String director;

    public Movie(String title, String genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }
        
    public void displayInfo() {
        System.out.println("Movie Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Director: " + director);
    }
}

class Ticket extends Movie {
    private int seatNumber;
    private double price;

    public Ticket(String title, String genre, String director, int seatNumber, double price) {
        super(title, genre, director); 
        this.seatNumber = seatNumber;
        this.price = price;
    }

    @Override 
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}

public class Lab_Program_04 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Inception", "Sci-Fi", "Christopher Nolan", 10, 150.00);
        ticket.displayInfo();
    }
}
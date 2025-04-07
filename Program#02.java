import java.util.ArrayList;
import java.util.Scanner;

class Movie {
    private int movieId;
    private String title;
    private String genre;
    private String language;
    private int duration;

    // Accessor and Mutator methods for Movie attributes
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

class Ticket {
    private int ticketId;
    private int movieId;
    private String seatNumber;

    // Accessor and Mutator methods for Ticket attributes
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}

public class Lab_Program_03 {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Ticket> ticketList = new ArrayList<>();

    // ANSI Color Codes
    private static final String RESET = "\033[0m";
    private static final String GREEN = "\033[32m";
    private static final String YELLOW = "\033[33m";
    private static final String BLUE = "\033[34m";
    private static final String RED = "\033[31m";

    public static void main(String[] args) {
        while (true) {
            System.out.println(GREEN + "MAIN MENU:" + RESET);
            System.out.println("1) Movie");
            System.out.println("2) Ticket");
            System.out.println("3) Exit");
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    movieMenu();
                    break;
                case 2:
                    ticketMenu();
                    break;
                case 3:
                    System.out.println(RED + "Exiting program..." + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        }
    }

    private static void movieMenu() {
        while (true) {
            System.out.println(BLUE + "\nMOVIE MENU:" + RESET);
            System.out.println("a) Add Movie");
            System.out.println("b) View Movies");
            System.out.println("c) Update Movie");
            System.out.println("d) Remove Movie");
            System.out.println("e) Back to Main Menu");
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            char choice = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 'a':
                    addMovie();
                    break;
                case 'b':
                    viewMovies();
                    break;
                case 'c':
                    updateMovie();
                    break;
                case 'd':
                    removeMovie();
                    break;
                case 'e':
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        }
    }

    private static void addMovie() {
        Movie movie = new Movie();
        System.out.print(YELLOW + "Enter Movie ID: " + RESET);
        movie.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(YELLOW + "Enter Movie Title: " + RESET);
        movie.setTitle(scanner.nextLine());
        System.out.print(YELLOW + "Enter Genre: " + RESET);
        movie.setGenre(scanner.nextLine());
        System.out.print(YELLOW + "Enter Language: " + RESET);
        movie.setLanguage(scanner.nextLine());
        System.out.print(YELLOW + "Enter Duration (in minutes): " + RESET);
        movie.setDuration(scanner.nextInt());
        scanner.nextLine(); // consume newline
        movieList.add(movie);
        System.out.println(GREEN + "Movie added successfully." + RESET);
    }

    private static void viewMovies() {
        if (movieList.isEmpty()) {
            System.out.println(RED + "No movies available." + RESET);
        } else {
            for (Movie movie : movieList) {
                System.out.println("\n" + BLUE + "Movie ID: " + RESET + movie.getMovieId());
                System.out.println(BLUE + "Title: " + RESET + movie.getTitle());
                System.out.println(BLUE + "Genre: " + RESET + movie.getGenre());
                System.out.println(BLUE + "Language: " + RESET + movie.getLanguage());
                System.out.println(BLUE + "Duration: " + RESET + movie.getDuration() + " minutes");
            }
        }
    }

    private static void updateMovie() {
        System.out.print(YELLOW + "Enter Movie ID to update: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (Movie movie : movieList) {
            if (movie.getMovieId() == id) {
                System.out.print(YELLOW + "Enter new Title: " + RESET);
                movie.setTitle(scanner.nextLine());
                System.out.print(YELLOW + "Enter new Genre: " + RESET);
                movie.setGenre(scanner.nextLine());
                System.out.print(YELLOW + "Enter new Language: " + RESET);
                movie.setLanguage(scanner.nextLine());
                System.out.print(YELLOW + "Enter new Duration (in minutes): " + RESET);
                movie.setDuration(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.println(GREEN + "Movie updated successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Movie ID not found." + RESET);
    }

    private static void removeMovie() {
        System.out.print(YELLOW + "Enter Movie ID to remove: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        movieList.removeIf(movie -> movie.getMovieId() == id);
        System.out.println(GREEN + "Movie removed successfully." + RESET);
    }

    private static void ticketMenu() {
        while (true) {
            System.out.println(BLUE + "\nTICKET MENU:" + RESET);
            System.out.println("a) Add Ticket");
            System.out.println("b) View Tickets");
            System.out.println("c) Update Ticket");
            System.out.println("d) Cancel Ticket");
            System.out.println("e) Back to Main Menu");
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            char choice = scanner.next().charAt(0);
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 'a':
                    addTicket();
                    break;
                case 'b':
                    viewTickets();
                    break;
                case 'c':
                    updateTicket();
                    break;
                case 'd':
                    cancelTicket();
                    break;
                case 'e':
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        }
    }

    private static void addTicket() {
        Ticket ticket = new Ticket();
        System.out.print(YELLOW + "Enter Ticket ID: " + RESET);
        ticket.setTicketId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(YELLOW + "Enter Movie ID: " + RESET);
        ticket.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(YELLOW + "Enter Seat Number: " + RESET);
        ticket.setSeatNumber(scanner.nextLine());
        ticketList.add(ticket);
        System.out.println(GREEN + "Ticket added successfully." + RESET);
    }

    private static void viewTickets() {
        if (ticketList.isEmpty()) {
            System.out.println(RED + "No tickets available." + RESET);
        } else {
            for (Ticket ticket : ticketList) {
                System.out.println("\n" + BLUE + "Ticket ID: " + RESET + ticket.getTicketId());
                System.out.println(BLUE + "Movie ID: " + RESET + ticket.getMovieId());
                System.out.println(BLUE + "Seat Number: " + RESET + ticket.getSeatNumber());
            }
        }
    }

    private static void updateTicket() {
        System.out.print(YELLOW + "Enter Ticket ID to update: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketId() == id) {
                System.out.print(YELLOW + "Enter new Movie ID: " + RESET);
                ticket.setMovieId(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.print(YELLOW + "Enter new Seat Number: " + RESET);
                ticket.setSeatNumber(scanner.nextLine());
                System.out.println(GREEN + "Ticket updated successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Ticket ID not found." + RESET);
    }

    private static void cancelTicket() {
        System.out.print(YELLOW + "Enter Ticket ID to cancel: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        ticketList.removeIf(ticket -> ticket.getTicketId() == id);
        System.out.println(GREEN + "Ticket canceled successfully." + RESET);
    }
} 

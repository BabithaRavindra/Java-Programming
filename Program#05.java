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

public class Lab_Program_06 {
    private static Scanner scanner = new Scanner(System.in);
    private static Movie[] movieList = new Movie[100]; // Array for Movies
    private static Ticket[] ticketList = new Ticket[100]; // Array for Tickets
    private static int movieCount = 0;
    private static int ticketCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("MAIN MENU:");
            System.out.println("1) Movie");
            System.out.println("2) Ticket");
            System.out.println("3) Exit");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void movieMenu() {
        while (true) {
            System.out.println("\nMOVIE MENU:");
            System.out.println("a) Add Movie");
            System.out.println("b) View Movies");
            System.out.println("c) Update Movie");
            System.out.println("d) Remove Movie");
            System.out.println("e) Back to Main Menu");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addMovie() {
        if (movieCount >= movieList.length) {
            System.out.println("Movie list is full.");
            return;
        }
        Movie movie = new Movie();
        System.out.print("Enter Movie ID: ");
        movie.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print("Enter Movie Title: ");
        movie.setTitle(scanner.nextLine());
        System.out.print("Enter Genre: ");
        movie.setGenre(scanner.nextLine());
        System.out.print("Enter Language: ");
        movie.setLanguage(scanner.nextLine());
        System.out.print("Enter Duration (in minutes): ");
        movie.setDuration(scanner.nextInt());
        scanner.nextLine(); // consume newline

        movieList[movieCount++] = movie;
        System.out.println("Movie added successfully.");
    }

    private static void viewMovies() {
        if (movieCount == 0) {
            System.out.println("No movies available.");
        } else {
            for (int i = 0; i < movieCount; i++) {
                Movie movie = movieList[i];
                System.out.println("\nMovie ID: " + movie.getMovieId());
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Genre: " + movie.getGenre());
                System.out.println("Language: " + movie.getLanguage());
                System.out.println("Duration: " + movie.getDuration() + " minutes");
            }
        }
    }

    private static void updateMovie() {
        System.out.print("Enter Movie ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < movieCount; i++) {
            Movie movie = movieList[i];
            if (movie.getMovieId() == id) {
                System.out.print("Enter new Title: ");
                movie.setTitle(scanner.nextLine());
                System.out.print("Enter new Genre: ");
                movie.setGenre(scanner.nextLine());
                System.out.print("Enter new Language: ");
                movie.setLanguage(scanner.nextLine());
                System.out.print("Enter new Duration (in minutes): ");
                movie.setDuration(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.println("Movie updated successfully.");
                return;
            }
        }
        System.out.println("Movie ID not found.");
    }

    private static void removeMovie() {
        System.out.print("Enter Movie ID to remove: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < movieCount; i++) {
            if (movieList[i].getMovieId() == id) {
                // Shift elements left to fill the gap
                for (int j = i; j < movieCount - 1; j++) {
                    movieList[j] = movieList[j + 1];
                }
                movieList[--movieCount] = null; // Clear the last element
                System.out.println("Movie removed successfully.");
                return;
            }
        }
        System.out.println("Movie ID not found.");
    }

    private static void ticketMenu() {
        while (true) {
            System.out.println("\nTICKET MENU:");
            System.out.println("a) Add Ticket");
            System.out.println("b) View Tickets");
            System.out.println("c) Update Ticket");
            System.out.println("d) Cancel Ticket");
            System.out.println("e) Back to Main Menu");
            System.out.print("Enter your choice: ");
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
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTicket() {
        if (ticketCount >= ticketList.length) {
            System.out.println("Ticket list is full.");
            return;
        }
        Ticket ticket = new Ticket();
        System.out.print("Enter Ticket ID: ");
        ticket.setTicketId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print("Enter Movie ID: ");
        ticket.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print("Enter Seat Number: ");
        ticket.setSeatNumber(scanner.nextLine());

        ticketList[ticketCount++] = ticket;
        System.out.println("Ticket added successfully.");
    }

    private static void viewTickets() {
        if (ticketCount == 0) {
            System.out.println("No tickets available.");
        } else {
            for (int i = 0; i < ticketCount; i++) {
                Ticket ticket = ticketList[i];
                System.out.println("\nTicket ID: " + ticket.getTicketId());
                System.out.println("Movie ID: " + ticket.getMovieId());
                System.out.println("Seat Number: " + ticket.getSeatNumber());
            }
        }
    }

    private static void updateTicket() {
        System.out.print("Enter Ticket ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = ticketList[i];
            if (ticket.getTicketId() == id) {
                System.out.print("Enter new Movie ID: ");
                ticket.setMovieId(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.print("Enter new Seat Number: ");
                ticket.setSeatNumber(scanner.nextLine());
                System.out.println("Ticket updated successfully.");
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }

    private static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < ticketCount; i++) {
            if (ticketList[i].getTicketId() == id) {
                // Shift elements left to fill the gap
                for (int j = i; j < ticketCount - 1; j++) {
                    ticketList[j] = ticketList[j + 1];
                }
                ticketList[--ticketCount] = null; // Clear the last element
                System.out.println("Ticket canceled successfully.");
                return;
            }
        }
        System.out.println("Ticket ID not found.");
    }
}

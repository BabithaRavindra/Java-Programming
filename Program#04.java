import models.Movie;
import models.Ticket;

import java.util.Scanner;
 
public class Lab_Program_05{
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
 
    private static final int MAX_MOVIES = 10;
    private static final int MAX_TICKETS = 10;

    private static Scanner scanner = new Scanner(System.in);
    private static Movie[] movieList = new Movie[MAX_MOVIES];
    private static int movieCount = 0;
    private static Ticket[] ticketList = new Ticket[MAX_TICKETS];
    private static int ticketCount = 0;

    public static void main(String[] args) { 
        while (true) {
            System.out.println(YELLOW + "\nMAIN MENU:" + RESET);
            System.out.println(CYAN + "1) Movie" + RESET);
            System.out.println(CYAN + "2) Ticket" + RESET);
            System.out.println(CYAN + "3) Exit" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);
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
                    System.out.println(GREEN + "Exiting program..." + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Try again." + RESET);
            }
        }
    }

    private static void movieMenu() {
        while (true) {
            System.out.println(YELLOW + "\nMOVIE MENU:" + RESET);
            System.out.println(CYAN + "a) Add Movie" + RESET);
            System.out.println(CYAN + "b) View Movies" + RESET);
            System.out.println(CYAN + "c) Update Movie" + RESET);
            System.out.println(CYAN + "d) Remove Movie" + RESET);
            System.out.println(CYAN + "e) Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);
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
        if (movieCount >= MAX_MOVIES) {
            System.out.println(RED + "Movie list is full. Cannot add more movies." + RESET);
            return;
        }
        Movie movie = new Movie();
        System.out.print(BLUE + "Enter Movie ID: " + RESET);
        movie.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(BLUE + "Enter Movie Title: " + RESET);
        movie.setTitle(scanner.nextLine());
        System.out.print(BLUE + "Enter Genre: " + RESET);
        movie.setGenre(scanner.nextLine());
        System.out.print(BLUE + "Enter Language: " + RESET);
        movie.setLanguage(scanner.nextLine());
        System.out.print(BLUE + "Enter Duration (in minutes): " + RESET);
        movie.setDuration(scanner.nextInt());
        scanner.nextLine(); // consume newline
        movieList[movieCount++] = movie;
        System.out.println(GREEN + "Movie added successfully." + RESET);
    }

    private static void viewMovies() {
        if (movieCount == 0) {
            System.out.println(RED + "No movies available." + RESET);
        } else {
            for (int i = 0; i < movieCount; i++) {
                Movie movie = movieList[i];
                System.out.println(YELLOW + "\nMovie ID: " + RESET + movie.getMovieId());
                System.out.println(YELLOW + "Title: " + RESET + movie.getTitle());
                System.out.println(YELLOW + "Genre: " + RESET + movie.getGenre());
                System.out.println(YELLOW + "Language: " + RESET + movie.getLanguage());
                System.out.println(YELLOW + "Duration: " + RESET + movie.getDuration() + " minutes");
            }
        }
    }

    private static void updateMovie() {
        System.out.print(BLUE + "Enter Movie ID to update: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < movieCount; i++) {
            Movie movie = movieList[i];
            if (movie.getMovieId() == id) {
                System.out.print(BLUE + "Enter new Title: " + RESET);
                movie.setTitle(scanner.nextLine());
                System.out.print(BLUE + "Enter new Genre: " + RESET);
                movie.setGenre(scanner.nextLine());
                System.out.print(BLUE + "Enter new Language: " + RESET);
                movie.setLanguage(scanner.nextLine());
                System.out.print(BLUE + "Enter new Duration (in minutes): " + RESET);
                movie.setDuration(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.println(GREEN + "Movie updated successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Movie ID not found." + RESET);
    }

    private static void removeMovie() {
        System.out.print(BLUE + "Enter Movie ID to remove: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < movieCount; i++) {
            if (movieList[i].getMovieId() == id) {
                for (int j = i; j < movieCount - 1; j++) {
                    movieList[j] = movieList[j + 1];
                }
                movieList[--movieCount] = null;
                System.out.println(GREEN + "Movie removed successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Movie ID not found." + RESET);
    }

    private static void ticketMenu() {
        while (true) {
            System.out.println(YELLOW + "\nTICKET MENU:" + RESET);
            System.out.println(CYAN + "a) Add Ticket" + RESET);
            System.out.println(CYAN + "b) View Tickets" + RESET);
            System.out.println(CYAN + "c) Update Ticket" + RESET);
            System.out.println(CYAN + "d) Cancel Ticket" + RESET);
            System.out.println(CYAN + "e) Back to Main Menu" + RESET);
            System.out.print(BLUE + "Enter your choice: " + RESET);
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
        if (ticketCount >= MAX_TICKETS) {
            System.out.println(RED + "Ticket list is full. Cannot add more tickets." + RESET);
            return;
        }
        Ticket ticket = new Ticket();
        System.out.print(BLUE + "Enter Ticket ID: " + RESET);
        ticket.setTicketId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(BLUE + "Enter Movie ID: " + RESET);
        ticket.setMovieId(scanner.nextInt());
        scanner.nextLine(); // consume newline
        System.out.print(BLUE + "Enter Seat Number: " + RESET);
        ticket.setSeatNumber(scanner.nextLine());
        ticketList[ticketCount++] = ticket;
        System.out.println(GREEN + "Ticket added successfully." + RESET);
    }

    private static void viewTickets() {
        if (ticketCount == 0) {
            System.out.println(RED + "No tickets available." + RESET);
        } else {
            for (int i = 0; i < ticketCount; i++) {
                Ticket ticket = ticketList[i];
                System.out.println(YELLOW + "\nTicket ID: " + RESET + ticket.getTicketId());
                System.out.println(YELLOW + "Movie ID: " + RESET + ticket.getMovieId());
                System.out.println(YELLOW + "Seat Number: " + RESET + ticket.getSeatNumber());
            }
        }
    }

    private static void updateTicket() {
        System.out.print(BLUE + "Enter Ticket ID to update: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = ticketList[i];
            if (ticket.getTicketId() == id) {
                System.out.print(BLUE + "Enter new Movie ID: " + RESET);
                ticket.setMovieId(scanner.nextInt());
                scanner.nextLine(); // consume newline
                System.out.print(BLUE + "Enter new Seat Number: " + RESET);
                ticket.setSeatNumber(scanner.nextLine());
                System.out.println(GREEN + "Ticket updated successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Ticket ID not found." + RESET);
    }

    private static void cancelTicket() {
        System.out.print(BLUE + "Enter Ticket ID to cancel: " + RESET);
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        for (int i = 0; i < ticketCount; i++) {
            if (ticketList[i].getTicketId() == id) {
                for (int j = i; j < ticketCount - 1; j++) {
                    ticketList[j] = ticketList[j + 1];
                }
                ticketList[--ticketCount] = null;
                System.out.println(GREEN + "Ticket canceled successfully." + RESET);
                return;
            }
        }
        System.out.println(RED + "Ticket ID not found." + RESET);
    }
}

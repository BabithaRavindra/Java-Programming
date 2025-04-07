import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Lab_Program_10 extends JFrame {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Ticket> ticketList = new ArrayList<>();

    // Synchronization objects
    private static final Object movieListLock = new Object();
    private static final Object ticketListLock = new Object();

    // Swing Objects
    private JTextArea outputArea;
    private JTextField movieIdField, titleField, genreField, languageField, durationField, ticketIdField,
            seatNumberField, movieIdTicketField;

    public Lab_Program_10() {
        setTitle("Movie Ticket System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Movie input fields
        movieIdField = new JTextField();
        titleField = new JTextField();
        genreField = new JTextField();
        languageField = new JTextField();
        durationField = new JTextField();

        // Ticket input fields
        ticketIdField = new JTextField();
        movieIdTicketField = new JTextField();
        seatNumberField = new JTextField();

        // Movie Input Labels and Fields
        inputPanel.add(new JLabel("Movie ID:"));
        inputPanel.add(movieIdField);
        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);
        inputPanel.add(new JLabel("Genre:"));
        inputPanel.add(genreField);
        inputPanel.add(new JLabel("Language:"));
        inputPanel.add(languageField);
        inputPanel.add(new JLabel("Duration:"));
        inputPanel.add(durationField);

        // Ticket Input Labels and Fields
        inputPanel.add(new JLabel("Ticket ID:"));
        inputPanel.add(ticketIdField);
        inputPanel.add(new JLabel("Movie ID (Ticket):"));
        inputPanel.add(movieIdTicketField);
        inputPanel.add(new JLabel("Seat Number:"));
        inputPanel.add(seatNumberField);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addMovieButton = new JButton("Add Movie");
        JButton viewMoviesButton = new JButton("View Movies");
        JButton updateMovieButton = new JButton("Update Movie");
        JButton removeMovieButton = new JButton("Remove Movie");
        JButton addTicketButton = new JButton("Add Ticket");
        JButton viewTicketsButton = new JButton("View Tickets");
        JButton updateTicketButton = new JButton("Update Ticket");
        JButton cancelTicketButton = new JButton("Cancel Ticket");

        buttonPanel.add(addMovieButton);
        buttonPanel.add(viewMoviesButton);
        buttonPanel.add(updateMovieButton);
        buttonPanel.add(removeMovieButton);
        buttonPanel.add(addTicketButton);
        buttonPanel.add(viewTicketsButton);
        buttonPanel.add(updateTicketButton);
        buttonPanel.add(cancelTicketButton);

        addMovieButton.addActionListener(e -> addMovie());
        viewMoviesButton.addActionListener(e -> viewMovies());
        updateMovieButton.addActionListener(e -> updateMovie());
        removeMovieButton.addActionListener(e -> removeMovie());
        addTicketButton.addActionListener(e -> addTicket());
        viewTicketsButton.addActionListener(e -> viewTickets());
        updateTicketButton.addActionListener(e -> updateTicket());
        cancelTicketButton.addActionListener(e -> cancelTicket());

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addMovie() {
        Movie movie = new Movie();
        try {
            movie.setMovieId(Integer.parseInt(movieIdField.getText()));
            movie.setTitle(titleField.getText());
            movie.setGenre(genreField.getText());
            movie.setLanguage(languageField.getText());
            movie.setDuration(Integer.parseInt(durationField.getText()));
        } catch (NumberFormatException ex) {
            outputArea.append("Invalid input. Please check your entries.\n");
            return;
        }

        synchronized (movieListLock) {
            movieList.add(movie);
        }
        outputArea.append("Movie added successfully.\n");
        clearMovieFields();
    }

    private void viewMovies() {
        outputArea.setText("");
        synchronized (movieListLock) {
            if (movieList.isEmpty()) {
                outputArea.append("No movies available.\n");
            } else {
                for (Movie movie : movieList) {
                    outputArea.append("Movie ID: " + movie.getMovieId() + "\n");
                    outputArea.append("Title: " + movie.getTitle() + "\n");
                    outputArea.append("Genre: " + movie.getGenre() + "\n");
                    outputArea.append("Language: " + movie.getLanguage() + "\n");
                    outputArea.append("Duration: " + movie.getDuration() + " minutes\n\n");
                }
            }
        }
    }

    private void updateMovie() {
        int id;
        try {
            id = Integer.parseInt(movieIdField.getText());
        } catch (NumberFormatException e) {
            outputArea.append("Please enter a valid movie Id.\n");
            return;
        }

        synchronized (movieListLock) {
            for (Movie movie : movieList) {
                if (movie.getMovieId() == id) {
                    movie.setTitle(titleField.getText());
                    movie.setGenre(genreField.getText());
                    movie.setLanguage(languageField.getText());
                    movie.setDuration(Integer.parseInt(durationField.getText()));
                    outputArea.append("Movie updated successfully.\n");
                    clearMovieFields();
                    return;
                }
            }
        }
        outputArea.append("Movie ID not found.\n");
    }

    private void removeMovie() {
        int id;
        try {
            id = Integer.parseInt(movieIdField.getText());
        } catch (NumberFormatException e) {
            outputArea.append("Please enter a valid movie Id.\n");
            return;
        }

        synchronized (movieListLock) {
            movieList.removeIf(movie -> movie.getMovieId() == id);
        }
        outputArea.append("Movie removed successfully.\n");
        clearMovieFields();
    }

    private void addTicket() {
        Ticket ticket = new Ticket();
        try {
            ticket.setTicketId(Integer.parseInt(ticketIdField.getText()));
            ticket.setMovieId(Integer.parseInt(movieIdTicketField.getText()));
            ticket.setSeatNumber(seatNumberField.getText());
        } catch (NumberFormatException e) {
            outputArea.append("Invalid ticket input.\n");
            return;
        }

        synchronized (ticketListLock) {
            ticketList.add(ticket);
        }
        outputArea.append("Ticket added successfully.\n");
        clearTicketFields();
    }

    private void viewTickets() {
        outputArea.setText("");
        synchronized (ticketListLock) {
            if (ticketList.isEmpty()) {
                outputArea.append("No tickets available.\n");
            } else {
                for (Ticket ticket : ticketList) {
                    outputArea.append("Ticket ID: " + ticket.getTicketId() + "\n");
                    outputArea.append("Movie ID: " + ticket.getMovieId() + "\n");
                    outputArea.append("Seat Number: " + ticket.getSeatNumber() + "\n\n");
                }
            }
        }
    }

    private void updateTicket() {
        int id;
        try {
            id = Integer.parseInt(ticketIdField.getText());
        } catch (NumberFormatException e) {
            outputArea.append("Please enter a valid ticket Id.\n");
            return;
        }
        synchronized (ticketListLock) {
            for (Ticket ticket : ticketList) {
                if (ticket.getTicketId() == id) {
                    ticket.setMovieId(Integer.parseInt(movieIdTicketField.getText()));
                    ticket.setSeatNumber(seatNumberField.getText());
                    outputArea.append("Ticket updated successfully.\n");
                    clearTicketFields();
                    return;
                }
            }
        }
        outputArea.append("Ticket ID not found.\n");
    }

    private void cancelTicket() {
        int id;
        try {
            id = Integer.parseInt(ticketIdField.getText());
        } catch (NumberFormatException e) {
            outputArea.append("Please enter a valid ticket Id.\n");
            return;
        }
        synchronized (ticketListLock) {
            ticketList.removeIf(ticket -> ticket.getTicketId() == id);
        }
        outputArea.append("Ticket canceled successfully.\n");
        clearTicketFields();
    }

    private void clearMovieFields() {
        movieIdField.setText("");
        titleField.setText("");
        genreField.setText("");
        languageField.setText("");
        durationField.setText("");
    }

    private void clearTicketFields() {
        ticketIdField.setText("");
        movieIdTicketField.setText("");
        seatNumberField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Lab_Program_10::new);
    }
}
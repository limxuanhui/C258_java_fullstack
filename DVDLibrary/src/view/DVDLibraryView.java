package view;
/* Created by limxuanhui on 27/7/22 */

import dto.DVD;
import dto.enums.MPAARating;
import view.io.UserIO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DVDLibraryView {
    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public void displayMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1) Add DVD");
        System.out.println("2) Delete DVD");
        System.out.println("3) Edit DVD");
        System.out.println("4) Search DVD");
        System.out.println("5) View All DVD");
        System.out.println("6) Save and quit");
    }

    public int getUserMenuChoice() {
        return io.readInt("Enter your choice: ", 1, 6);
    }

    public DVD getNewDVD() {
        String title = io.readString("Enter the DVD title: ");
        String dateString = io.readString("Enter the release date in the following format (DD/MM/YYYY): ");
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int mpaaRatingValue = io.readInt("Enter the MPAA rating value (1 to 5): ", 1, 5);
        MPAARating rating = MPAARating.values()[mpaaRatingValue - 1];
        String directorName = io.readString("Enter the director's name: ");
        String studio = io.readString("Enter the studio name: ");
        String userNote = io.readString("Enter any additional notes: ");
        return new DVD(title, releaseDate, rating, directorName, studio, userNote);
    }

    public void viewDVDOpResult(DVD dvd, String op) {
        io.print("=== This DVD has been " + op + " ===");
        displayDVD(dvd);
        io.print("===============================");
    }

    public String getDVDTitle() {
        return io.readString("Which title?");
    }

    public void displayDVD(DVD dvd) {
        if (dvd == null) {
            io.print("No dvd found.");
            return;
        }
        io.print("---------------");
        io.print(dvd.toString());
        io.print("---------------");
    }

    public boolean getYesNo(String prompt) {
        return io.readYesNo(prompt).equals("y");
    }

    public void notifyInvalidChoice() {
        io.print("Invalid choice, please enter one of the choices above");
    }
}

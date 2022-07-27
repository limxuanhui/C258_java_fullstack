package controller;
/* Created by limxuanhui on 27/7/22 */

import dao.DVDLibraryDaoFileImpl;
import dao.DVDLibraryException;
import dto.DVD;
import view.DVDLibraryView;

import java.util.List;

public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDaoFileImpl dao;

    public DVDLibraryController(DVDLibraryView view, DVDLibraryDaoFileImpl dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        System.out.println("Running controller");
        boolean keepGoing = true;
        while (keepGoing) {
            view.displayMenu();
            int userChoice = view.getUserMenuChoice();
            switch (userChoice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    deleteDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    getDVD();
                    break;
                case 5:
                    viewAllDVDs();
                    break;
                case 6:
                    saveAndQuit();
                    keepGoing = false;
                    break;
                default:
                    invalidChoice();
            }
        }
    }

    private DVD addDVD() {
        DVD newDVD = view.getNewDVD();
        DVD addedDVD = dao.addDVD(newDVD);
        view.viewDVDOpResult(addedDVD, "added");
        return addedDVD;
    }

    private DVD deleteDVD() {
        DVD dvd = getDVD();
        if (dvd != null) {
            boolean confirmDelete = view.getYesNo("Delete this dvd?");
            if (confirmDelete) {
                DVD deletedDVD = dao.deleteDVD(dvd);
                view.viewDVDOpResult(deletedDVD, "deleted");
                return deletedDVD;
            }
        }

        return null;
    }

    private DVD editDVD() {
        DVD dvd = getDVD();
        if (dvd != null) {
            DVD editedDvd = view.getNewDVD();
            dvd.setTitle(editedDvd.getTitle());
            dvd.setReleaseDate(editedDvd.getReleaseDate());
            dvd.setMpaaRating(editedDvd.getMpaaRating());
            dvd.setDirectorName(editedDvd.getDirectorName());
            dvd.setStudio(editedDvd.getStudio());
            dvd.setUserNote(editedDvd.getUserNote());
            view.viewDVDOpResult(dvd, "edited");
        }
        return dvd;
    }

    private DVD getDVD() {
        String title = view.getDVDTitle();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
        return dvd;
    }

    private void viewAllDVDs() {
        List<DVD> dvds = dao.getAllDVDs();
        if (dvds.size() == 0) {
            System.out.println("No dvds found");
            return;
        }
        for (DVD dvd : dvds) {
            view.displayDVD(dvd);
        }
    }

    private void saveAndQuit() {
        try {
            dao.writeData();
            System.out.println("Saved.");
        } catch (DVDLibraryException e) {
            System.out.println(e.getMessage());
        }
    }

    private void invalidChoice() {
        view.notifyInvalidChoice();
    }
}

package dao;
/* Created by limxuanhui on 27/7/22 */

import dto.DVD;
import dto.enums.MPAARating;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
    private final String DELIMITER = "\\|";
    private final String DVD_LIBRARY = "src/dvds.txt";
    private List<DVD> dvds;

    public DVDLibraryDaoFileImpl() {
        try {
            loadData();
        } catch (DVDLibraryException e) {
            System.out.println("Could not load data");
        }
    }

    public DVD addDVD(DVD newDVD) {
        dvds.add(newDVD);
        return newDVD;
    }

    public DVD getDVD(String title) {
        List<DVD> dvdsFound = dvds.stream()
                .filter(dvd -> dvd.getTitle().equals(title))
                .collect(Collectors.toList());
        if (dvdsFound.size() == 0) {
            return null;
        }
        return dvdsFound.get(0);
    }

    public DVD deleteDVD(DVD dvd) {
        boolean removed = dvds.remove(dvd);
        if (removed) {
            return dvd;
        }
        return null;
    }

    public List<DVD> getAllDVDs() {
        return dvds;
    }

    public void loadData() throws DVDLibraryException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryException(e.getMessage(), e);
        }

        dvds = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String DVDString = scanner.nextLine();
            DVD dvd = unmarshallDVD(DVDString);
            dvds.add(dvd);
        }
        scanner.close();
    }

    public void writeData() throws DVDLibraryException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY));
        } catch (IOException e) {
            throw new DVDLibraryException(e.getMessage(), e);
        }

        for (DVD dvd : dvds) {
            String dvdString = marshallDVD(dvd);
            out.println(dvdString);
            out.flush();
        }
        out.close();
    }

    public DVD unmarshallDVD(String dvdString) {
        String[] dvdTokens = dvdString.split(DELIMITER);
        System.out.println(Arrays.toString(dvdTokens));
        String title = dvdTokens[0];
        Date releaseDate = null;
        try {
            releaseDate = new SimpleDateFormat("dd/MM/yyyy").parse(dvdTokens[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MPAARating mpaaRating = MPAARating.values()[Integer.parseInt(dvdTokens[2])];
        String directorName = dvdTokens[3];
        String studio = dvdTokens[4];
        String userNote = dvdTokens[5];
        return new DVD(title, releaseDate, mpaaRating, directorName, studio, userNote);
    }

    public String marshallDVD(DVD dvd) {
        String title = dvd.getTitle();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String releaseDate = dateFormat.format(dvd.getReleaseDate());
        String mpaaRating = dvd.getMpaaRating().ratingValue + "";
        String directorName = dvd.getDirectorName();
        String studio = dvd.getStudio();
        String userNote = dvd.getUserNote();
        return title + DELIMITER + releaseDate + DELIMITER + mpaaRating + DELIMITER
                + directorName + DELIMITER + studio + DELIMITER + userNote;
    }
}

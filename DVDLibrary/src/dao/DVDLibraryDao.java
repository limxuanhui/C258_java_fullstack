package dao;
/* Created by limxuanhui on 27/7/22 */

import dto.DVD;

import java.util.List;

public interface DVDLibraryDao {

    DVD addDVD(DVD newDVD);
    DVD getDVD(String title);
    DVD deleteDVD(DVD dvd);
    List<DVD> getAllDVDs();

}

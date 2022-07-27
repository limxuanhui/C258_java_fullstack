package dto;
/* Created by limxuanhui on 27/7/22 */

import dto.enums.MPAARating;

import java.util.Date;
import java.util.Objects;

public class DVD {
    private String title;
    private Date releaseDate;
    private MPAARating mpaaRating;
    private String directorName;
    private String studio;
    private String userNote;

    public DVD(String title, Date releaseDate, MPAARating mpaaRating, String directorName, String studio, String userNote) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.mpaaRating = mpaaRating;
        this.directorName = directorName;
        this.studio = studio;
        this.userNote = userNote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public MPAARating getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(MPAARating mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n"
                + "Release date: " + releaseDate + "\n"
                + "MPAA rating: " + mpaaRating.name() + "\n"
                + "Director: " + directorName + "\n"
                + "Studio: " + studio + "\n"
                + "User note: " + userNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(title, dvd.title) && Objects.equals(releaseDate, dvd.releaseDate) && mpaaRating == dvd.mpaaRating && Objects.equals(directorName, dvd.directorName) && Objects.equals(studio, dvd.studio) && Objects.equals(userNote, dvd.userNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, mpaaRating, directorName, studio, userNote);
    }
}

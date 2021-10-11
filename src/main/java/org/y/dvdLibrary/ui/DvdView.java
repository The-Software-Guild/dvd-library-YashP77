package org.y.dvdLibrary.ui;

import org.y.dvdLibrary.dao.DvdDao;
import org.y.dvdLibrary.dao.DvdDaoFileImpl;
import org.y.dvdLibrary.dto.Dvd;

import java.util.*;

public class DvdView {

    private UserIO io;

    public DvdView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection(){

        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");

        return io.readInt("Please select from the above choices.", 1, 5);

    }

    public Dvd getNewDvdInfo(){

        String title = io.readString("Please enter DVD title");
        String releaseDate = io.readString("Please enter DVD release date");
        String mpaaRating = io.readString("Please enter DVD MPAA rating");
        String dirName = io.readString("Please enter DVD director name");
        String studio = io.readString("Please enter DVD studio");
        String userRating = io.readString("Please enter DVD user rating");

        Dvd newDvd = new Dvd(title);
        newDvd.setReleaseDate(releaseDate);
        newDvd.setMpaaRating(mpaaRating);
        newDvd.setDirName(dirName);
        newDvd.setStudio(studio);
        newDvd.setUserRating(userRating);
        return newDvd;

    }

    public void displayAddDvdBanner() {
        io.print("=== Add DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("Student successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd i : dvdList) {
            String dvdInfo = String.format("%s : %s %s %s %s %s",
                    i.getTitle(),
                    i.getReleaseDate(),
                    i.getMpaaRating(),
                    i.getDirName(),
                    i.getStudio(),
                    i.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDvdListBanner() {
        io.print("=== Display All Dvd's ===");
    }

    public void displayDvdBanner () {
        io.print("=== Display DVD ===");
    }

    public String getDvdChoice() {
        return io.readString("Please enter the DVD title");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such DVD");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvd) {
        if(dvd != null){
            io.print("Dvd successfully removed.");
        }else{
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }




}

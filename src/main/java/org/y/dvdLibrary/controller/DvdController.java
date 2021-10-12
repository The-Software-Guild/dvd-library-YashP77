package org.y.dvdLibrary.controller;


import org.y.dvdLibrary.dao.*;
import org.y.dvdLibrary.dto.*;
import org.y.dvdLibrary.ui.*;

import java.util.*;

public class DvdController {

    private DvdView view;
    private DvdDao dao;

    public DvdController(DvdDao dao, DvdView view) {
        this.dao = dao;
        this.view = view;
    }


    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvd();
                        break;
                    case 2:
                        addDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void addDvd() throws DvdDaoException{

        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();

    }

    private void listDvd() throws DvdDaoException {
        view.displayDvdListBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdDaoException {
        view.displayDvdBanner();
        String title = view.getDvdChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdChoice();
        Dvd delDvd = dao.removeDvd(title);
        view.displayRemoveResult(delDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}

package org.y.dvdLibrary;

import org.y.dvdLibrary.controller.DvdController;
import org.y.dvdLibrary.dao.DvdDao;
import org.y.dvdLibrary.dao.DvdDaoFileImpl;
import org.y.dvdLibrary.ui.DvdView;
import org.y.dvdLibrary.ui.UserIO;
import org.y.dvdLibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) {

        UserIO myIo = new UserIOConsoleImpl();

        DvdView myView = new DvdView(myIo);
        DvdDao myDao = new DvdDaoFileImpl();

        DvdController controller = new DvdController(myDao, myView);

        controller.run();
    }

}


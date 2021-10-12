package org.y.dvdLibrary.dao;

import org.y.dvdLibrary.dto.Dvd;

import java.io.*;
import java.util.*;

public class DvdDaoFileImpl implements DvdDao{

    private Map<String, Dvd> dvds = new HashMap<>();

    public static final String DVD_FILE = "dvd.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdDaoException{

        loadRoster();
        Dvd add = dvds.put(title, dvd);
        writeRoster();
        return add;

    }

    @Override
    public List<Dvd> getAllDvds() throws DvdDaoException{
        loadRoster();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdDaoException{
        loadRoster();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdDaoException{

        loadRoster();
        Dvd delDvd = dvds.remove(title);
        writeRoster();
        return delDvd;
    }

    private Dvd unmarshallDvd(String dvdAsText){

        String[] dvdTokens = dvdAsText.split(DELIMITER);

        String title = dvdTokens[0];

        Dvd dvdFromFile = new Dvd(title);

        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDirName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);

        return dvdFromFile;
    }

    private void loadRoster() throws DvdDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException(
                    "-_- Could not load dvd data into memory.", e);
        }
        String currentLine;
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private String marshallDvd(Dvd aDvd){

        String dvdAsText = aDvd.getTitle() + DELIMITER;

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        dvdAsText += aDvd.getDirName() + DELIMITER;

        dvdAsText += aDvd.getStudio() + DELIMITER;

        dvdAsText += aDvd.getUserRating();

        return dvdAsText;
    }

    private void writeRoster() throws DvdDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DvdDaoException(
                    "Could not save student data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvds();

        for (Dvd currentDvd : dvdList) {

            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }




}

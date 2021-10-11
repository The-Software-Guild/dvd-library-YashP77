package org.y.dvdLibrary.dao;

import org.y.dvdLibrary.dto.Dvd;

import java.util.List;

public interface DvdDao {

    Dvd addDvd(String title, Dvd dvd);

    List<Dvd> getAllDvds();

    Dvd getDvd(String title);

    Dvd removeDvd(String title);

}

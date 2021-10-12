package org.y.dvdLibrary.dao;

import org.y.dvdLibrary.dto.Dvd;

import java.util.List;

public interface DvdDao {

    Dvd addDvd(String title, Dvd dvd) throws DvdDaoException;

    List<Dvd> getAllDvds() throws DvdDaoException;

    Dvd getDvd(String title) throws DvdDaoException;

    Dvd removeDvd(String title) throws DvdDaoException;

}

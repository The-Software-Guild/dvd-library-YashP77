package org.y.dvdLibrary.dao;

import org.y.dvdLibrary.dto.Dvd;

import java.util.*;

public class DvdDaoFileImpl implements DvdDao{

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        Dvd add = dvds.put(title, dvd);
        return add;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) {
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd delDvd = dvds.remove(title);
        return delDvd;
    }
}

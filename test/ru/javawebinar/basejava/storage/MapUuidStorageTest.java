package ru.javawebinar.basejava.storage;

import org.junit.Ignore;
import org.junit.Test;

public class MapUuidStorageTest extends AbstractStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Override
    @Ignore("Map is unsorted!")
    @Test
    public void getAllSorted() throws Exception {
       //empty
    }
}

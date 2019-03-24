package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class MapStorageTest extends AbstractArrayStorageTest {

    public MapStorageTest() {
        super(new MapStorage());
    }

    @Override
    @Ignore
    @Test
    public void saveOverflow() throws Exception {
        super.saveOverflow();
    }

    @Override
    @Ignore
    @Test
    public void getAll() throws Exception {
       //empty
    }
}

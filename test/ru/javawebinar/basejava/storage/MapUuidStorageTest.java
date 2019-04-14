package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class MapUuidStorageTest extends AbstractArrayStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
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

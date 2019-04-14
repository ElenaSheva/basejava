package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;


public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int count = 3; count < AbstractArrayStorage.STORAGE_LIMIT; count++) {
                storage.save(new Resume("fullName" + count));
            }
        } catch (StorageException e) {
            Assert.fail("saveOverflow(): Error in fill Array");
        }
        storage.save(new Resume("fullName"));
    }
}
package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());

    }

    @Test
    public void update() throws Exception {
        Resume resumeToUpdate = new Resume(UUID_1);
        storage.update(resumeToUpdate);
        Assert.assertEquals(resumeToUpdate, storage.get(UUID_1));
        Assert.assertTrue(resumeToUpdate == storage.get(UUID_1));

    }

    @Test
    public void getAll() throws Exception {
        Resume[] resumes = storage.getAll();
        Assert.assertTrue(resumes.length == 3);
        Assert.assertEquals(resumes[0], RESUME_1);
        Assert.assertEquals(resumes[1], RESUME_2);
        Assert.assertEquals(resumes[2], RESUME_3);
    }

    @Test
    public void save() throws Exception {
        Resume resumeToSave = new Resume("uuid4");
        storage.save(resumeToSave);
        Assert.assertTrue(storage.size() == 4);
        Assert.assertEquals(resumeToSave, storage.get(resumeToSave.getUuid()));

    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        Resume resumeExist = storage.get(UUID_1);
        storage.save(resumeExist);
    }

    @Test
    public void delete() throws Exception {
        storage.delete(UUID_3);
        Assert.assertTrue(storage.size() == 2);

    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        Resume resumeNotExist = new Resume("uuidNotExist");
        storage.delete(resumeNotExist.getUuid());
    }

    @Test
    public void get() throws Exception {
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
        Assert.assertEquals(RESUME_2, storage.get(UUID_2));
        Assert.assertEquals(RESUME_3, storage.get(UUID_3));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int count = 3; count < AbstractArrayStorage.STORAGE_LIMIT; count++) {
                StringBuilder stringBuilderUuid = new StringBuilder("uuid_").append(count);
                storage.save(new Resume(stringBuilderUuid.toString()));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume());
    }
}
package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillRemoveElement(int index) {
        int numberElementToMove = size - index - 1;
        if (numberElementToMove > 0) {
            System.arraycopy(storage, index + 1, storage, index, numberElementToMove);
        }
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        if (index < 0) {
            // this is a new value to insert (not a duplicate).
            index = -index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

}
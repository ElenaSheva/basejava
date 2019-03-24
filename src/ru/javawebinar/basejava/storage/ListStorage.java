package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int count = 0; count < listResume.size(); count++) {
            if (uuid.equals(listResume.get(count).getUuid())) {
                return count;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        listResume.set(searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        listResume.add(resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        listResume.remove(searchKey.intValue());
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return listResume.get(searchKey);
    }

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return listResume.toArray(new Resume[listResume.size()]);
    }

    @Override
    public int size() {
        return listResume.size();
    }
}

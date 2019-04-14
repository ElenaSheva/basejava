package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();


    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapResume.containsKey((String) searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        mapResume.replace((String) searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Object searchKey) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object searchKey) {
        mapResume.remove((String) searchKey);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return mapResume.get((String) searchKey);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return Collections.emptyList();
    }


    @Override
    public int size() {
        return mapResume.size();
    }
}

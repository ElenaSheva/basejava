package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Integer getSearchKey(String uuid);
    protected abstract boolean isExist(Integer searchKey);
    protected abstract void doUpdate(Resume resume, Integer searchKey);
    protected abstract void doSave(Resume resume, Integer searchKey);
    protected abstract void doDelete(Integer searchKey);
    protected abstract Resume doGet(Integer searchKey);

    public void update(Resume resume) {
        Integer searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public void save(Resume resume) {
        Integer searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void delete(String uuid) {
        Integer searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    public Resume get(String uuid) {
        Integer searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);

    }

    public Integer getExistedSearchKey(String uuid) {
        Integer searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    public Integer getNotExistedSearchKey(String uuid) {
        Integer searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}

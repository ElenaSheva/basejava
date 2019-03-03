/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private  Resume[] storage = new Resume[10_000];
    private  int sizeOfStorage = 0;

    public void clear() {
        for (int сount = 0; сount < sizeOfStorage; сount++) {
            storage[сount] = null;
        }
        sizeOfStorage = 0;
    }

    public void update(Resume resumeToUpdate) {
        int index = getIndex(resumeToUpdate.getUuid());
        if (index != -1) {
            storage[index] = resumeToUpdate;
        } else {
            System.out.println("Resume '" + resumeToUpdate.getUuid() + "' not exist in Array!");
        }
    }

    public void save(Resume resumeToSave) {
        if (sizeOfStorage == storage.length) {
            System.out.println("Array is full!");
        } else {
            if (getIndex(resumeToSave.getUuid()) == -1) {
                storage[sizeOfStorage] = resumeToSave;
                sizeOfStorage++;
            } else {
                System.out.println("Resume '" + resumeToSave.getUuid() + "' exist in Array!");
            }
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Resume '" + uuid + "' not exist in Array!");
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[sizeOfStorage - 1];
            storage[sizeOfStorage - 1] = null;
            sizeOfStorage--;
        } else {
            System.out.println("Resume '" + uuid + "' not exist in Array!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] temp = new Resume[sizeOfStorage];
        System.arraycopy(storage, 0, temp, 0, sizeOfStorage);
        return temp;
    }

    public int size() {
        return sizeOfStorage;
    }

    private int getIndex(String uuid) {
        if (uuid == null) {
            return -1;
        }
        for (int сount = 0; сount < sizeOfStorage; сount++) {
            if (uuid.equals(storage[сount].getUuid())) {
                return сount;
            }
        }
        return -1;
    }
}

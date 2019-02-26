/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int MAX_STORAGE_SIZE = 10_000;
    Resume[] storage = new Resume[MAX_STORAGE_SIZE];
    int sizeOfStorage = 0;

    void clear() {
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            storage[lCount] = null;
        }
        sizeOfStorage = 0;
    }

    void save(Resume resumeToSave) {
        if (sizeOfStorage == MAX_STORAGE_SIZE - 1){
            System.out.println("Array is full!");
        } else {
            if (resumeToSave.uuid != null){
                if (getIndex(resumeToSave.uuid) != -1){
                    System.out.println("Resume exist in Array!");
                } else {
                    storage[sizeOfStorage] = resumeToSave;
                    sizeOfStorage++;
                }
            } else {
                System.out.println("uuid is null! No save!");
            }
        }

    }

    Resume get(String uuid) {
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            if (uuid.equals(storage[lCount].uuid)){
                return storage[lCount];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int lResumeIndex = getIndex(uuid);
        if (lResumeIndex != -1){
            storage[lResumeIndex] = storage[sizeOfStorage - 1];
            storage[sizeOfStorage - 1] = null;
            sizeOfStorage--;
        }
    }

    private int getIndex(String uuid) {
        if (uuid == null){
            return -1;
        }
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            if (uuid.equals(storage[lCount].uuid)){
                return lCount;
            }
        }
        return -1;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] temp = new Resume[sizeOfStorage];
        System.arraycopy(storage, 0, temp, 0, sizeOfStorage);
        return temp;
    }

    int size() {
        return sizeOfStorage;
    }
}

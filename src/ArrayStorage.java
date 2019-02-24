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

    void save(Resume r) {
        if (sizeOfStorage == MAX_STORAGE_SIZE){
            System.out.println("Array is full!");
        } else {
            if (r.uuid != null){
                if (get(r.uuid) != null){
                    System.out.println("Resume exist in Array!");
                } else {
                    storage[sizeOfStorage] = r;
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

    private int getIndex(String uuid){
        if (uuid == null){
            return -1;
        }
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            if (storage[lCount] != null){
                if (uuid.equals(storage[lCount].uuid)){
                    return lCount;
                }
            }
        }
        return -1;
    }

    void delete(String uuid) {
        int lResumeIndex = getIndex(uuid);
        if (lResumeIndex != -1){
            storage[lResumeIndex] = storage[sizeOfStorage - 1];
            storage[sizeOfStorage - 1] = null;
            sizeOfStorage--;
        }
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

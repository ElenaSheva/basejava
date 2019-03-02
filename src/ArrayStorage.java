/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    int sizeOfStorage = 0;

    void clear() {
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            storage[lCount] = null;
        }
        sizeOfStorage = 0;
    }

    void update(Resume resumeToUpdate) {
        int lIndex = getIndex(resumeToUpdate.uuid);
        if (lIndex != -1) {
            storage[lIndex] = resumeToUpdate;
            System.out.println("Resume '" + resumeToUpdate.uuid + "' is updated!");
        }
    }

    void save(Resume resumeToSave) {
        if (sizeOfStorage == storage.length){
            System.out.println("Array is full!");
        } else {
            if (getIndex(resumeToSave.uuid) == -1){
                storage[sizeOfStorage] = resumeToSave;
                sizeOfStorage++;
                System.out.println("Resume is saved!");
            }
        }

    }

    Resume get(String uuid) {
        int lIndex = getIndex(uuid);
        return lIndex == -1 ? null : storage[lIndex];
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
            System.out.println("uuid is null!");
            return -1;
        }
        for (int lCount = 0; lCount < sizeOfStorage; lCount++){
            if (uuid.equals(storage[lCount].uuid)){
                return lCount;
            }
        }
        System.out.println("Resume '" + uuid + "' not exist in Array!");
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

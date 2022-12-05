import java.util.Arrays;

public class MyArrayListInteger {
    private final Integer[] storage;
    private int size;

    public MyArrayListInteger() {
        storage = new Integer[10];
    }

    public MyArrayListInteger(int size) {
        storage = new Integer[size];
    }

    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    public Integer remove(int index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sortInsertion(storageCopy);
        return containsBinary(storageCopy, item);
    }

    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }


    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    public boolean containsBinary(Integer[] arr, Integer item) {
        int min = 0;
        int max = storage.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == storage[mid]) {
                return true;
            }

            if (item < storage[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void validateSize() {
        if (size == storage.length) {
            throw new StorageIsFullException();
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
}

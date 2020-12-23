package Lesson2;

public class MainArrayExceptionClass {
    public static void main(String[] args) {
        MyArray array = new MyArray(4, 4);
        String[][] arr1 = {
                {"123", "456", "7", "89"},
                {"569", "8522", "23658", "1"},
                {"856", "963", "789", "951"},
                {"563", "654", "896", "357"}};

        String[][] arr2 = {
                {"123", "456", "7", "89"},
                {"569", "8522"},
                {"856", "963", "789", "951"},
                {"563", "654", "896", "-357"}};
        String[][] arr3 = {
                {"123", "456", "7", "89"},
                {"569", "8522", "23658", "1"},
                {"856", "963", "789", "951"},
                {"56ь3", "654", "896", "357"}};
        String[][] arr4 = {
                {"12.3", "456", "7", "89"},
                {"569", "8522", "23658", "1"},
                {"856", "963", "789", "951"},
                {"56ь3", "654", "896", "357"}};

        System.out.println("Сумма элементов массива arr1 равна " + array.giveSumValue(arr1));
        System.out.println("arr2");
        try {
            System.out.println("Сумма элементов массива arr2 равна " + array.giveSumValue(arr2));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Сумма элементов массива arr3 равна " + array.giveSumValue(arr3));
        } catch (MyArrayDataException e) {
                e.printStackTrace();
        }

        try {
            System.out.println("Сумма элементов массива arr4 равна " + array.giveSumValue(arr4));
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

        }
}

package Lesson2;

public class MyArray {

    private int  i;
    private int j;
    private String [][] array;

    public MyArray(int i, int j) {
        this.i = i;
        this.j = j;
        array = new String[i][j];
    }
    public String[][] getArray(){

        return array;
    }

    public void setElementArray  (String[][] arr) throws MyArraySizeException{
        if (controleSizeArray(arr)){
            array = arr;
            System.out.println("Массив записался");
        } else {
            String message = "Размер массива не соответствует";
            throw new MyArraySizeException(message);
        }
    }

    public boolean controleSizeArray(String[][] arr){
        if(arr.length != i){
                return false;
            }
        for (int k = 0; k < arr.length; k++) {
                if(arr[k].length != j){
                    return false;
                }
            }
        return true;
    }

    public int getSumArray()throws MyArrayDataException{
        int sum = 0;
        for (int k = 0; k < array.length; k++) {
            for (int l = 0; l < array[k].length; l++) {
                try{
                    sum += Integer.parseInt(array[k][l]);
                } catch (NumberFormatException e){
                    String message = "Некорректные данные";
                    throw new MyArrayDataException(message, k, l);
                }
            }
        }
    return sum;
    }

    public int giveSumValue (String [][] arr) throws MyArraySizeException, MyArrayDataException {
        setElementArray(arr);
        return getSumArray();
    }
}

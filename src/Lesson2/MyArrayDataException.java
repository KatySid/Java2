package Lesson2;

public class MyArrayDataException extends NumberFormatException{
    private int i;
    private int j;
    private String numbCell = String.format("В ячейке [%d][%d] некорректные данные", i , j );

    public MyArrayDataException(String message, int i, int j) {
        super(String.format("%s данные в ячейке [%d][%d]", message, i, j));
        this.i = i;
        this.j = j;
    }

    public String getNumbCell() {
        return numbCell;
    }
}

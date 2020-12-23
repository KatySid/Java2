package Lesson1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.SQLOutput;

public class DayOfWeekMain {
    static int hoursWorkingWeek = 40; //число рабочих асов в неделю
    static int hoursWorkingDay = 8; // число рабочих часов в день
    static int dayWorkingWeek = 5; // число рабочих дней в неделе

   static int getWorkingHours (DayOfWeek dayOfWeek){
       int s = dayOfWeek.getNumber();
       int hours;
       if (s<=dayWorkingWeek && s > 0){
       hours = hoursWorkingWeek - (s-1)*hoursWorkingDay;
       }  else {
           hours = 0;
       }
        return hours;
    }
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("u");
        String dayOfWeeks = format.format(date);
        int today = Integer.parseInt(dayOfWeeks); //получаем значение дня недели в реальном времени

        switch (today){
            case 1: System.out.println("Осталось " + getWorkingHours(DayOfWeek.MONDAY)+" рабочих часов до конца недели");
            break;
            case 2: System.out.println("Осталось " + getWorkingHours(DayOfWeek.TUESDAY)+" рабочих часов до конца недели");
            break;
            case 3: System.out.println("Осталось " + getWorkingHours(DayOfWeek.WEDNESDAY)+" рабочих часов до конца недели");
            break;
            case 4: System.out.println("Осталось " + getWorkingHours(DayOfWeek.THURSDAY)+" рабочих часов до конца недели ");
            break;
            case 5: System.out.println("Осталось " + getWorkingHours(DayOfWeek.FRIDAY)+" рабочих часов до конца недели ");
            break;
            case 6: System.out.println("Сегодня выходной");
            break;
            case 7: System.out.println("Сегодня выходной");
            break;
            default:
                System.out.println("Ошибка");
                break;
        }

        // тут проверяем работу метода getWorkingHours()
       System.out.println(getWorkingHours(DayOfWeek.MONDAY));
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Calendar;

public class CalendarTask {
    private int                 yearNow;                        // год календаря
    private int                 monthNow;                       // месяц календаря
    private int                 dayNow;                         // день календаря
    private ArrayList<Holiday>  holidays;                       // для хранения праздников
    private Calendar            calendar;

    // конструктор
    CalendarTask(){
        calendar = Calendar.getInstance();
        holidays = new ArrayList<>();
        getNowCalendar();
    }

    private void getNowCalendar(){
        yearNow = calendar.get(Calendar.YEAR);
        monthNow = calendar.get(Calendar.MONTH);
        dayNow = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // добавить праздник
    protected void addHoliday(String nameHoliday, int year, int month, int day) throws Exception{
        if(year < yearNow)
            throw new Exception("Год праздника не может быть меньше текущей.");
        else if(month < monthNow)
            throw new Exception("Месяц праздника не может быть меньше текущего.");
        else
            holidays.add(new Holiday(nameHoliday, year, month, day));
    }

    // есть ли сегодня праздник
    protected void isHoliday(){
        boolean isHoliday = false;
        if(!holidays.isEmpty()){
            for(Holiday holiday : holidays){
                if(isSame(holiday.getYearHoliday(), holiday.getMonthHoliday(), holiday.getDayHoliday())) {
                    isHoliday = true;
                    System.out.println("Сегодня " + getDateFormat(dayNow, monthNow, yearNow) + " " + holiday.getNameHoliday());
                }
            }
        }
        if(!isHoliday)
            System.out.println("Сегодня " + getDateFormat(dayNow, monthNow, yearNow) + " праздники отсутствуют.");
    }

    private boolean isSame(int yearHoliday, int monthHoliday, int dayHoliday){
        if(yearNow == yearHoliday && monthNow == monthHoliday && dayNow == dayHoliday)
            return true;
        else
            return false;
    }

    // расписание праздников в календаре
    protected void timetableHoliday(){
        if(!holidays.isEmpty()) {
            for (Holiday holiday : holidays)
                System.out.println(getDateFormat(dayNow, monthNow, yearNow) + " " + holiday.getNameHoliday());
        }
        else
            System.out.println("Отсутствуют праздники в календаре.");
    }

    private String getDateFormat(int day, int month, int year){
        return day + "." + month + "." + year;
    }

    private class Holiday{
        private String  nameHoliday;         // название праздника
        private int     yearHoliday;         // год праздника
        private int     monthHoliday;        // месяц праздника
        private int     dayHoliday;          // день праздника

        Holiday(String nameHoliday, int yearHoliday, int monthHoliday, int dayHoliday){
            this.nameHoliday    = nameHoliday;
            this.yearHoliday    = yearHoliday;
            this.monthHoliday   = monthHoliday;
            this.dayHoliday     = dayHoliday;
        }

        protected String getNameHoliday(){
            return nameHoliday;
        }

        protected int getYearHoliday(){
            return yearHoliday;
        }

        protected int getMonthHoliday(){
            return monthHoliday;
        }

        protected int getDayHoliday(){
            return dayHoliday;
        }
    }
}

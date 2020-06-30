package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        CalendarTask calendarTask = new CalendarTask();

        calendarTask.addHoliday("День рождения отца", 2020, 9, 10);
        calendarTask.addHoliday("День рождения матери", 2021, 10, 10);
        calendarTask.addHoliday("День рождения дочери", 2020, 11, 10);
        calendarTask.addHoliday("Конференция на тему Java", 2023, 04, 10);

        calendarTask.isHoliday();

        calendarTask.timetableHoliday();
    }
}

package com.company.note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

/**
 * В данном классе используется шаблон проектирования "Конструктор", когда не объявляется экземпляр класса, а
 * вызывается конструктор со всеми необходимыми параметрами, затем вызываются сеттеры (установка темы, даты, почты,
 * сообщения), а потом вызывается м-д builder() для геренерации объекта, который будет являться неизменным.
 */

public class Note implements Comparator<Note> {
    private Date date;
    private final String dateStr;
    private final String theme;
    private final String mail;
    private final String message;

    public static class Builder {
        private Date date;
        private String dateStr;
        private String theme;
        private String mail;
        private String message;

        public Builder(String value){
            try {
                if(value != null && value.length() != 0) {
                    dateStr = value;
                    //разделяем строку на день, месяц и год
                    date = new SimpleDateFormat("dd.MM.yyyy").parse(dateStr);
                }
                else {
                    date = new Date();
                    dateStr = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                }
            } catch (NullPointerException | ParseException ex) {
                ex.printStackTrace();
            }
        }

        public Builder theme(String value) {
            theme = value;
            return this;
        }

        public Builder mail(String value) {
            mail = value;
            return this;
        }

        public Builder message(String value) {
            message = value;
            return this;
        }

        public Note build(){
            return new Note(this);
        }

    }

    private Note(Builder builder) {
        this.date = builder.date;
        this.dateStr = builder.dateStr;
        this.theme = builder.theme;
        this.mail = builder.mail;
        this.message = builder.message;
    }

    public Date getDate(){
        return date;
    }

    /*
    public String getDate(){
        return this.dateStr;
    }
     */

    public String getTheme(){
        return this.theme;
    }

    public String getMail(){
        return this.mail;
    }

    public String getMessage(){
        return this.message;
    }

    @Override
    public int compare(Note o1, Note o2) {
        return o1.theme.compareTo(o2.theme);
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Note))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "[The Note]"   +
                "\nDATE:"      + this.dateStr +
                "\nTHEME:"     + this.theme +
                "\nMAIL:"      + this.mail +
                "\nMESSAGE:"   + this.message +
                "\n";
    }
}

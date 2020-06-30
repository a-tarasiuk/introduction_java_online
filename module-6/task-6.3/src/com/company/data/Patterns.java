package com.company.data;

import com.company.variable.CorrectPatterns;
import com.company.variable.PatternsMethod;

public enum Patterns implements CorrectPatterns, PatternsMethod {
    NAME{
        @Override
        public String getRegex(){
            return CORRECT_NAME_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.println("\n# Please, enter name.");
            msgLimitationsName();
        }

        private void msgLimitationsName(){
            System.out.println("- Name must contain only characters (eng, rus).");
        }

    },
    SURNAME{
        @Override
        public String getRegex(){
            return CORRECT_SURNAME_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.println("\n# Please, enter surname.");
            msgLimitationsSurname();
        }

        private void msgLimitationsSurname(){
            System.out.println("- Surname must contain only characters (eng, rus).");
        }
    },
    AGE{
        @Override
        public String getRegex(){
            return CORRECT_AGE_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.println("\n# Please, enter age.");
            msgLimitationsAge();
        }

        private void msgLimitationsAge(){
            System.out.println("- Age must contain only numbers (min - 17, max - 35 years old).");
        }

    },
    FACULTY{
        @Override
        public String getRegex(){
            return CORRECT_FACULTY_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.println("\n# Please, enter faculty.");
            msgLimitationsFaculty();
        }

        private void msgLimitationsFaculty(){
            System.out.println("- Faculty can contain characters (eng, rus), space characters, numbers and underscores \"_\".");
        }

    },
    COURSE {
        @Override
        public String getRegex(){
            return CORRECT_COURSE_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.println("\n# Please, enter course number.");
            msgLimitationsCourse();
        }

        private void msgLimitationsCourse(){
            System.out.println("Information:" +
                    "\n- Course number must contain only numbers." +
                    "\n- Max value: 1"+
                    "\n- Min value: 5");
        }

    },
    ACCESS_LEVEL{
        @Override
        public String getRegex(){
            return null;
        }

        @Override
        public void getMsg(){
            System.out.print("\n# Please, choose access level.");
            System.out.println("\n- Administrator can editing and creating cases;");
            System.out.println("- User can view only cases;");
        }
    },
    LOGIN{
        @Override
        public String getRegex(){
            return CORRECT_LOGIN_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.print("\n# Please, enter login.");
            msgLoginCanContain();
        }

        private void msgLoginCanContain(){
            // Логин может содержать любой символ, кроме буквенного, цифрового и знака подчеркивания
            System.out.println("\n- Login can contain letters (eng), numbers and underscore.");
        }
    },
    PASSWORD{
        @Override
        public String getRegex(){
            return CORRECT_PASSWORD_PATTERN;
        }

        @Override
        public void getMsg(){
            System.out.print("\n# Please, enter password.");
            msgPasswordCannotContain();
        }

        private void msgPasswordCannotContain(){
            // Логин может содержать любой символ, кроме буквенного, цифрового и знака подчеркивания
            System.out.println("\n- Password cannot contain space character.");
        }
    };
}

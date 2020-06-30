package com.company;

public class Main {

    public static void main(String[] args) {
        int     valueRegion,            // выбор пользователя
                valueDistrict,          // выбор пользователя
                objRegion,              // порядковый номер объекта (будет равен value - 1, т.к. нумерация объектов начинается с нуля
                objDistrict;            // порядковый номер объекта (будет равен value - 1, т.к. нумерация объектов начинается с нуля
        boolean exit = true;

        Message     message = new Message();
        SwitchCase  sc      = new SwitchCase();

        // STEP 1
        message.getMessageStep1();
        State state = new State();

        // STEP 2
        message.getMessageStep2(state);
        state.setNumberRegion();

        // STEP 3
        message.getMessageStep3(state);

        // STEP 4
        for(int i = 0; i < state.getNumberRegion(); i++){
            message.getMessageStep4(i);
            state.addRegion();
        }

        // STEP 5
        message.getMessageStep5();

        // WHILE (ДОБАВЛЕНИЕ ОБЛАСТНЫХ ЦЕНТРОВ)
        while (true){
            // STEP 6
            message.getMessageStep6();

            message.getMessageQuit();
            message.getMessageInfRegionDistrict(state);

            valueRegion = sc.getChoice(state.getRegion().size());

            // проверяем, чтобы у каждой области был хотя бы один областной центр, иначе повтор цикла while
            if(valueRegion == 0) {
                exit = false;
                if(!exit){
                    for(int i = 0; i < state.getRegion().size(); i++){
                        if(state.getRegion().get(i).getDistrict().size() == 0) {
                            System.out.println("\n[ОШИБКА] В каждой области должен быть создан хотя бы 1 районный центр.");
                            exit = false;
                            break;
                        }
                        exit = true;
                    }
                }
                if(exit) break;
            }
            else {
                objRegion = valueRegion - 1;
                // STEP 7
                message.getMessageStep7(state, objRegion);
                // STEP 8
                message.getMessageStep8();
                state.getRegion().get(objRegion).setNumberDistrict();
                for(int i = 0; i < state.getRegion().get(objRegion).getNumberDistrict(); i++){
                    // STEP 9
                    message.getMessageStep9(i);
                    state.getRegion().get(objRegion).addDistrict();
                }
                //STEP 10
                message.getMessageStep10();
            }
        }

        // STEP 11
        message.getMessageStep11();

        while (true){
            // STEP 12
            message.getMessageStep12();
            message.getMessageQuit();
            message.getMessageInfRegionTown(state);
           /*
            for(int i = 0; i < state.getRegion().size(); i++)
                System.out.println((i+1) + ". " + state.getRegion().get(i).getName());
             */

            valueRegion = sc.getChoice(state.getRegion().size());

            //проверка, чтобы в каждом районе был хотя бы один город
            if(valueRegion == 0) {
                exit = false;
                for (int i = 0; i < state.getRegion().size(); i++) {
                    for (int j = 0; j < state.getRegion().get(i).getDistrict().size(); j++) {
                        if (state.getRegion().get(i).getDistrict().get(j).getTown().size() == 0) {
                            System.out.println("\n[ОШИБКА] В каждом районном центре должен быть создан хотя бы 1 город.");
                            i = state.getRegion().size();
                            exit = false;
                            break;
                        }
                        exit = true;
                    }
                }
                if(exit) break;
            }
            else {
                objRegion = valueRegion - 1;

                // STEP 7
                message.getMessageStep7(state, objRegion);

                // STEP 13
                message.getMessageStep13();
                for(int i = 0; i < state.getRegion().get(objRegion).getDistrict().size(); i++)
                    System.out.println((i+1) + ". " + state.getRegion().get(objRegion).getDistrict().get(i).getName());

                valueDistrict = sc.getChoiceWithoutZero(state.getRegion().get(objRegion).getDistrict().size());
                objDistrict = valueDistrict - 1;

                // STEP 14
                message.getMessageStep14(state, objRegion, objDistrict);

                // STEP 15
                message.getMessageStep15();
                state.getRegion().get(objRegion).getDistrict().get(objDistrict).setNumberTown();

                for(int i = 0; i < state.getRegion().get(objRegion).getDistrict().get(objDistrict).getNumberTown(); i++) {
                    message.getMessageStep16(i);
                    state.getRegion().get(objRegion).getDistrict().get(objDistrict).addTown();

                    // ЕСЛИ СТОЛИЦА ЕЩЁ НЕ ВЫБРАНА
                    if(!state.ifTheCapital()){
                        state.getRegion().get(objRegion).getDistrict().get(objDistrict).getTown().get(i).setCapital();
                    }


                }
            }
        }
        // STEP 17
        message.getMessageStep17();
        message.getMessageAllStructure(state);
    }
}

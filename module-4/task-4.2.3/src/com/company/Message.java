package com.company;

public class Message {
    public void getMessageStep1(){
        System.out.print("У вас сейчас нету государства. Давай его создадим." +
                "\n[СПРАВОЧНО] Название государства не может быть пустым полем.\n" +
                "\n- Введите название государства: ");
    }

    public void getMessageStep2(State state){
        System.out.print("\nПоздравляю тебя, ты создал государство \"" + state.getName() + "\"!" +
                "\nПлощадь твоего государства сейчас равняется " + state.getSquare() + " кв. километров." +
                "\n[СПРАВОЧНО] Как известно, любое государство состоит из областей, которые включают районы. Районы, в свою очередь, включают в себя города." +
                "\nГосударство -> Области -> Районы -> Города" +
                "\nЧтобы расширить границы своего государства, сначала создадим области.\n" +
                "\n- Сколько областей будет в твоем государстве: ");
    }

    public void getMessageStep3(State state){
        System.out.println("\nХорошо, в твоем государстве есть области, их " + state.getNumberRegion() + "." +
                "\nТеперь придумаем им названия:");
    }

    public void getMessageStep4(int i){
        System.out.print("\n- Область [" + (i+1) + "] будет называться: ");
    }

    public void getMessageStep5(){
        System.out.println("\nТеперь области созданы." +
                "\nНужно добавить в каждую область районные центры." +
                "\nИх может быть один или несколько.");
    }

    public void getMessageStep6(){
        System.out.println("\nВ какую область будем добавлять районные центры? Сделайте выбор:");
    }

    public void getMessageStep7(State state, int value){
        System.out.println("\nВы выбрали область с названием: " + state.getRegion().get(value).getName());
    }

    public void getMessageStep8(){
        System.out.print("Сколько районных центров будем добавлять: ");
    }

    public void getMessageStep9(int i){
        System.out.print("\n- Районный центр [" + (i+1) + "] будет называться: ");
    }

    public void getMessageStep10(){
        System.out.println("\nОтлично. Районные центры созданы.");
    }

    public void getMessageStep11(){
        System.out.println("\nОтлично!\nОстался последний шаг - добавление городов.");
    }

    public void getMessageStep12(){
        System.out.println("\nВыбери область, в которую нужно добавить город:");
    }

    public void getMessageStep13(){
        System.out.println("\nВыбери районный центр, в который нужно добавить город:");
    }

    public void getMessageStep14(State state, int objRegion, int objDistrict){
        System.out.println("\nВы выбрали районный центр с названием: " + state.getRegion().get(objRegion).getDistrict().get(objDistrict).getName());
    }

    public void getMessageStep15(){
        System.out.print("\nСколько городов будем добавлять: ");
    }

    public void getMessageStep16(int i){
        System.out.print("\n- Город [" + (i+1) + "] будет называться: ");
    }

    public void getMessageStep17(){
        System.out.println("\nПоздравляю, твоё государство создано!");
    }

    public void getMessageInfRegionDistrict(State state){
        for (int i = 0; i < state.getRegion().size(); i++)
            System.out.format("%1d. %-20s | %s %d\n", (i+1), state.getRegion().get(i).getName(), "Кол-во районных центров: ", state.getRegion().get(i).getDistrict().size());
    }

    public void getMessageInfRegionTown(State state){
        for (int i = 0; i < state.getRegion().size(); i++){
            int sumTown = 0;
            for(int j = 0; j < state.getRegion().get(i).getDistrict().size(); j++)
                sumTown += state.getRegion().get(i).getDistrict().get(j).getTown().size();
            System.out.format("%1d. %-20s | %s %-3d | Кол-во городов: %-3d\n", (i+1), state.getRegion().get(i).getName(), "Кол-во районных центров: ", state.getRegion().get(i).getDistrict().size(), sumTown);
        }

    }

    public void getMessageAllStructure(State state){
        System.out.println("\nОбщая площадь государства: " + state.getSquare() + " кв.км.");
        System.out.println("Состоит из областей:");
        for(int i = 0; i < state.getRegion().size(); i++) {
            System.out.println((i + 1) + ". " + state.getRegion().get(i).getName() +
                    " (площадь: " + state.getRegion().get(i).getSquare() + " кв.км.)");
            System.out.println("\t- Включает районные центры:");
            for(int j = 0; j < state.getRegion().get(i).getDistrict().size(); j++) {
                System.out.println("\t" + (i+1) + "." + (j + 1) + ". " + state.getRegion().get(i).getDistrict().get(j).getName() +
                        " (площадь: " + state.getRegion().get(i).getDistrict().get(j).getSquare() + " кв.км.)");
                System.out.println("\t\t- Включает города:");
                for(int k = 0; k < state.getRegion().get(i).getDistrict().get(j).getTown().size(); k++) {
                    System.out.print("\t\t" + (i + 1) + "." + (j + 1) + "." + (k + 1) + ". " + state.getRegion().get(i).getDistrict().get(j).getTown().get(k).getName() +
                            " (площадь: " + state.getRegion().get(i).getDistrict().get(j).getTown().get(k).getSquare() + " кв.км.)");
                    if(state.getRegion().get(i).getDistrict().get(j).getTown().get(k).getCapital())
                        System.out.println(" - СТОЛИЦА!");
                    else System.out.println("");
                }
            }
        }
    }

    public void getMessageQuit(){
        System.out.println("\n0. Выход (к следующему этапу)");
    }

}

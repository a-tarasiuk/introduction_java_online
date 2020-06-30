package com.company.data;

public enum Path {
    ACCOUNTS("db_accounts.xml", "ACCOUNTS", "USER"),
    STUDENTS("db_students.xml", "STUDENTS", "PERSON");

    private final String path = "./src/com/company/database/";
    private final String databaseFileName;
    private final String nameRootElement;
    private final String nameMainElement;

    Path(String databaseFileName, String nameRootElement, String nameMainElement){
        this.databaseFileName = databaseFileName;
        this.nameRootElement = nameRootElement;
        this.nameMainElement = nameMainElement;
    }

    public String getNameRootElement(){
        return nameRootElement;
    }

    public String getNameMainElement(){
        return this.nameMainElement;
    }

    @Override
    public String toString(){
        return this.path + this.databaseFileName;
    }
}

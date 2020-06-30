package com.company.data;

public enum PathDatabase {
    ACCOUNTS("db_accounts.txt"),
    BOOKS("db_books.txt");

    private final String path = "./src/com/company/databases/";
    private final String databaseFileName;

    PathDatabase(String databaseFileName){
        this.databaseFileName = databaseFileName;
    }

    @Override
    public String toString(){
        return this.path + this.databaseFileName;
    }
}

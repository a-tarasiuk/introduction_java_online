package com.company;

import java.util.*;

public class Directory {
    private String          name;
    private String          prefix = "";
    private List<Directory> directoryList = new ArrayList<>();
    private List<File>      fileList = new ArrayList<>();

    protected Directory add(File file){
        fileList.add(file);
        return this;
    }

    protected Directory add(Directory directory){
        checkDirectory(directory);
        directoryList.add(directory);
        return this;
    }

    private void checkDirectory(Directory directory){
        checkThisDirectory(directory);
        checkDirectoryList(directory);
    }

    private void checkThisDirectory(Directory directory){
        if(this == directory)
            throw new IllegalArgumentException("Неверная директория!");
    }

    private void checkDirectoryList(Directory directory){
        for(Directory d : directoryList){
            if(d == directory)
                throw new IllegalArgumentException("Неверная директория!");
            d.checkDirectoryList(directory);
        }
    }

    protected void deleteFile(File file){
        fileList.remove(file);
    }

    private String getName(){
        return name;
    }

    private List<Directory> getDirectoryList(){
        return directoryList;
    }

    private List<File> getFileList(){
        return fileList;
    }

    protected void getStructure(){
        System.out.println("\nСтруктура каталогов:");
        Deque<Directory> stack = new ArrayDeque<>();

        for(Directory dir : directoryList) {
            dir.setPrefix(this.getName() + "\\");
            stack.add(dir);
        }

        while (!stack.isEmpty()){
            Directory dir = stack.pollFirst();

            if(!dir.getDirectoryList().isEmpty()) {      // если внутри папки если ещё папки
                for(Directory sub : dir.getDirectoryList()) {
                    sub.setPrefix(dir.toString() + "\\");
                    stack.add(sub);
                }
            }
            else {
                if(!dir.getFileList().isEmpty())     // если внутри дерриктории присутствуют ещё и файлы
                    for(File file : dir.getFileList()) {
                        System.out.println(dir + "\\" + file.getName() + file.getTypeFile());
                    }
                else
                    System.out.println(dir);
            }
        }
    }

    protected void setPrefix(String prefix){
        this.prefix = prefix;
    }

    @Override
    public String toString(){
        return this.prefix + this.getName();
    }

    public Directory(String name){
        this.name = name;
    }

}

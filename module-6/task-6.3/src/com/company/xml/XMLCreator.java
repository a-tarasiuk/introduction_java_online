package com.company.xml;

import com.company.data.Path;
import com.company.data.Patterns;
import com.company.variable.GeneralObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLCreator {
    private final Path path;
    private Document document;
    private Element rootElement;
    private Element mainElement;
    private List<Element> mainElements;
    private List<Element> searchElement;

    public XMLCreator(Path path){
        this.path = path;
    }

    // START
    public void createDocument(){
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            document = saxBuilder.build(path.toString());
            // если в БД уже имелись данные, то выполняет код ниже (иначе - переход к блоку catch)
            rootElement = document.getRootElement();
            mainElements = rootElement.getChildren();
            // устанавливаем главный элемент
            mainElement = new Element(path.getNameMainElement());
        } catch (JDOMException e) {
            // если XML файл пустой - создать его с нуля
            createNewDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // создание новой структуры XML документа с нуля
    public void createNewDocument(){
        document = new Document();
        rootElement = new Element("DATABASE_" + path.getNameRootElement());
        document.setRootElement(rootElement);
        mainElements = new ArrayList<>();
    }

    public void addChildrenElements(GeneralObject obj){
        // устанавливаем главный элемент
        mainElement = new Element(path.getNameMainElement());
        // добавляем дочерние элементы в главный элемент
        obj.getChildrenElements().forEach((key, value) -> mainElement.addContent(new Element(key).setText(value)));
        document.getRootElement().addContent(mainElement);
    }

    // точный поиск
    public boolean isFoundExactSearch(String value){
        for(Element e1 : this.mainElements) {
            List<Element> childrenElements = e1.getChildren();
            for(Element e2 : childrenElements){
                if(e2.getText().equals(value)) {
                    this.searchElement = childrenElements;
                    return true;
                }
            }
        }
        return false;
    }

    // поиск со вхождениями (например "ja" содержится в "jake" - true)
    public boolean isFoundEntrySearch(String value){
        for(Element e1 : this.mainElements) {
            List<Element> childrenElements = e1.getChildren();
            for(Element e2 : childrenElements){
                if(e2.getText().toLowerCase().matches(patternSearchWord(value))) {
                    this.searchElement = childrenElements;
                    return true;
                }
            }
        }
        return false;
    }

    // поиск элементов по ключу
    public List<Element> getSearchElements(List<Element> elements, Patterns key, String value){
        List<Element> foundElements = new ArrayList<>();
        for(Element e1 : elements){
            List<Element> children = e1.getChildren();
            for(Element e2 : children) {
                if(e2.getName().equals(key.toString()) && e2.getText().toLowerCase().matches(patternSearchWord(value)))
                    foundElements.add(e1);
            }
        }
        return foundElements;
    }

    // поиск вхождения слова в предложении
    public String patternSearchWord(String word){
        return "(\\w*)(" + word.toLowerCase() + ")(\\w*)";
    }

    public String getValueByNameElement(Patterns searchNameElement){
        for(Element e1 : this.searchElement){
            if(e1.getName().equalsIgnoreCase(searchNameElement.toString()))
                return e1.getValue();
        }
        return null;
    }

    public List<Element> getMainElements(){
        return this.mainElements;
    }

    public void writeInXML(){
        // документ JDOM сформирован и готов к записи в файл
        XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
        // сохраняем в файл
        try{
            // записываем в файл
            xmlOutputter.output(document, new FileOutputStream(path.toString(), false));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

package com.company;

import java.util.ArrayList;

public class Payment {
    {id++;}

    private static  int         id;             // id платежа
    private         int         totalCost;      // общая сумма платежа
    private ArrayList<Product>  products;       // массив продуктов (размер задается через конструктор)

    // добавить продукт
    protected void addProduct(String name, int cost){
        products.add(new Product(name, cost));
    }

    // получить информацию о покупке
    protected void getInformation(){
        for(Product product : products) {
            System.out.println(product.toString());
            totalCost += product.getCost();
        }
        System.out.println("\nОбщая сумма по платежу: $" + totalCost);
    }

    // конструктор
    Payment(){
        products = new ArrayList<>();
    }

    private class Product {
        private String  name;
        private int     cost;

        protected int getCost(){
            return cost;
        }

        @Override
        public String toString(){
            return  "\nID покупки: " + id +
                    "\nНаименование товара: " + name +
                    "\nСтоимость: $" + cost;
        }

        Product(String name, int cost){
            this.name = name;
            this.cost = cost;
        }
    }
}

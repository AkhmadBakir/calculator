package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        String value = "";

        while (true) {

            System.out.print("Введите значение выражения: ");

            value = scanner.nextLine();

            if (value.equals("quit")) {
                System.out.println("Завершение работы программы");
                break;
            } else if (value.matches("x[1-5] = .*")) {
                calculator.setVariables(value);
            } else {
                try {
                    String[] valueArray = value.split(" ");
                    System.out.println("Значение выражения: " + calculator.result(valueArray));
                } catch (NoSuchElementException e) {
                    System.out.println("Выражение содержит ошибку");
                } catch (NullPointerException e) {
                    System.out.println("Значение переменной не определено");
                }
            }
        }
    }

}
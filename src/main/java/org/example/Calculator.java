package org.example;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Integer> variables = new HashMap<>();

    public Calculator() {
        this.variables.put("x1", null);
        this.variables.put("x2", null);
        this.variables.put("x3", null);
        this.variables.put("x4", null);
        this.variables.put("x5", null);
    }

    public void setVariables(String value) {
        String[] arrayString = value.split(" ");
        variables.put(arrayString[0], result(Arrays.copyOfRange(arrayString, 2, arrayString.length)));
    }

    public int result(String[] value) {
        int first = 0, second = 0;
        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();
        for (int i = 0; i < value.length; i++) {
            String s = value[i];
            if (s.matches("\\d+")) {
                queueNumbers.add(Integer.parseInt(s));
            } else if (s.matches("x[1-5]")) {
                queueNumbers.add(variables.get(s));
            } else {
                switch (s) {
                    case "+":
                        second = queueNumbers.removeLast();
                        first = queueNumbers.removeLast();
                        queueNumbers.add(first + second);
                        break;
                    case "-":
                        second = queueNumbers.removeLast();
                        first = queueNumbers.removeLast();
                        queueNumbers.add(first - second);
                        break;
                    case "*":
                        second = queueNumbers.removeLast();
                        first = queueNumbers.removeLast();
                        queueNumbers.add(first * second);
                        break;
                    case "/":
                        second = queueNumbers.removeLast();
                        first = queueNumbers.removeLast();
                        queueNumbers.add(first / second);
                        break;
                }
            }
        }
        return queueNumbers.getFirst();
    }

}

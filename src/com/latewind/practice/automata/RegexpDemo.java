package com.latewind.practice.automata;


import java.util.regex.Pattern;


public class RegexpDemo {
    static String patternStr = "\\s*(\\d+|[a-z_A-Z]+)|=|==";
    static Pattern pattern = Pattern.compile(patternStr);
    static String testString = " 1abc23";
    static char[] testChars = testString.toCharArray();
    static int index = 0;

    public static void testRegexp() {


    }


    public String read() {
        StringBuilder sb = new StringBuilder();
        int c;
        do {
            c = getChar();

        } while (isSpace(c));

        if (c < 0) {
            return null;
        } else if (isDigit(c)) {

            do {
                sb.append((char) c);
                c = getChar();
            } while (isDigit(c));
        }


        return sb.toString();
    }

    private boolean isSpace(int c) {
        return c == ' ';
    }

    private boolean isDigit(int c) {

        return '0' <= c && c <= '9';
    }

    private int getChar() {
        if (index < testChars.length) {

            return testChars[index++];
        }

        return -1;
    }

    public static void main(String[] args) {

        RegexpDemo rd = new RegexpDemo();
        String result;
        for (; (result = rd.read()) != null; ) {
            System.out.println(result);
        }

    }


}

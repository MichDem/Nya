package org.nya;

import java.io.PrintStream;

class Interpreter {
    private int i = 0;
    private final PrintStream output;

    Interpreter(PrintStream output) {
        this.output = output;
    }

    void forLine(String line) {
        for (char c : line.toCharArray()) {
            switch (c) {
                case 'n' -> i--;
                case 'y' -> i++;
                case 'a' -> output.print((char) i);
                case '~' -> i = 0;
                default -> {
                }
            }
        }
    }

    void fromText(String text) {
        for(char c : text.toCharArray()) {
            var code = (int) c;
            var res = 'n' + "y".repeat(code + 1) + 'a' + '~';
            output.println(res);
        }
    }
}

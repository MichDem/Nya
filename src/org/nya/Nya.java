package org.nya;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Nya {

    public static void main(String[] args) throws IOException {
        if(args.length != 2 && args.length != 4) {
            System.out.println("Use: <--interpret|--convert> file.nya [--output output.nya]");
            return;
        }

        File inputFile = new File(args[1]);
        if(!inputFile.exists()) {
            System.out.println("File not found");
            return;
        }

        PrintStream output = System.out;
        if(args.length == 4 && args[2].equals("--output"))
            output = new PrintStream(args[3]);
        var sc = new Scanner(inputFile);
        var interpreter = new Interpreter(output);
        if(args[0].equals("--interpret")){
            while(sc.hasNextLine())
                interpreter.forLine(sc.nextLine());
        } else if(args[0].equals("--convert")) {
            while(sc.hasNextLine())
                interpreter.fromText(sc.nextLine());
        }
    }
}

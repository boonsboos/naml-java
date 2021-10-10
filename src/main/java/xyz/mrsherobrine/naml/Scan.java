package xyz.mrsherobrine.naml;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Scan {

    private static List<Token> list;

    public static void main(String[] args) {
        try {
            File test = new File("test.naml");
            Scanner scanner = new Scanner(test);
            while (scanner.hasNextLine()) {

                list.add(Tokenizer.assignToken(scanner.next()));

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<>();
        //loop over the list, then map things correctly

    }

}

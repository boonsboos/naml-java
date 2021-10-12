package xyz.mrsherobrine.naml;

import xyz.mrsherobrine.naml.exception.MalformedNamlException;
import xyz.mrsherobrine.naml.token.Token;
import xyz.mrsherobrine.naml.token.TokenType;
import xyz.mrsherobrine.naml.token.Tokenizer;

import java.io.*;
import java.util.*;

public class Scan {

    private static List<Token> list = new ArrayList<>();

    public static void main(String[] args) {
        try {
            File test = new File("test.naml");

            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(test)));

                String s;
                int lineNr = 1;

                while ((s = br.readLine()) !=null) {
                s = s.stripLeading();
                    //System.out.println(s);
                    if (s.contains("=")) {

                        String s1 = s.substring(0, s.indexOf(" ="));

                        String s2 = s.substring(s.indexOf("= ")+2);

                        list.add(Tokenizer.keyValueToken(s1, lineNr, test.getName()));
                        list.add(Tokenizer.keyValueToken(s2, lineNr, test.getName()));

                    } else if (s.contains("{")) {
                        String s1 = s.substring(0, s.indexOf(" {"));
                        list.add(Tokenizer.keyValueToken(s1, lineNr, test.getName()));
                        list.add(Tokenizer.blockOpenToken());
                    } else if (s.matches("}")) {
                        list.add(Tokenizer.blockCloseToken());
                    } else {
                        throw new MalformedNamlException("Invalid naml found near: "+s);
                    }
                    lineNr++;

                }

        } catch (IOException | MalformedNamlException e ) {
            e.printStackTrace();
        }

        Map<String, Object> map = new LinkedHashMap<>();
        int depthIndex = 0;
        for (int i=0; i< list.size(); i++) {
            if (list.get(i+1).getType() == TokenType.BLOCK_OPEN && depthIndex == 0) {
                map.put((String) list.get(i).getValue(), new LinkedHashMap<String, Object>());
                depthIndex = i;
            } else if (depthIndex > 0 && map.get(list.get(depthIndex).getValue()) instanceof LinkedHashMap) {
                map.get(list.get(depthIndex).getValue()).put()
            } else {
                map.put((String) list.get(i).getValue(), list.get(i + 1).getValue());
            }
            i++;
        }


        map.forEach((k, v) ->   System.out.println(k +":"+ map.get(k).toString()));

    }

}
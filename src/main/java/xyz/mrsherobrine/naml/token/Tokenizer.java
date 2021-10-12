package xyz.mrsherobrine.naml.token;

import xyz.mrsherobrine.naml.exception.MalformedNamlException;

public class Tokenizer {

    public static Token keyValueToken(String input, int lineNr, String filename) throws MalformedNamlException {

        if (input.matches("(\\d\\.\\d)")) {
            return new Token(TokenType.DOUBLE, input);
        } else if (input.matches("\\d")) {
            return new Token(TokenType.INTEGER, input);
        } else if (input.matches("\".+\"")) {
            return new Token(TokenType.STRING, input);
        } else if (input.matches("[y]")) {
            return new Token(TokenType.BOOL_TRUE, input);
        } else if (input.matches("[n]")) {
            return new Token(TokenType.BOOL_FALSE, input);
        } else if (input.matches("[a-zA-Z0-9_-]+")) {
            return new Token(TokenType.KEY, input);
        }  else {
            throw new MalformedNamlException("Encountered malformed naml at line "+lineNr+" in file "+filename+": "+input);
        }

    }

    public static Token blockOpenToken() throws MalformedNamlException {

        return new Token(TokenType.BLOCK_OPEN, "{");

    }

    public static Token blockCloseToken() {
        return new Token(TokenType.BLOCK_CLOSE, "}");
    }

}
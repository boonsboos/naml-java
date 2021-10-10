package xyz.mrsherobrine.naml;

public class Tokenizer {

    public static Token assignToken(String input) {

        if (input.matches("=")) {
            return new Token(TokenType.DECLARATION, input);
        } else if (input.matches("[0-9].[0-9]")) {
            return new Token(TokenType.DOUBLE, input);
        } else if (input.matches("[0-9]")) {
            return new Token(TokenType.INTEGER, input);
        } else if (input.matches("[{]")) {
            return new Token(TokenType.BLOCK_OPEN, input);
        } else if (input.matches("}")) {
            return new Token(TokenType.BLOCK_CLOSE, input);
        } else if (input.contains("\"")) {
            return new Token(TokenType.STRING, input);
        } else if (input.matches("y")) {
            return new Token(TokenType.BOOL_TRUE, input);
        } else if (input.matches("n")) {
            return new Token(TokenType.BOOL_FALSE, input);
        } else {
            return new Token(TokenType.VALUE_NAME, input);
        }

    }

}
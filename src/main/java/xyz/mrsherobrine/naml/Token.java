package xyz.mrsherobrine.naml;

public class Token {

    private final TokenType type;
    private final Object value;

    public Token(final TokenType type, final Object value) {
        this.type= type;
        this.value = value;
        System.out.println(type + " " + value);
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

}
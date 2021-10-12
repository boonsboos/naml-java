package xyz.mrsherobrine.naml.token;

public class Token {

    private final TokenType type;
    private final Object value;

    public Token(final TokenType type, final Object value) {
        this.type= type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token( "+type+", "+value+" )";
    }

}
package xyz.mrsherobrine.naml;

public class Token {

    private final NamlValue value;
    private final TokenType type;

    public Token(final NamlValue value, final TokenType type) {
        this.value = value;
        this.type= type;
    }

    public NamlValue getValue() {
        return value;
    }

    public TokenType getType() {
        return type;
    }

}

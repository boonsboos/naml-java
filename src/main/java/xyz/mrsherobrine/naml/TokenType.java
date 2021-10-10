package xyz.mrsherobrine.naml;

public enum TokenType {

    BLOCK_OPEN,     // {
    BLOCK_CLOSE,   // }
    BLOCK_NAME,
    DECLARATION,   // =
    VALUE_NAME,
    DOUBLE,
    INTEGER,
    STRING,
    STRING_OPEN, // "
    STRING_CLOSE, // "
    BOOL_TRUE, // y
    BOOL_FALSE; // n

}

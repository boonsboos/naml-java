package xyz.mrsherobrine.naml;

public enum TokenType {

    BLOCK_OPEN,     // {
    BLOCK_CLOSE,   // }
    DECLARATION,   // =
    VALUE_NAME,
    DOUBLE,
    INTEGER,
    STRING,
    BOOL_TRUE, // y
    BOOL_FALSE; // n

}

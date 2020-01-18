package token;

import java.util.Objects;

public class Token {


    String text;
    int line;
    TokenType type;

    public Token(String text, int line, TokenType type) {
        this.text = text;
        this.line = line;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return text.equals(token.text) &&
                type == token.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, type);
    }
}

package token;

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
}

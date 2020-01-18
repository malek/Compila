package token;

public class KeywordToken extends Token {
    public KeywordToken(String text, int line) {
        super(text, line, TokenType.MOTCLE);
    }
}

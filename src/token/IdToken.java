package token;


public class IdToken extends Token {

    public IdToken(String text, int line)
    {
        super(text, line, TokenType.IDENT);
    }

}

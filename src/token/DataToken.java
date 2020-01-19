package token;


public class DataToken extends Token
{

    public DataToken(String text, int line)
    {
        super(text, line, TokenType.DATA);
    }


}

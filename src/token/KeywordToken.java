package token;



public class KeywordToken extends Token
{

    public static final KeywordToken START_PROGRAM = new KeywordToken("Start_Program", 0);
    public static final KeywordToken END_PROGRAM = new KeywordToken("End_Program", 0);
    public static final KeywordToken POINT_VIRGULE = new KeywordToken(";;", 0);
    public static final KeywordToken SHOW_MSG = new KeywordToken("ShowMes", 0);
    public static final KeywordToken SHOW_VAL = new KeywordToken("ShowVal", 0);
    public static final KeywordToken GIVE = new KeywordToken("Give", 0);
    public static final KeywordToken AFFECT = new KeywordToken("Affect", 0);
    public static final KeywordToken TO = new KeywordToken("to", 0);

    public KeywordToken(String text, int line)
    {
        super(text, line, TokenType.MOTCLE);
    }
}

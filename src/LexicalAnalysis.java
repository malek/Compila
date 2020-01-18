import token.KeywordToken;
import token.Token;
import token.TokenType;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LexicalAnalysis {
    String text;
    ArrayList<Token> tokens;

    public LexicalAnalysis() {
        this.text = "";
        this.tokens = new ArrayList<>();
    }

    public ArrayList<Token> getTokens() {
        performAnalysis();
        return tokens;
    }

    public void setTextCode(String text) {
        this.text = text;
    }
    public void performAnalysis(){
        this.tokens.add(new Token("Start_Program",1, TokenType.MOTCLE));
       // this.tokens.add(new KeywordToken("Start_Program",1));
        this.tokens.add(new Token("i",1, TokenType.IDENT));
        this.tokens.add(new Token("55",1, TokenType.DATA));
        this.tokens.add(new Token("=",1, TokenType.SYMBOL));
    }

}

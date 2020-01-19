import token.*;

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
        this.tokens.clear();
        performAnalysis();
        return tokens;
    }

    public void setTextCode(String text) {
        this.text = text;
    }

    public void performAnalysis() {
//        this.tokens.add(new KeywordToken("Start_Program",1));
//        this.tokens.add(new KeywordToken("Give",2));
//        this.tokens.add(new IdToken("i",2));
//        this.tokens.add(new SymbolToken(":",2));
//        this.tokens.add(new DataToken("23",2));
//        this.tokens.add(new KeywordToken(";;",2));
//        thi
//         s.tokens.add(new KeywordToken("End_Program",2));
//       // this.tokens.add(new KeywordToken("Start_Program",1));

        ArrayList<String> arr = split(text);

        System.out.println(arr.size() + " words to read");

        for (String s : arr) {
            if(s.length() == 0) continue;
            System.out.println(s);
           /* if(s.equals(KeywordToken.START_PROGRAM.getText())) {
                System.out.println("Add start");
                this.tokens.add(new KeywordToken("Start_Program",1));
            } else if (s.equals(KeywordToken.END_PROGRAM.getText()))
                this.tokens.add(new KeywordToken("End_Program",2));
            else if(s.equals(KeywordToken.END_PROGRAM.getText()))*/
            if (isKeyWord(s)) {
                this.tokens.add(new KeywordToken(s, 1));
            } else if (isSymbole(s)) {
                this.tokens.add(new SymbolToken(s, 1));
            } else if (isNumber(s)) {
                this.tokens.add(new DataToken(s, 1));
            } else if (isIdent(s)) {
                this.tokens.add(new IdToken(s, 1));
            } else if (isString(s)) {
                this.tokens.add(new DataToken(s, 1));
            }
        }


    }

    private boolean isString(String s) {
        if (s.length()<=0) return false;
        if (s.charAt(0) == '"' &&  s.charAt(s.length() - 1) == '"') {
            return true;
        } else return false;
    }

    private boolean isIdent(String s) {
        if (isDigit(s.charAt(0))) return false;//identificateur commnce par chifftre
        for (char c : s.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != '_')
                return false; //si il commnce par un symbole ou smthng other then number w lttre

        }
        return true;

    }

    private boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (!isDigit(c)) return false;
        }
        return true;
    }

    private boolean isDigit(char c) {
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }


    //haka bach za3ma tji more clean
    private boolean isSymbole(String s) {
        return s.equals(SymbolToken.COLUMN.getText())
                || s.equals(SymbolToken.COMMA.getText())
                || s.equals(SymbolToken.DBL_DASH.getText());
    }

    private boolean isKeyWord(String s) {
        return s.equals(KeywordToken.START_PROGRAM.getText())
                || s.equals(KeywordToken.END_PROGRAM.getText())
                || s.equals(KeywordToken.GIVE.getText())
                || s.equals(KeywordToken.SHOW_VAL.getText())
                || s.equals(KeywordToken.SHOW_MSG.getText())
                || s.equals(KeywordToken.AFFECT.getText())
                || s.equals(KeywordToken.INT_NUMBER.getText())
                || s.equals(KeywordToken.REAL_NUMBER.getText());
    }

    ArrayList<String> split(String text) {
        ArrayList<String> res = new ArrayList<>();

        char c = text.charAt(0);
        int i = 0;
        String mot = "";

        while (i < text.length()) {
            c = text.charAt(i);

            if (c == ' ' || c == '\n') {
                res.add("" + mot);
                mot = "";
            } else {
                mot = mot + c;
            }

            i++;
        }

        return res;
    }

}

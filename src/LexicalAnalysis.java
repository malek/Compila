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
    public void performAnalysis(){
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

        for(String s : arr)
        {
            System.out.println(s);
            if(s.equals(KeywordToken.START_PROGRAM.getText())) {
                System.out.println("Add start");
                this.tokens.add(new KeywordToken("Start_Program",1));
            } else if (s.equals(KeywordToken.END_PROGRAM.getText()))
                this.tokens.add(new KeywordToken("End_Program",2));
        }


    }

    ArrayList<String> split(String text) {
        ArrayList<String> res = new ArrayList<>();

        char c = text.charAt(0);
        int i = 0;
        String mot = "";

        while(i < text.length()) {
            c = text.charAt(i);

            if(c == ' ') {
                res.add(""+mot);
                mot = "";
            } else {
                mot = mot + c;
            }

            i++;
        }

        return res;
    }

}

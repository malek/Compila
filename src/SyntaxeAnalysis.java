import token.*;

import java.util.ArrayList;

public class SyntaxeAnalysis {
    ArrayList<Token> tokens;
    private int indice;

    public SyntaxeAnalysis() {
        this.tokens = new ArrayList<>();
        this.indice = 0;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
        this.indice = 0;
    }

    public void performSyntaxAnalysis() {
        if (currentTc().equals(KeywordToken.START_PROGRAM)) {
            nextTc();
            instruction();
            if (currentTc().equals(KeywordToken.END_PROGRAM))
                System.out.println("goood cooode cooongraraaaaaaaaaaa\n");
            else System.err.println("bad ending terararara !!!");
        } else System.err.println("bad starting :D ");
    }

    private void instruction() {
        if (currentTc().equals(KeywordToken.GIVE)) {
            nextTc();
            give();
        } else if (currentTc().equals(KeywordToken.SHOW_VAL)) {
            nextTc();
            showValeur();
        } else if (currentTc().equals(KeywordToken.SHOW_MSG)) {
            nextTc();
            showMessage();
        } else {
            // mot vde
        }
    }

    private void showMessage() {
        if (currentTc().equals(KeywordToken.SHOW_MSG)) {
            nextTc();
            if (currentTc().equals(SymbolToken.COLUMN)){
                nextTc();
                if (currentTc() instanceof DataToken){
                    nextTc();
                    if (currentTc().equals(KeywordToken.POINT_VIRGULE)){
                        System.out.println("Affichage d un message");
                        return;
                    }
                }
            }
        }
        System.err.println("error in Show mess instruction");
    }

    ////shwo val a revoire
    private void showValeur() {
        if (currentTc().equals(KeywordToken.SHOW_VAL)) {
            nextTc();
            if (currentTc().equals(SymbolToken.COLUMN)){
                nextTc();
                if (currentTc() instanceof IdToken) {
                    nextTc();
                    if (currentTc().equals(KeywordToken.POINT_VIRGULE)){
                        System.out.println("Affichage d une variabel");
                        return;
                    }
                }
            }
        }
        System.err.println("error in Show val instruction");
        }

    private void give() {
        //System.out.println("goood cooode cooongraraaaaaaaaaaa\n");
        if (currentTc() instanceof IdToken) {
            nextTc();
            if (currentTc().equals(SymbolToken.COLUMN)) {
                nextTc();
                if (currentTc() instanceof DataToken) {
                    nextTc();
                    if (currentTc().equals(KeywordToken.POINT_VIRGULE)) {
                        nextTc();
                        System.out.println("affectation d une valeur a une variable");
                        return;
                    }
                }
            }
        }

        System.err.println("error in give instruction");
    }

    ///////////tc means TOKEN
    public Token currentTc() {

        return this.tokens.get(indice);
    }

    public void nextTc() {
        indice++;
    }
}

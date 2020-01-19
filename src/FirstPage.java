import theme.*;
import theme.Button;
import theme.Label;
import theme.TextArea;
import token.Token;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class FirstPage {
    private TextArea resultArea;
    private Image miniLogo;
    private TextArea codeArea;

    LexicalAnalysis lexicalAnalysis= new LexicalAnalysis();
    SyntaxeAnalysis syntaxeAnalysis = new SyntaxeAnalysis();

    private FirstPage() {
        try {
            miniLogo = ImageIO.read(new File("miniLogo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Forma window = new Forma(1000, 1000, "theme");
        window.setIconImage(miniLogo);
        //miniLogo +pic
        ImageIcon logo = new ImageIcon("compila.png");
        //label for icon
        Label logoL = new Label();
        logoL.setIcon(logo);
        Color yellow = new Color(246, 238, 85);
        Label codeL = new Label(yellow, 30, 20);
        codeL.setText("Write Code:");

        ///button panel config
        //button panel
        MyPanel buttonPanel = new MyPanel(300, 300, yellow);
        buttonPanel.setLayout(new GridLayout(5, 0));
        buttonPanel.add(logoL, BorderLayout.CENTER);
        //Buttons
        //4 image button
        ImageIcon charger = new ImageIcon("file.png");
        ImageIcon lex = new ImageIcon("lexic.png");
        ImageIcon synt = new ImageIcon("synt.png");
        ImageIcon sym = new ImageIcon("understanding.png");

        Button chargerFchier = new Button(40, 30, yellow, Color.black, "Charger Un fichier", charger);
        Button lexical = new Button(40, 30, yellow, Color.black, "Analyse Lexical", lex);
        Button syntaxiq = new Button(40, 30, yellow, Color.black, "Analyse Syntaxique", synt);
        Button semantique = new Button(40, 30, yellow, Color.black, "Analyse Semantique", sym);

        chargerFchier.addActionListener(e -> loadFile());
        lexical.addActionListener(e -> doLexicale());
        syntaxiq.addActionListener(e -> doSyntaxique());
        semantique.addActionListener(e -> doSemantique());

        buttonPanel.add(chargerFchier);
        buttonPanel.add(lexical);
        buttonPanel.add(syntaxiq);
        buttonPanel.add(semantique);
        //text panel setting

        codeArea = new TextArea(680, 680, Color.white, Color.black);
        codeArea.setBorder(new LineBorder(Color.BLACK, 1));

        resultArea = new TextArea(680, 680, Color.white, Color.black);
        resultArea.setBorder(new LineBorder(Color.BLACK, 1));
        resultArea.setEditable(false);
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(codeArea),new JScrollPane(resultArea));

        //panel For text +label
        MyPanel textPanel = new MyPanel(700, 700, yellow);
        // textPanel.add(codeArea);
        textPanel.add(splitPane);
        //bigPane config
        MyPanel bigPanel = new MyPanel(1000, 1000, yellow);
        bigPanel.setLayout(new GridLayout(1, 2));

        window.getContentPane().add(buttonPanel, BorderLayout.WEST);
        window.getContentPane().add(textPanel /*codeArea*/);
        window.setResizable(false);
        window.setVisible(true);
    }

    private void loadFile() {
        try {
            codeArea.setText(chargerFichier());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Opens and reads a file, and returns the contents as one String.
     */
    public static String readFileAsString(File filename)
            throws IOException {
        String textCode;
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        reader.close();
        textCode = sb.toString();
        return textCode;
    }


    public static String chargerFichier() throws IOException {
        JFileChooser file_chooser = new JFileChooser(".");
        if (file_chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = file_chooser.getSelectedFile();
            return readFileAsString(file);

        }
        return "";
    }
    public  void doLexicale(){
        lexicalAnalysis.setTextCode(codeArea.getText());
        ArrayList<Token> tokens= lexicalAnalysis.getTokens();

        resultArea.setText("");
        printLexResult(tokens);


    }

    private void printLexResult(ArrayList<Token> tokens)
    {
        resultArea.setVisible(true);
        resultArea.setText("");
        for (Token t : tokens)
        {
            resultArea.append(t.getText() + " -> ");
            switch (t.getType())
            {
                case DATA:
                    resultArea.append("Donnée\n");
                    break;
                case IDENT:
                    resultArea.append("Identificateur\n");
                    break;

                case SYMBOL:
                    resultArea.append("Symbol clé\n");
                    break;
                case MOTCLE:
                    resultArea.append("Mot clé\n");
                    break;
                default:
                    resultArea.append("???\n");
            }
        }
    }

    public  void doSyntaxique(){
        syntaxeAnalysis.setTokens(lexicalAnalysis.getTokens());
        syntaxeAnalysis.performSyntaxAnalysis();

    }
    public  void doSemantique(){

    }

    public static void main(String[] args) {
        FirstPage bof = new FirstPage();
    }
}





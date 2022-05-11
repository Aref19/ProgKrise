

package Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IO {

    public static ArrayList<String> ColorCode = new ArrayList<>(Arrays.asList(TextColor.CYAN_BOLD, TextColor.BLUE_BOLD, TextColor.PURPLE_BOLD, TextColor.BLUE_BOLD));
    public static ArrayList<String> ColorCode_BRIGHT = new ArrayList<>(Arrays.asList(TextColor.CYAN_BOLD_BRIGHT, TextColor.BLUE_BOLD_BRIGHT, TextColor.PURPLE_BOLD_BRIGHT, TextColor.BLUE_BOLD_BRIGHT));
    public static String inputString(){
        Scanner eingabe = new Scanner(System.in);
        String text = eingabe.nextLine();
        return text;
    }

    public static int inputInt(){
        Scanner eingabe = new Scanner(System.in);
        int wahl = -1;
        try {
            wahl = eingabe.nextInt();
            return wahl;
        }
        catch(Exception e){
            IO.warningHighlighter("Bitte eine Zahl eingeben");
            return wahl;
        }
    }

    public static void menuePrinter(String title, String menuePoints){
        int counter = 0;
        String menue = TextColor.WHITE_BOLD_BRIGHT + title + TextColor.RESET + "\n";
        String[] menuePointsArray = menuePoints.split(";");
        for(String menuePoint : menuePointsArray) {
            menue += (ColorCode.get((counter % ColorCode.size())) + "\t(" + counter + ") " + menuePoint + TextColor.RESET + "\n");
            counter++;
        }
        System.out.println(menue);
    }

    public static void wordColorer_BRIGHT(String inputText) {
        int counter = 0;
        String[] textArray = inputText.split(" ");
        String outputText = "";
        for(String word : textArray) {
            outputText += (ColorCode_BRIGHT.get((counter % ColorCode_BRIGHT.size())) + word + TextColor.RESET + " ");
            counter++;
        }
        System.out.println(outputText);
    }
    
    public static void lineColorer(String text, String Color){
        System.out.println(Color + text + TextColor.RESET);
    }

    public static void lineColorer(float floatText, String Color){
        String text = Float.toString(floatText);
        System.out.println(Color + text + TextColor.RESET);
    }

    public static void textHighlighter(String text){
        System.out.println(TextColor.WHITE_BOLD_BRIGHT + text + TextColor.RESET);
    }

    public static void warningHighlighter(String text){
        System.out.println(TextColor.RED_BOLD_BRIGHT + text + TextColor.RESET);
    }

    public static void multilineColorer(String inputText) {
        int counter = 0;
        String outputText = "";
        String[] textArray = inputText.split(";");
        for(String line : textArray) {
            outputText += (ColorCode.get((counter % ColorCode.size())) + line + TextColor.RESET + "\n");
            counter++;
        }
        System.out.println(outputText);
    }

    public static void multilineColorer_Bright(String inputText) {

        int counter = 0;
        String outputText = "";
        String[] textArray = inputText.split(";");
        for(String line : textArray) {
            outputText += (ColorCode_BRIGHT.get((counter % ColorCode.size())) + line + TextColor.RESET + "\n");
            counter++;
        }
        System.out.println(outputText);
    }

    public static void listColorer_Bright(String inputText) {
        int counter = 0;
        String[] textRowArray = inputText.split("\n");
        String outputText = "";
        for(String row : textRowArray) {
            String[] textAttributeArray = row.split(";");
            String tableRow = "";
            for (int i = 0; i < textAttributeArray.length; i++) {
                tableRow += textAttributeArray[i] + "\t\t\t";
            }
            outputText += (ColorCode_BRIGHT.get((counter % ColorCode_BRIGHT.size())) + tableRow + TextColor.RESET + "\n");
            counter++;
        }
        System.out.println(outputText);
    }
}

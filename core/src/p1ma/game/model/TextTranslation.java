package p1ma.game.model;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by p1ma on 28/07/16.
 */
public class TextTranslation {

    private static TextTranslation translation = new TextTranslation();

    private HashMap<Locale, String[]> dico;

    private Locale language;

    private TextTranslation(){
        language = Locale.getDefault();
        if(language == null){
            language = Locale.ENGLISH;
        }

        // Instanciate dico[][]
        dico = new HashMap<Locale, String[]>();

        // ENGLISH
        String[] translation = new String[6];
        translation[0] = "Play";
        translation[1] = "Options";
        translation[2] = "Easy";
        translation[3] = "Medium";
        translation[4] = "Hard";
        translation[5] = "Robot";

        dico.put(Locale.ENGLISH, translation);
        dico.put(Locale.CANADA, translation);
        dico.put(Locale.UK, translation);
        dico.put(Locale.US, translation);


        // FRENCH
        translation[0] = "Jouer";
        translation[1] = "Options";
        translation[2] = "Facile";
        translation[3] = "Moyen";
        translation[4] = "Difficile";
        translation[5] = "Robot";

        dico.put(Locale.FRENCH, translation);
    }

    public static TextTranslation getTranslation(){
        return translation;
    }

    public String getTextPlay(){
        return dico.get(language)[0];
    }

    public String getTextOptions(){
        return dico.get(language)[1];
    }

    public String[] getTextLevel(){
        String[] level = new String[4];
        level[0] = dico.get(language)[2];
        level[1] = dico.get(language)[3];
        level[2] = dico.get(language)[4];
        level[3] = dico.get(language)[5];
        return level;
    }
}

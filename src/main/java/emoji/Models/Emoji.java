package emoji.Models;

import java.sql.*;
import java.util.*;

import emoji.Utils.DatabaseHandler;

public class Emoji {

    private int id;
    private String code;
    private String characters;
    
    public Emoji(){
        id = 0;
        code = "";
        characters = "";
    }

    public Emoji(int id, String code, String characters) {
        this.id = id;
        this.code = code;
        this.characters= characters;
    }
    
    public static List<Emoji> findAll()
    {
        try {
            // Crée une liste prête à accueillir les emojis qui vont être créés à partir des données récupérées
            List<Emoji> emojis = new ArrayList<>();
            // Envoie une requête en base de données et récupère les résultats
            ResultSet set = DatabaseHandler.query("SELECT * FROM `emoji`");
            // Tant qu'il reste des résultats non traités, prend le résultat suivant...
            while (set.next()) {
                // ... et crée un objet à partir des colonnes présentes dans ce résultat
                Emoji emoji = new Emoji(
                    set.getInt("id"),
                    set.getString("code"),
                    set.getString("characters")
                );
                // Ajoute l'objet à la liste
                emojis.add(emoji);
            }
            // Renvoie la liste
            return emojis;
        }
        catch (SQLException exception) {
            System.out.println(exception);
            System.exit(1);
            return null;
        }
    }

    public static Emoji findByCode(String code)
    {
        try {
            // Envoie une requête en base de données
            DatabaseHandler dbHandler = DatabaseHandler.getInstance();
            PreparedStatement statement = dbHandler.getConnection().prepareStatement("SELECT * FROM `emoji` WHERE `code` = ?"
                // Rajouter ces deux lignes si on rencontre une erreur de type "Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY"
                ,ResultSet.TYPE_SCROLL_SENSITIVE
                ,ResultSet.CONCUR_UPDATABLE
            );
            statement.setString(1, code);
            ResultSet set = statement.executeQuery();
    
            // Comme on sait que la requête peut uniquement renvoyer un seul résultat (s'il existe),
            // ou aucun (s'il n'existe pas), cherche le premier résultat de la requête...
            if (set.first()) {
                // ...et renvoie un nouvel objet à partir de ses données
                return new Emoji(
                    set.getInt("id"),
                    set.getString("code"),
                    set.getString("characters")
                );
            // Si la requête ne renvoie aucun résultat, renvoie null
            } else {
                return null;
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCharacters() {
        return characters;
    }

    public void setCharacters(String characters) {
        this.characters = characters;
    }
}

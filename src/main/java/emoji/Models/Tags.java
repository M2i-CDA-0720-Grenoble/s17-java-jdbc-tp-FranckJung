package emoji.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import emoji.Utils.DatabaseHandler;

public class Tags
{
    private int id;
    private String name;

    public Tags() {
        id = 0;
        name = "";
    }

    public Tags(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Emoji> findByName(String name)
    {
        try {
            List<Emoji> emojis = new ArrayList<>();
            // Envoie une requête en base de données
            DatabaseHandler dbHandler = DatabaseHandler.getInstance();
            PreparedStatement statement = dbHandler.getConnection().prepareStatement(
                "SELECT e.* FROM `emoji`e INNER JOIN `emoji_tags`et ON et.emoji_id=e.id INNER JOIN `tags`t ON t.id=et.tag_id WHERE t.name=?"
                // Rajouter ces deux lignes si on rencontre une erreur de type "Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY"
                ,ResultSet.TYPE_SCROLL_SENSITIVE
                ,ResultSet.CONCUR_UPDATABLE
            );
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();
            if (set.first()) {
                Emoji emoji = new Emoji(
                    set.getInt("id"),
                    set.getString("code"),
                    set.getString("characters")
                );
                emojis.add(emoji);
                while (set.next()) {
                    emoji = new Emoji(
                        set.getInt("id"),
                        set.getString("code"),
                        set.getString("characters")
                    );
                    // Ajoute l'objet à la liste
                    emojis.add(emoji);
                }
                return emojis;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

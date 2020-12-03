package emoji;

import emoji.Models.Emoji;
import emoji.Models.Tags;
import emoji.Utils.*;

public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) throws Exception
    {
        Console.colorPrint("voici la liste des émoticones", ConsoleColor.CYAN);
        for (Emoji emoji: Emoji.findAll())
        {
            Console.colorPrint("code: " + emoji.getCode() + " | emoji:" + emoji.getCharacters(), ConsoleColor.GREEN);
        }

        Console.colorPrint("Veuillez entrer le code de l'emoji désiré ou sa catégorie:", ConsoleColor.CYAN);
        String userInput = Console.input();
        //cherche si la catégorie existe et renvoie tous les emoticones correspondant
        if(Tags.findByName(userInput)!= null){
            for(Emoji emoji : Tags.findByName(userInput)){
                Console.colorPrint(emoji.getCode() + " " + emoji.getCharacters(), ConsoleColor.GREEN);
            }
        }else{
            //si la catégorie n'a pas été trouvée, cherche si l'emoticone existe
            if(Emoji.findByCode(userInput) != null){
                Console.colorPrint(Emoji.findByCode(userInput).getCharacters(), ConsoleColor.GREEN);
            }else{
                Console.warn("Ce code ou cette catégorie n'existe pas désolé");
            }
        }
    }
}

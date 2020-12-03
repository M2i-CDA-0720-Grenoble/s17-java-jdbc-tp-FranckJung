package emoji;

import emoji.Models.Emoji;
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

        Console.colorPrint("Veuillez entrer le code de l'emoji désiré:", ConsoleColor.CYAN);
        String userInput = Console.input();
        
        if(Emoji.findByCode(userInput) != null){
            Console.colorPrint(Emoji.findByCode(userInput).getCharacters(), ConsoleColor.GREEN);
        }else{
            Console.warn("Ce code n'existe pas désolé");
        }
    }
}

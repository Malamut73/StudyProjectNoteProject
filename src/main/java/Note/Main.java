package Note;

import Note.authentication.Authentication;
import Note.command.CommandReader;

public class Main {

    public static void main(String[] args) {
        //create note note1 root texttexttext
        System.out.println("Hello, World!");

        authenticate();

        CommandReader.startReading();
    }

    private static void authenticate() {
        Authentication authentication = new Authentication();
        authentication.authenticate();
    }
}

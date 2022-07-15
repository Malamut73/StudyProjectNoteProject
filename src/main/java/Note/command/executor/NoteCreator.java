package Note.command.executor;

import Note.command.CommandType;
import Note.model.Note;
import Note.context.UserContext;

public class NoteCreator extends AbstractCommandExecutor{
    @Override
    public int execute(String command) {
        return createNote(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_NOTE;
    }

    private int createNote(String command) {
        var wordsArray = command.split(" ");

        var noteName = wordsArray[2];

        if (findNote(noteName).isPresent()) {
            System.out.println("Note already exists");
            return -1;
        }

        var noteParentFolder = wordsArray[3];
        var folder = findFolder(noteParentFolder);

        if (folder.isEmpty()) {
            System.out.println("Folder not exists");
            return -1;
        }

        StringBuilder noteTextSb = new StringBuilder();
        for (int i = 4; i < wordsArray.length; i++) {
            noteTextSb.append(wordsArray[i]);
        }

        var noteText = noteTextSb.toString();

        var newNote = new Note(0, noteName, noteText, folder.get(), UserContext.getUserLogin());

        noteRepository.save(newNote);

        System.out.println("New note created");

        return 1;
    }
}

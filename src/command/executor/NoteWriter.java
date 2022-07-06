package command.executor;

import command.CommandType;
import model.Note;

public class NoteWriter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return writeNotes(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_NOTES;
    }

    private int writeNotes(String command) {
        for (Note note : noteRepository.findAll()) {
            var path = findFolderPath(note.getName());

            System.out.printf("Name: \"%s\". Text: \"%s\". FullPath: %s %n",
                    note.getName(),
                    note.getText(),
                    path
            );
        }

        return 1;
    }
}

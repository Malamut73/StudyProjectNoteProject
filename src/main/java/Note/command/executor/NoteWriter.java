package Note.command.executor;

import Note.command.CommandType;
import Note.model.Note;
import Note.context.UserContext;

import java.util.Comparator;
import java.util.stream.Collectors;

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

        var isNeedsFiltering = command.contains("-f");
        var isNeedsSorting = command.contains("-s");
        var notes = noteRepository.findAll().stream().toList();

        if(isNeedsFiltering){
            notes = notes.stream()
                    .filter(note -> note.getAuthorEmail().equals(UserContext.getUserLogin()))
                    .collect(Collectors.toList());
        }
        if(isNeedsSorting){
            notes = notes.stream()
                    .sorted(Comparator.comparing(Note::getCreationDate))
                    .collect(Collectors.toList());
        }

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

package Note.command.executor;

import Note.command.CommandType;
import Note.model.Note;
import lombok.SneakyThrows;

public class NoteWriter extends AbstractCommandExecutor {
    @Override
    public int execute(String command) {
        return writeNotes(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.WRITE_ALL_NOTES;
    }

    @SneakyThrows
    private int writeNotes(String command) {
        System.out.println("Pop in write all notes");
        var isNeedsFiltering = command.contains("-f");
        var isNeedsSorting = command.contains("-s");
//        var notes = noteRepository.findAll().stream().toList();

//        if(isNeedsFiltering){
//            notes = notes.stream()
//                    .filter(note -> note.getAuthorEmail().equals(UserContext.getUserLogin()))
//                    .collect(Collectors.toList());
//        }
//        if(isNeedsSorting){
//            notes = notes.stream()
//                    .sorted(Comparator.comparing(Note::getCreationDate))
//                    .collect(Collectors.toList());
//        }



//
//        for (var str :
//                noteRepository.findAll()) {
//            System.out.println(str.toString());
//        }

        for (Note note : noteRepository.findAll()) {
//            var path = findFolderPath(note.getName());

            System.out.printf("Name: \"%s\". Text: \"%s\". FullPath: %s %n",
                    note.getName(),
                    note.getText(),
                    "empty path"
            );
        }

        return 1;
    }
}

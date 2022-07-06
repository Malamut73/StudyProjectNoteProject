package command.executor;

import command.CommandType;
import model.Folder;

public class FolderCreator extends AbstractCommandExecutor{

    @Override
    public int execute(String command) {
        return createFolder(command);
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.CREATE_FOLDER;
    }

    private int createFolder(String command) {
        var wordsArray = command.split(" ");

        var folderName = wordsArray[2];

//        if (findNote(folderName).isPresent()) {
//            System.out.println("Note already exists");
//            return -1;
//        }

        var noteParentFolder = wordsArray[3];
        var folder = findFolder(noteParentFolder);

        if (folder.isEmpty()) {
            System.out.println("Folder not exists");
            return -1;
        }

        var newFolder = new Folder(folderName, folder.get());

        folderRepository.save(newFolder);

        System.out.println("New folder created");

        return 1;
    }
}

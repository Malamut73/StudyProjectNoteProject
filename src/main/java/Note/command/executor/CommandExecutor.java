package Note.command.executor;

import Note.command.CommandType;

public interface CommandExecutor {

    int execute(String command);

    CommandType getCommandType();
}

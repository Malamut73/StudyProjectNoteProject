package Note.repository.impl;

import Note.config.ApplicationDataSource;
import Note.model.Note;
import Note.repository.NoteRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

@Repository
public class NoteRepositoryImpl implements NoteRepository {

    @SneakyThrows
    @Override
    public Set<Note> findAll() {

        String selected = "SELECT * FROM note";
        PreparedStatement preparedStatement = ApplicationDataSource.getConnection()
                .prepareStatement(selected);
        ResultSet resultSet = preparedStatement.executeQuery();

        return mapResultSetToNotes(resultSet);


    }
    @Override
    public void save(Note note) {

    }
    @Override
    public void remove(Note note) {

    }
    @SneakyThrows
    private static Set<Note> mapResultSetToNotes(ResultSet resultSet){

        Set<Note> notes = new HashSet<>();

        while (resultSet.next()) {
            var id = resultSet.getInt("id");
            var name = resultSet.getString("name");
            var text = resultSet.getString("text");
            var authorEmail = resultSet.getString("authorEmail");
            var parentFolder = resultSet.getString("parentFolder");
            var creationDate = resultSet.getDate("creationDate");
            var updateDate = resultSet.getDate("updateDate");
            var parentFolder_id = resultSet.getInt("parentFolder_id");

            notes.add(new Note(id, name,text, null, authorEmail));
        }
        return notes;
    }
}

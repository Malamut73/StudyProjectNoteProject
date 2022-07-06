package repository;

import model.Note;

import java.util.Set;

public interface NoteRepository {

    Set<Note> findAll();

    void save(Note note);

    void remove(Note note);
}

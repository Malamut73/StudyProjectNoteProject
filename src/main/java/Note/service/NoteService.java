package Note.service;

import Note.dto.NoteCreateDTO;
import Note.model.Note;
import Note.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    public void createNote (NoteCreateDTO body) {
        var newNote = new Note(
                body.getText(),
                body.getText(),
                null,
                body.getAuthorEmail()
        );
        noteRepository.save(newNote);
    }
}

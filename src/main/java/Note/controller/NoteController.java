package Note.controller;

import Note.dto.NoteCreateDTO;
import Note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @PostMapping
    public void createNote (@RequestBody NoteCreateDTO body) {

        noteService.createNote(body);
    }

}

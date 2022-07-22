package Note.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NoteCreateDTO {

    private final String title;
    private final String text;
//    private final String folderName;
    private final String authorEmail;

    public NoteCreateDTO(@JsonProperty("title") String title,
                         @JsonProperty("text") String text,
                         @JsonProperty("authorEmail") String authorEmail) {
        this.title = title;
        this.text = text;
        this.authorEmail = authorEmail;
    }
}

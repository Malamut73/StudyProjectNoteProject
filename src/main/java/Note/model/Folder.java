package Note.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Folder implements Serializable {

    @EqualsAndHashCode.Include
    private String name;
    private Folder parentFolder;

    public Folder(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
    }

}

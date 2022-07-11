package Note.repository.impl;

import Note.model.Note;
import Note.repository.NoteRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class NoteRepositoryImpl implements NoteRepository {

    private static String DATA_FILE_NAME = "data-note.dat";
    private static final Set<Note> NOTES = new HashSet<>();

    static {
        loadDataFromFile();
    }

    private static final NoteRepositoryImpl SINGLETON = new NoteRepositoryImpl();

    private NoteRepositoryImpl() {}

    public static NoteRepository getSingleton() {
        return SINGLETON;
    }

    private static void saveDataToFile(){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))){
            stream.writeObject(NOTES);
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
    private static void flush(){
        saveDataToFile();
    }
    @SuppressWarnings("unchecked")
    private static void loadDataFromFile(){
        try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(DATA_FILE_NAME))){
           Set<Note> loadedNotes = (Set<Note>) stream.readObject();
           NOTES.addAll(loadedNotes);
        }catch(FileNotFoundException ex){
            System.out.println("ooops");
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }
    @Override
    public Set<Note> findAll() {
        return NOTES;
    }
    @Override
    public void save(Note note) {
        NOTES.add(note);
        flush();
    }
    @Override
    public void remove(Note note) {
        NOTES.remove(note);
        flush();
    }
}

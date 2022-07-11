package Note.repository.impl;

import Note.model.Folder;
import Note.repository.FolderRepository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FolderRepositoryImpl implements FolderRepository {

    private static String DATA_FILE_NAME = "data-folder.dat";
    private static final Set<Folder> FOLDERS = new HashSet<>();

    static {

        loadDataFromFile();
        if(FOLDERS.stream().noneMatch(folder -> folder.getName().equals("root"))){
            FOLDERS.add(new Folder("root", null));
        }
    }

    private static final FolderRepository SINGLETON = new FolderRepositoryImpl();

    private FolderRepositoryImpl() {}

    public static FolderRepository getSingleton() {
        return SINGLETON;
    }

    private static void saveDataToFile(){
        try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(DATA_FILE_NAME))){
            stream.writeObject(FOLDERS);
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
            Set<Folder> loadedFolder = (Set<Folder>) stream.readObject();
            FOLDERS.addAll(loadedFolder);
        }catch(FileNotFoundException ex){
            System.out.println("ooops");
        }catch(IOException | ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Set<Folder> findAll() {
        return FOLDERS;
    }

    @Override
    public void save(Folder newFolder) {
        FOLDERS.add(newFolder);
        flush();
    }

}

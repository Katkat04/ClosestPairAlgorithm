import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    
    private PrintWriter out;

    public FileManager(String fileName){ 
        create(fileName);
        try{
            out = new PrintWriter(fileName);
        }catch(FileNotFoundException e){}
    }

    private void create(String fileName){
        try {
            File f = new File(fileName);
            f.createNewFile();
            System.out.println("File created");

        } catch (IOException err) {
            // complains if there is an Input/Output Error
            System.out.println("IO Error:");
            err.printStackTrace();
        }
    }

    public void write(String line){
        out.println(line);
    }

    public void close(){
        try{
            out.close();
        }catch(Exception err){
            
        }
        
    }

}

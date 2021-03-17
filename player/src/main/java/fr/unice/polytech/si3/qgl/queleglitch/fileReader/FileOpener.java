package fr.unice.polytech.si3.qgl.queleglitch.fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileOpener {

    String path;

    public FileOpener(String path){
        this.path = path;
    }

    public String getTxtInFile(String name){
        try {
            BufferedReader file = new BufferedReader(new FileReader(path + name));
            String line;
            StringBuilder txt = new StringBuilder();
            while ((line = file.readLine()) != null)
                txt.append(line);
            file.close();
            return txt.toString().replaceAll("\\s", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

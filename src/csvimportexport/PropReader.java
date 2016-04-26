package csvimportexport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
    
    private final Properties prop;
    private final FileInputStream input;
    
    public PropReader(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()) 
            file.createNewFile();
        prop = new Properties();
        BufferedReader r = new BufferedReader(new FileReader(file));
        input = new FileInputStream(file);
        prop.load(input);
        r.close();
    }

    public Properties getProp() {
        return prop;
    }
    
}
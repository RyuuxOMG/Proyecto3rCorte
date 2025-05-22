package autonoma.comidadelcielo.elements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class PlainTextFileReader implements Reader {

    private String fileContent;
    private Charset charset = Charset.forName("UTF-8");

    public PlainTextFileReader() {}

    public String read(String filePath) throws IOException {
        File file = new File(filePath);
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        StringBuilder content = new StringBuilder();
        String line;
        
        while ((line = buffer.readLine()) != null) {
            content.append(line);
        }

        buffer.close();
        reader.close();

        this.fileContent = content.toString().trim();
        
        return this.fileContent;
    }

    public String getStoredConfiguration() {
        return fileContent;
    }
}
package autonoma.comidadelcielo.elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * @author Santiago García
 * @since 20250521
 * @version 1.0
 */
public class PlainTextFileWriter implements Writer {

    private final Charset charset = Charset.forName("UTF-8");
    private String filePath;
    
    public PlainTextFileWriter(String filePath) {
        this.filePath = filePath;
    }
 
    @Override
    public void write(String content) throws IOException {
        File file = new File(this.filePath);
        FileWriter writer = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(writer);

        pw.println(content);  

        pw.close();
        writer.close();
    }
}
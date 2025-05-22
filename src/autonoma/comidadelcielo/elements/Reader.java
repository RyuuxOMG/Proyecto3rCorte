package autonoma.comidadelcielo.elements;

import java.io.IOException;

/**
 * Model representing a file reader
 * @author Alejandro
 * @since 20250518
 * @version 1.0
 */
public interface Reader {
    /**
     * Reads a file given its path
     * @param filePath path of the file to read
     * @return file content
     * @throws IOException if an error occurs while reading the file
     */
    public abstract String read(String filePath) throws IOException;
}

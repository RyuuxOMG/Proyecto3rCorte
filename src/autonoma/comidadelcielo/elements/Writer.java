package autonoma.comidadelcielo.elements;

import java.io.IOException;

/**
 * @author Alejandro
 * @since 20250516
 * @version 1.0
 */
public interface Writer {
    /**
     * @param file
     * @throws IOException
     */
    public abstract void write(String file) throws IOException;
}
import java.io.IOException;

/**
 * Das Interface fuer Strategy Pattern
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public interface SuLInterface {

        public void speichern(String filename) throws IOException;
        public void laden(String filename) throws IOException;
        public void speichern() throws IOException;
        public void laden() throws IOException;

}

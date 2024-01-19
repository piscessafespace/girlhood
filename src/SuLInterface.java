import java.io.IOException;

public interface SuLInterface {

    public interface SpeichernUndLadenInterface {
        public void speichern(String filename) throws IOException;
        public void laden(String filename) throws IOException;
        public void speichern() throws IOException;
        public void laden() throws IOException;

    }
}

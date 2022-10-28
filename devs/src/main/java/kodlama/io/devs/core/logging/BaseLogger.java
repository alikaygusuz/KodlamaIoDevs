package kodlama.io.devs.core.logging;

import java.io.IOException;

public interface BaseLogger {
    void add(String data) throws IOException;
    void delete(String data);
    void update(String data);
    void ListById(int data);
}

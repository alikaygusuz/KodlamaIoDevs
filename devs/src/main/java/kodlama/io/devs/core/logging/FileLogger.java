/*
package kodlama.io.devs.core.logging;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
@Service
public class FileLogger implements BaseLogger {

    @Override
    public void add(String data) throws IOException {
        FileWriter myWriter = new FileWriter("C:\\KodlamaIoDevs\\devs\\src\\main\\java\\kodlama\\io\\devs\\core\\logging\\logCollector\\AddLogger.txt");
        try {
            myWriter.write("Ekleme işlemi Ali Kaygusuz tarafından gerçekleştirildi.");
            myWriter.close();
            System.out.println(data + " işlemi Ali Kaygusuz tarafından gerçekleştirildi.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    @Override
    public void delete(String data) {

    }

    @Override
    public void update(String data) {

    }

    @Override
    public void ListById(int data) {

    }
}
*/



import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                List<String> words = Files.readAllLines(selectedFile.toPath());
                Filter shortWordFilter = new ShortWordFilter();
                List<String> shortWords = collectAll(words, shortWordFilter);

                System.out.println("Short words from the file:");
                for (String word : shortWords) {
                    System.out.println(word);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<String> collectAll(List<String> objects, Filter filter) {
        List<String> filteredList = new ArrayList<>();
        for (String object : objects) {
            if (filter.accept(object)) {
                filteredList.add(object);
            }
        }
        return filteredList;
    }
}
    

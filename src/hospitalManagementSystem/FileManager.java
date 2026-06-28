package hospitalManagementSystem;

import java.io.*;
import java.util.ArrayList;

class FileManager {
    public static void writeToFile(String filename, String content) throws IOException {
        FileWriter fw = new FileWriter(filename, true);
        fw.write(content);
        fw.close();
    }

    public static ArrayList<String> readFromFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return lines;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null)
            lines.add(line);
        br.close();
        return lines;
    }
}

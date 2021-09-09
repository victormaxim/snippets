import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class rwFile {

    public static void main(String[] args) throws IOException {

        System.out.println(System.getProperty("user.dir" +  "..\\"));

        File folder = new File(System.getProperty("user.dir") + "\\..\\");
        File[] listOfFiles = folder.listFiles();
        System.out.println("===>" + folder.getAbsolutePath());

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File: " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory: " + listOfFiles[i].getName());
            }
        }


        try (Stream<String> stream = Files.lines(Paths.get(System.getProperty("user.dir") + "\\..\\" + "snippets\\src\\test\\resources\\" + "temp.txt"))) {
            stream.forEach(line -> {
                try {
                    System.out.println(line);
                } catch (Exception e) {System.out.println("error" + e);}
            });
        }

    }

}

package snippets.FileOperations;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testcontainers.shaded.com.google.common.io.Resources.getResource;

/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class streamResources {

    String result = "";
    InputStream inputStream;

    public void getVals() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "test.properties";

//            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);


//            String loc = Paths.get(getClass().class.getResource("test.properties"));
//            System.out.println(loc);

            URL res = getClass().getClassLoader().getResource("test.properties");
            File file = Paths.get(res.toURI()).toFile();
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);


            List<String> list = new ArrayList<>();

            try (Stream<String> stream = Files.lines(Paths.get(absolutePath))) {

                //1. filter line 3
                //2. convert all content to upper case
                //3. convert it into a List
                list = stream
                        .filter(line -> line.startsWith("na"))
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());




            } catch (IOException e) {
                e.printStackTrace();
            }

            list.forEach(System.out::println);
            try (Stream<String> stream = Files.lines(Paths.get(absolutePath))) {
                stream
                        .map(String::toUpperCase)
                        .forEach(line -> {
                    try {
                        System.out.println("==>" + line);
                    } catch (Exception e) {
                        System.out.println("error" + e);
                    }
                });
            }
//
//            URI resource = getClass().class.getResource("test.properties");
//            Paths.get(resource.toURI()).toFile();
//            File file = Paths.get(resource.toURI()).toFile();
//            BufferedReader br = Files.newBufferedReader(Paths.get(resource.toURI()).toFile());
//
//
//
////            BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(getClass().getClassLoader().getResourceAsStream(propFileName))));
//            Stream<String> lines = br.lines();
//            lines.forEach(System.out::println);
//
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
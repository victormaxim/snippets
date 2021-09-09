package snippets.FileOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class propertiesRW {

    String result = "";
    InputStream inputStream;

    public String getVals() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "test.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            BufferedReader br = Files.newBufferedReader(Paths.get(String.valueOf(getClass().getClassLoader().getResourceAsStream(propFileName))));
            Stream<String> lines = br.lines();
            lines.forEach(System.out::println);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String user = prop.getProperty("name");
            result = user;

            //result = "Company List = " + company1 + ", " + company2 + ", " + company3;
            //System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}

package A;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ampli {

    public static void main(String[] args) {

        Integer[] a = {7,8,5,9,11};
//        List<Integer> list = new Integer()[]{7, 8, 5, 9, 11};

//        int[] a = {7,8,5,9,11};

//        int min = Arrays.stream(a).min().getAsInt();
//        int max = Arrays.stream(a).max().getAsInt();
//        System.out.println(Collections.max(Arrays.asList(a)));
//        List b = Arrays.asList(ArrayUtils.toObject(a));
        System.out.println(Collections.max(Arrays.asList(a)));
//        System.out.println(Collections.max(list));
//        System.out.println(min);
//        System.out.println(max);


        if(true) System.out.println(true);

        //append to file
        try {
            final Path path = Paths.get("filename.txt");
            Files.write(path, Arrays.asList("New line to append"),
                    Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (final IOException ioe) {
            // Add your own exception handling...
        }
    }

}

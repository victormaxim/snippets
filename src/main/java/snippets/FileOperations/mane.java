package snippets.FileOperations;

import java.io.IOException;

public class mane {
    public static void main(String[] args) throws IOException {
        propertiesRW prw = new propertiesRW();
        System.out.println(prw.getVals());
        streamResources sr = new streamResources();
        sr.getVals();
    }
}

package gherkinexecutor.Feature_Import;
import org.junit.jupiter.api.*;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
class Feature_Import{
void log(String value) {
    try {
        FileWriter myLog = new FileWriter("src/test/java/gherkinexecutor/Feature_Import/log.txt", true);
        myLog.write(value + "\n");
        myLog.close();
    } catch (IOException e) {
    System.err.println("*** Cannot write to log ");
    }
    }


    }


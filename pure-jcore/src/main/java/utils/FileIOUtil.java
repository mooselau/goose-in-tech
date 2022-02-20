package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;


public final class FileIOUtil {

    private FileIOUtil() {
    }

    public static void outputToFile(byte[] content, String filepath) {
        try (FileOutputStream fos = new FileOutputStream(filepath)) {
            fos.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readFromFile(String filepath) {
        File publicKeyFile = new File(filepath);
        try {
            return Files.readAllBytes(publicKeyFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

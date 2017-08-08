package ir.m7.androidframework.lib.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by Milad on 10/1/2015.
 */
public class MFile {

    public static void writer(String path, String text) throws IOException {
        writer(new FileWriter(path), text);
    }

    public static void writer(File file, String text) throws IOException {
        writer(new FileWriter(file), text);
    }

    public static void writer(FileWriter fileWriter, String text) throws IOException {
        fileWriter.write(text);
        fileWriter.close();
    }

    public static OutputStreamWriter openWriter(File file, int mode) throws IOException {
        return new OutputStreamWriter(new FileOutputStream(file));
    }

    public static OutputStreamWriter openWriter(String path, int mode) throws IOException {
        File file = open(path, mode);
        return openWriter(file, mode);
    }

    public static OutputStreamWriter openWriter(FileOutputStream fileOutputStream) {
        return new OutputStreamWriter(fileOutputStream);
    }

    public static File open(String path, int mode) throws IOException {
        File file = new File(path);
        if ((mode & FileOpenMode.CREATE) == FileOpenMode.CREATE) {
            if (file.exists() && ((mode & FileOpenMode.NEW) == FileOpenMode.NEW)) {
                file.delete();
                file.createNewFile();
            } else {
                file.createNewFile();
            }
        } else {
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
        }
        return file;
    }

    public static String readAllText(InputStreamReader inputStreamReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).trimToSize();
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static String readAllText(File file) throws IOException {
        return readAllText(new FileReader(file));
    }

    public static String readAllText(InputStream inputStream) throws IOException {
        return readAllText(new InputStreamReader(inputStream));
    }

    public static String readAllText(String path, int mode) throws IOException {
        File file = open(path, mode);
        return readAllText(file);
    }

    public class FileOpenMode {
        public static final int OPEN = 0;
        public static final int CREATE = 0x100;
        public static final int NEW = 0x200;
        public static final int WRITE = 1;
        public static final int READ = 2;

        public static final int OPENWRITE = OPEN | WRITE;
        public static final int OPENREAD = OPEN | READ;

        public static final int OPENCREATE = OPEN | CREATE;
        public static final int CREATENEW = CREATE | NEW;

    }
}

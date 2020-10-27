import java.io.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: AnhNBT (anhnbt.it@gmail.com)
 * Date: 10/27/2020
 * Time: 1:42 PM
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter source path: ");
        String sourcePath = input.nextLine();
        System.out.println("Enter target path: ");
        String targetPath = input.nextLine();
        try {
            copyFileUsingBinary(sourcePath, targetPath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Success.");
        }
    }

    public static void copyFileUsingBinary(String sourcePath, String targetPath) throws IOException {
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        InputStream inputStream = new FileInputStream(sourceFile);
        OutputStream outputStream = new FileOutputStream(targetFile);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.close();
        inputStream.close();
    }
}

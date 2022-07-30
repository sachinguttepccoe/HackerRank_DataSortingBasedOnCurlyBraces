import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*
 * Completed the 'extractData()' function below.
 * Date : 31.07.2022
 * Version : 1.0 (Initial Version)
 * @author Sachin Gutte
 * The function is expected to return a List<String>
 */
public class Solution {

    public static void main(String[] args) throws IOException {


        FileInputStream fis = new FileInputStream("C:\\Projects\\HackerRank\\inputfile.txt");
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String content = sb.toString().trim().replace("\r\n", "").replace("  ", "");
        String[] tokens = content.split("::");
        content = tokens[0];
        int level = Integer.parseInt(tokens[1].trim());


        List<String> lines = HackerRank.extractData(content, level);
        List<String> finalLines = new ArrayList<>();
        for(String line: lines) {
            finalLines.add(line.trim());
        }

        System.out.print(finalLines);

    }
}
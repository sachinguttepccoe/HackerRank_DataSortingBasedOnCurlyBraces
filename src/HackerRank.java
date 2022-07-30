import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Completed the 'extractData()' function below.
 * Date : 31.07.2022
 * Version : 1.0 (Initial Version)
 * @author Sachin Gutte
 * The function is expected to return a List<String>
 */

class HackerRank {

    private static int intGroupLevel;

    public static int decideGroupLevel(String stringData, char key1, char key2) {
        int key1Count = (int) stringData.chars().filter(ch -> ch == key1).count();
        int key2Count  = (int) stringData.chars().filter(ch -> ch == key2).count();
        if (key2Count > key1Count)
            intGroupLevel=key2Count-key1Count;
        else
            intGroupLevel=key1Count-key2Count;

        return intGroupLevel;
    }

    public static List<String> extractData(String hierarchicalData, int level) {
        List<String> extractedDataForLevel = new ArrayList<>();
        String levelString = null;
        Pattern pattern = Pattern.compile("[^{}]+");
        Matcher matchPattern = pattern.matcher(hierarchicalData);
        while(matchPattern.find()) {
            levelString=matchPattern.group();
            int endIndex = hierarchicalData.indexOf(levelString);
            intGroupLevel=decideGroupLevel(hierarchicalData.substring(0,endIndex),'{','}');
            if (intGroupLevel==level)
                extractedDataForLevel.add(levelString);
        }
        return extractedDataForLevel;

    }

}



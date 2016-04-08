package parserDB;
import java.io.*;
import java.util.*;
import java.text.*;



/**
 * Created by patryk on 12.03.16.
 */
public class Parser {


    private ArrayList<File> fileObjList = new ArrayList<File>();

    public ArrayList<File> loadFromFile() throws FileNotFoundException, ParseException, NullPointerException  {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        java.io.File direction = new java.io.File("/home/mczarnecki/Dane/");


            for (java.io.File file : direction.listFiles()) {
                Scanner readFile = new Scanner(file);
                String line;
                line = readFile.nextLine();
                line = null;
                while (readFile.hasNextLine()) {
                    line = readFile.nextLine();
                    String[] allLine = line.split(",");
                    Date date = new SimpleDateFormat("yyyyMMdd", (Locale.ENGLISH)).parse(allLine[1]);
                    File fileObj = new File(allLine[0],
                            date, Double.parseDouble(allLine[2]),
                            Double.parseDouble(allLine[3]), Double.parseDouble(allLine[4]),
                            Double.parseDouble(allLine[5]), Float.parseFloat(allLine[6]));
                    fileObjList.add(fileObj);

                }
            }

        System.out.println(fileObjList.size());
        return fileObjList;
    }

}

package parserDB;


import java.io.IOException;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by Patryk on 22.03.2016.
 */
public class URLdownload {


    private URL url;
    private ArrayList<File> urlObjectList = new ArrayList<File>();

    public ArrayList<File> downloadFromUrl() throws IOException, ParseException {

        url = new URL("http://bossa.pl/pub/ciagle/omega/cgl/ndohlcv.txt");
        Scanner readFile = new Scanner(url.openStream());
        String line = null;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        while(readFile.hasNextLine()){
            line = readFile.nextLine();
            String[] allLine = line.split(",");



            Date date = new SimpleDateFormat("yyyyMMdd", (Locale.GERMANY)).parse(allLine[1]);
            File fileObj = new File(allLine[0],
                    date, Double.parseDouble(allLine[2]),
                    Double.parseDouble(allLine[3]), Double.parseDouble(allLine[4]),
                    Double.parseDouble(allLine[5]), Float.parseFloat(allLine[6]));
            urlObjectList.add(fileObj);

        }
        return urlObjectList;
     }
}


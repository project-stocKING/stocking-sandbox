package parserDB;

import java.io.IOException;
import java.net.UnknownHostException;
import java.text.ParseException;


public class App
{
    public static void main( String[] args ) throws ParseException {
        URLdownload urlDownload = new URLdownload();
        Parser parserObj = new Parser();
        DataBase databaseObj = new DataBase();

        try {
            databaseObj.connectionToDataBase();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            databaseObj.loadDocuments(urlDownload.downloadFromUrl(), databaseObj.findDocbyDate(urlDownload.downloadFromUrl()));
            System.out.println("Zakonczone wgrywanie danych");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }


}

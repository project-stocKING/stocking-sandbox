package parserDB;




import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;
import static java.util.Arrays.deepEquals;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        URLdownload urlDownload = new URLdownload();
        Parser parserObj = new Parser();
        DataBase databaseObj = new DataBase();
//test comiita

        try {
            databaseObj.connectionToDataBase();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            databaseObj.loadDocuments(urlDownload.downloadFromUrl());
            System.out.println("Zakonczone wgrywanie danych");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }


}

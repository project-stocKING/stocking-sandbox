package parserDB;
import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by patryk on 13.03.16.
 */
public class DataBase {

        MongoClient mongoClient;
        MongoDatabase database;


        public void connectionToDataBase() throws UnknownHostException{
                /// mczarnecki@at-server.iiar.pwr.edu.pl

                mongoClient = new MongoClient("156.17.41.238", 27017); /// localhost
                database = mongoClient.getDatabase("endOfDay"); /// nazwa bazy



        }

        public void loadDocuments(ArrayList<File> list){
                int i = 0;
                for (File file : list){

                        System.out.println("Wgrano " + i);
                        Document doc = new Document(new Document()
                                        .append("Name: ", file.getName())
                                        .append("Date: ", file.getDate())
                                        .append("startValue: ", file.getStartValue())
                                        .append("maxValue: ", file.getMaxValue())
                                        .append("minValue: ", file.getMinValue())
                                        .append("endValue: ", file.getEndValue())
                                        .append("Volume: ", file.getVolume()));

                        database.getCollection(file.getName()).insertOne(doc);
                        i++;

                }
        }
}


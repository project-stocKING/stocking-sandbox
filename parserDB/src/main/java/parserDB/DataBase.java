package parserDB;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.*;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by patryk on 13.03.16.
 */
public class DataBase {

       private MongoClient mongoClient;
       private MongoDatabase database;


        public void connectionToDataBase() throws UnknownHostException{


                mongoClient = new MongoClient();
                database = mongoClient.getDatabase("endOfDay"); /// nazwa bazy



        }


        public boolean findDocbyDate(ArrayList<File> documentList) throws ParseException {

            TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
            Bson filter = new Document("Date: ", documentList.get(0).getDate());
            MongoCollection<Document> collection = database.getCollection(documentList.get(0).getName());
            List<Document> findList = collection.find(filter).into(new ArrayList<Document>());

           if(findList.isEmpty()){

               return false;
           }
            else{

                return true;
           }
        }



        public void loadDocuments(ArrayList<File> list, boolean find) {
            int i = 0;

            if(find == true) {
            System.out.println("Dane z "+list.get(0).getDate()+" są już w bazie");

            }
            else {
            for (File file : list) {

                    Document document = new Document(new Document()
                            .append("Name: ", file.getName())
                            .append("Date: ", file.getDate())
                            .append("startValue: ", file.getStartValue())
                            .append("maxValue: ", file.getMaxValue())
                            .append("minValue: ", file.getMinValue())
                            .append("endValue: ", file.getEndValue())
                            .append("Volume: ", file.getVolume()));
                    database.getCollection(file.getName()).insertOne(document);
                    System.out.println("Wgrano " + i);
                    i++;
                }
            }
        }
}



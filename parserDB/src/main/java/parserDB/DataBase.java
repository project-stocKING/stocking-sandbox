package parserDB;
import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.*;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by patryk on 13.03.16.
 */
public class DataBase {

        MongoClient mongoClient;
        MongoDatabase database;

        public void connectionToDataBase() throws UnknownHostException{
                /// mczarnecki@at-server.iiar.pwr.edu.pl

                mongoClient = new MongoClient(); /// localhost
                database = mongoClient.getDatabase("parserDB"); /// nazwa bazy



        }

        public void loadDocuments(ArrayList<File> list){

                for (File file : list){
                    //    if(file.getName() == "BZWBK"){
                              //  String docName =file.getName()+file.getDate().toString();
                                Document doc = new Document(new Document()
                                        .append("Name: ", file.getName())
                                        .append("Date: ", file.getDate())
                                        .append("startValue: ", file.getStartValue())
                                        .append("maxValue: ", file.getMaxValue())
                                        .append("minValue: ", file.getMinValue())
                                        .append("endValue: ", file.getEndValue())
                                        .append("Volume: ", file.getVolume()));
                                database.getCollection(file.getName()).insertOne(doc);
                      //  }
                }

        }




}

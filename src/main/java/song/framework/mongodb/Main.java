package song.framework.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Song on 2017/8/2.
 */
public class Main {
    public static void main(String [] args){
        MongoCredential credential = MongoCredential.createScramSha1Credential("test","test","slanf@test".toCharArray());
        ServerAddress serverAddress = new ServerAddress("127.0.0.1",6119);
        List<ServerAddress> serverAddressList = new ArrayList<ServerAddress>();
        serverAddressList.add(serverAddress);
        List<MongoCredential> credentialList = new ArrayList<MongoCredential>();
        credentialList.add(credential);
        MongoClient client = new MongoClient(serverAddressList,credentialList);
        MongoDatabase db = client.getDatabase("test");

        MongoCollection collection = db.getCollection("test1");
        FindIterable findResult = collection.find();
        Iterator iterator = findResult.iterator();
        while (iterator.hasNext()){
            Document doc = (Document) iterator.next();
            System.out.println(doc);
        }
    }
}

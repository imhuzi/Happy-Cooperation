package com.hudongfenxiang.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @FileName     :  Mongodb.java
 * @Encoding     :  UTF-8
 * @Package      :  com.hudongfenxiang.db
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 11, 2013, 11:48:58 PM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
public class Mongodb {
    private final static Properties prop = new Properties();
    private static String ip = "127.0.0.1";
    private static int port = 27017;
    private static Mongo mongo = null;
    static {
        InputStream is = Mongodb.class.getClassLoader().getResourceAsStream("mongodb.properties");
        try {
            prop.load(is);
        } catch (IOException ex) {
            Logger.getLogger(Mongodb.class.getName()).log(Level.SEVERE, null, ex);
        }
        ip = prop.getProperty("ip");
        port = Integer.parseInt(prop.getProperty("port"));
    }
    
    public static Mongo getMongo() {
        if (mongo == null) {
            try {
                mongo = new Mongo(ip, port);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Mongodb.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MongoException ex) {
                Logger.getLogger(Mongodb.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return mongo;
    }
    
    public static DB getDb(String dbName) {
        DB db = null;
        db = getMongo().getDB(dbName);
        return db;
    }
    
    public static DBCollection getCollection(String dbName, String collectionName) {
        DBCollection collection = null;
        collection = getDb(dbName).getCollection(collectionName);
        return collection;
    }
    
    public static DBCollection getCollection(DB db, String collectionName) {
        DBCollection collection = null;
        collection = db.getCollection(collectionName);
        return collection;
    }
    
    public static void main(String[] args) {
        while (true) {
            try {
                DB db = Mongodb.getDb("test");
//                db.dropDatabase();
                DBCollection collection = Mongodb.getCollection(db, "collection1");
//                DBCollection collection = Mongodb.getCollection("test", "collection1");
                
                // 新增数据，方法1：
                DBObject dbo = new BasicDBObject();
                dbo.put("aa", Math.random());
                dbo.put("bb", "haha");
                collection.insert(dbo);
                
                // 新增数据，方法2：
                DBObject dbo2 = (DBObject) JSON.parse("{\"dd\":123}");
                collection.insert(dbo2);
                
                System.out.println(collection.count());
                
                DBObject dbo3 = collection.findOne();
                System.out.println(dbo3.toString());

                // 查询数据
                DBObject where1 = new BasicDBObject();
                where1.put("aa", new BasicDBObject("$gt", 0.5).append("$lt", 0.9));
                Pattern pattern = Pattern.compile("ha*", Pattern.CASE_INSENSITIVE);
                where1.put("bb", pattern);

                DBObject sort = new BasicDBObject();
                sort.put("aa", -1);
                DBCursor dbCursor = collection.find(where1).sort(sort).skip(2).limit(2);                
                while (dbCursor.hasNext()) {                    
                    System.out.println(dbCursor.next());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mongodb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

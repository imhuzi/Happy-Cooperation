/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hudongfenxiang.db;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @FileName : MongodbUtil.java
 * @Encoding : UTF-8
 * @Package : com.hudongfenxiang.db
 * @Link         :  http://imhuzi.net
 * @Created on   :  Oct 11, 2013, 11:48:58 PM
 * @Author       :  Huzi.Wang [huzi.wh@gmail.com]
 * @Version      :  1.0
 * @Copyright    :  Copyright(c) 2013 http://imhuzi.net
 * @Description  :
 *
 */
public class MongodbUtil {

    /**
     * 根据ｉｄ判断是否存在
     *
     * @param db
     * @param col
     * @param id
     * @return
     */
    public static boolean isExistsById(String db, String col, long id) {
        boolean result = false;
        DBCollection collection = Mongodb.getCollection(db, col);

        DBObject where = new BasicDBObject();
        where.put("id", id);
        DBObject dbObject = collection.findOne(where);
        if (dbObject != null) {
            result = true;
        }

        return result;
    }

    /**
     * 将一个json 转成ＤＢObject
     *
     * @param jsonArray
     * @return
     */
    public static DBObject jsonArrayToDBObject(JSONArray jsonArray) {
        BasicDBList result = new BasicDBList();
        try {
            for (int i = 0; i < jsonArray.size(); ++i) {
                Object o = jsonArray.get(i);
                if (o instanceof JSONObject) {
                    result.add(jsonArrayToDBObject((JSONObject) o));
                } else if (o instanceof JSONArray) {
                    result.add(jsonArrayToDBObject((JSONArray) o));
                } else {
                    result.add(o);
                }
            }
            return result;
        } catch (JSONException je) {
            return null;
        }
    }

    /**
     * 将jsonAraay转成DBObject
     *
     * @param jsonObject
     * @return
     */
    public static DBObject jsonArrayToDBObject(JSONObject jsonObject) {
        BasicDBObject result = new BasicDBObject();
        try {
            Iterator i = jsonObject.keys();
            while (i.hasNext()) {
                String k = (String) i.next();
                Object v = jsonObject.get(k);
                if (v instanceof JSONArray) {
                    result.put(k, jsonArrayToDBObject((JSONArray) v));
                } else if (v instanceof JSONObject) {
                    result.put(k, jsonArrayToDBObject((JSONObject) v));
                } else {
                    result.put(k, v);
                }
            }
            return result;
        } catch (JSONException je) {
            return null;
        }
    }

    /**
     * 将一个Object转成DBObject
     *
     * @param obj
     * @return
     */
    public static DBObject objectToDBObject(Object obj) {
        DBObject dbo = new BasicDBObject();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(obj);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            dbo.put(field.getName(), value);
        }
        return dbo;
    }

    /**
     * 将Object 指定的fields转成DBObject
     *
     * @param obj
     * @param fields
     * @return
     */
    public static DBObject objectToDBObject(Object obj, String fields) {
        DBObject dbo = new BasicDBObject();
        String[] arrFields = fields.split(",");
        for (String fieldName : arrFields) {
            Field field = null;
            try {
                field = obj.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (field != null) {
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(MongodbUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
                dbo.put(fieldName, value);
            }
        }
        return dbo;
    }
}

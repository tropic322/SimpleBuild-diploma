package ru.sfedu.builder.api;

import java.util.Optional;


import com.google.gson.Gson;
import ru.sfedu.builder.Constants;
import ru.sfedu.builder.utils.HistoryContent;
import com.mongodb.MongoCommandException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public interface IDataProvider {
    <T> boolean insert(T object);
    <T> Optional<T> getById(Class<T> tClass, long id);
    <T> boolean update(T object);
    <T> boolean delete(T object);

    /////////////////////UTILS//////////////////////////////////////////////////

    /**
     *метод для сохранения истории операций с объектом класса в MongoDB
     *
     * @param className имя класса, в котором проводились изменения
     * @param methodName имя метода, в котором проводились изменения
     * @param status Статус операции (SUCSESS или FAULT)
     * @param json json представление объекта
     * @return
     */
    static boolean saveHistory(String className, String methodName, HistoryContent.Status status, String json){
        try (
                MongoClient mongoClient = new MongoClient();){
            MongoDatabase database = mongoClient.getDatabase(Constants.DATABASE_NAME);
            try{
                database.createCollection(Constants.COLLECTION_NAME);
            } catch (MongoCommandException ignored) {}
            String date = new SimpleDateFormat(Constants.MONGO_DATE_PATTERN).format(new Date());
            HistoryContent historyContent = new HistoryContent(className,methodName, date, status, json);
            MongoCollection<Document> collection = database.getCollection(Constants.COLLECTION_NAME);
            collection.insertOne(Document.parse(new Gson().toJson(historyContent)));
        }
        return true;
    }
}

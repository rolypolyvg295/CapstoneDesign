package com.example.expirationdateapp.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Favorite.class, Product.class, Alarm.class}, version =  1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase{
    public abstract FavoriteDao favoriteDao();
    public abstract ProductDao productDao();
    public abstract AlarmDao alarmDao();

    private static final int NUMBER_OF_THREADS = 4;

    // db에 사용할 때 사용하는 thread pool
    final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
}

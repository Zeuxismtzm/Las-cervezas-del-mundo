package br.com.map.cervezas.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.com.map.cervezas.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract NewsDao newsDao();
}

package br.com.map.cervezas.data;

import androidx.room.Room;

import br.com.map.cervezas.App;
import br.com.map.cervezas.data.local.AppDatabase;
import br.com.map.cervezas.data.remote.NewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsRepository {

    private static final String REMOTE_API_URL = "https://api.punkapi.com/v2/";
    private static final String LOCAL_DB_NAME = "cervezas";
    private NewsApi remoteApi;
    private AppDatabase localDb;

    public NewsApi getRemoteApi() {
        return remoteApi;
    }

    public AppDatabase getLocalDb() {
        return localDb;
    }

    private NewsRepository () {

        //instancia para datos online
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsApi.class);

        //instancia para datos de forma local
        localDb = Room.databaseBuilder(App.getInstance(), AppDatabase.class, LOCAL_DB_NAME).build();
    }

    public static NewsRepository getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final NewsRepository INSTANCE = new NewsRepository();
    }
}

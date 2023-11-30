package br.com.map.cervezas.data.remote;

import java.util.List;

import br.com.map.cervezas.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("beers?page=1")
    Call<List<News>> getNews();
}

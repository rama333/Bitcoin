package a4c.bitcoin.model.api;

import java.util.List;

import a4c.bitcoin.model.DataModel;
import a4c.bitcoin.model.HistoryCoinModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ramil on 03.06.2016.
 */
public interface ApiInterface {
    @GET("ticker/")
    Call<List<DataModel>> getCoins(@Query("limit") int limit);

    @GET("historical/close.json")
    Call<HistoryCoinModel> getHistoryCoins();

}

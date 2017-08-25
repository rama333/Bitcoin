package a4c.bitcoin.presenter;

import java.util.ArrayList;
import java.util.List;

import a4c.bitcoin.model.DataModel;
import a4c.bitcoin.model.api.ApiFactory;
import a4c.bitcoin.model.api.ApiInterface;
import a4c.bitcoin.view.CoinView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramil on 24.08.2017.
 */

public class CoinPresenter {

    ApiInterface apiInterface = ApiFactory.getRetrofitInstance("https://api.coinmarketcap.com/v1/").create(ApiInterface.class);
    CoinView coinView;

    private List<DataModel> dataModels = new ArrayList<>();

    public CoinPresenter(CoinView coinView) {
        this.coinView = coinView;
    }

    public void showCoin() {
        Call<List<DataModel>> call = apiInterface.getCoins(10);
        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                for (int i = 0; i < response.body().size(); i++) {
                    if(i==0 || i == 1 || i == 4)
                        dataModels.add(response.body().get(i));
                }
                coinView.showList(dataModels);
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                coinView.showError("error");
            }
        });

    }
}

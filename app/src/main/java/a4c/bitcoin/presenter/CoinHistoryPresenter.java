package a4c.bitcoin.presenter;

import java.util.ArrayList;
import java.util.List;

import a4c.bitcoin.model.DataModel;
import a4c.bitcoin.model.HistoryCoinModel;
import a4c.bitcoin.model.api.ApiFactoryHistory;
import a4c.bitcoin.model.api.ApiInterface;
import a4c.bitcoin.view.CoinViewHostory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ramil on 25.08.2017.
 */

public class CoinHistoryPresenter {
    ApiInterface apiInterface = ApiFactoryHistory.getRetrofitInstance("https://api.coindesk.com/v1/bpi/").create(ApiInterface.class);
    CoinViewHostory coinView;

    private List<DataModel> dataModels = new ArrayList<>();

    public CoinHistoryPresenter(CoinViewHostory coinView) {
        this.coinView = coinView;
    }

    public void showCoin() {
        Call<HistoryCoinModel> call = apiInterface.getHistoryCoins();
        call.enqueue(new Callback<HistoryCoinModel>() {
            @Override
            public void onResponse(Call<HistoryCoinModel> call, Response<HistoryCoinModel> response) {
                List<Double> list = new ArrayList<Double>(response.body().getHistory().values());

                coinView.showList(list);
            }

            @Override
            public void onFailure(Call<HistoryCoinModel> call, Throwable t) {
                coinView.showError("error");
            }
        });

    }
}

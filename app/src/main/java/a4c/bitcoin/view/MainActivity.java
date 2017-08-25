package a4c.bitcoin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import a4c.bitcoin.R;
import a4c.bitcoin.model.DataModel;
import a4c.bitcoin.presenter.CoinPresenter;
import a4c.bitcoin.view.adapters.CoinAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CoinView {

    @BindView(R.id.rv) RecyclerView recyclerView;
    CoinAdapter coinAdapter;

    private CoinPresenter coinPresenter = new CoinPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().setTitle("Currency");

        List<DataModel> list = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        coinAdapter = new CoinAdapter(list, this);

        recyclerView.setAdapter(coinAdapter);

        coinPresenter.showCoin();
    }

    @Override
    public void showList(List<DataModel> list) {
        coinAdapter.add(0, list);
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    private void  makeToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();

    }
}

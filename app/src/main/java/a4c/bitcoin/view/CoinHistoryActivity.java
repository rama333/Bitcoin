package a4c.bitcoin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import a4c.bitcoin.R;
import a4c.bitcoin.presenter.CoinHistoryPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ramil on 25.08.2017.
 */

public class CoinHistoryActivity extends AppCompatActivity implements CoinViewHostory{

    public static final String EXTRA_INFO = "TAG";
    public static final String EXTRA_INFO1 = "TAG1";
    @BindView(R.id.lineChart) LineChart lineChart;
    @BindView(R.id.course) TextView cours;
    @BindView(R.id.coin) TextView coin;
    CoinHistoryPresenter coinHistoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_activity);
        coinHistoryPresenter = new CoinHistoryPresenter(this);
        ButterKnife.bind(this);
        actionBar();



        String coint = getIntent().getStringExtra(EXTRA_INFO);
        String coinName = getIntent().getStringExtra(EXTRA_INFO1);
        coin.setText(coinName + " (" + coint + ")");
        if(coint.equals("BTC"))
            coinHistoryPresenter.showCoin();
        else {
            cours.setText("Данный функционал будет добавлен позже");
            cours.setTextSize(15);
        }
    }


    private void actionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showList(List<Double> list) {

        List<Entry> entries = new ArrayList<>();

        Collections.reverse(list);

        cours.setText("1 BTC = "+ list.get(0).intValue() +" $");


        int j = 9;
        for (int i = 0; i <= 9; i++) {
            entries.add(new Entry(i, list.get(j).floatValue()));
            j--;
        }

        LineDataSet lineDataSet = new LineDataSet(entries, "Course");
        //lineDataSet.setFillColor(R.color.line);
        //lineDataSet.setColor(R.color.line);

        lineDataSet.setDrawCircles(true);

        lineDataSet.setColor(getResources().getColor(R.color.line));
        lineDataSet.setCircleColor(getResources().getColor(R.color.line));

        LineData lineData = new LineData(lineDataSet);
        lineChart.getAxisRight().setEnabled(false);
        lineChart.getXAxis().setEnabled(false);
        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    private void  makeToast(String text) {
        Toast.makeText(CoinHistoryActivity.this, text, Toast.LENGTH_LONG).show();

    }
}

package a4c.bitcoin.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import a4c.bitcoin.R;
import a4c.bitcoin.model.DataModel;
import a4c.bitcoin.view.CoinHistoryActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ramil on 24.08.2017.
 */

public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.ViewHolderCoin> {

    List<DataModel> dataModels;
    Context context;

    public CoinAdapter(List<DataModel> dataModels, Activity context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @Override
    public ViewHolderCoin onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View rowView = layoutInflater.inflate(R.layout.row_coin, parent, false);

        return new ViewHolderCoin(rowView);
    }

    @Override
    public void onBindViewHolder(ViewHolderCoin holder, int position) {
        holder.coinName.setText(dataModels.get(position).getNameCoin());
        holder.coin.setText(dataModels.get(position).getCoim());

        Integer img = null;

        if (position == 0)
           img = R.drawable.ic_bitcoin_40;
        if (position == 1)
           img = R.drawable.ic_ethereum_40;
        if (position == 2)
            img = R.drawable.ic_litecoin_40;

        holder.imageView.setImageResource(img);

        holder.itemView.setOnClickListener(view -> {
            startHistoryActivity(dataModels.get(position).getCoim(), dataModels.get(position).getNameCoin() );
        });
    }

    private void startHistoryActivity(String coin, String nameCoin) {
        Intent intent = new Intent(context, CoinHistoryActivity.class);
        intent.putExtra(CoinHistoryActivity.EXTRA_INFO, coin);
        intent.putExtra(CoinHistoryActivity.EXTRA_INFO1, nameCoin);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public void add(int i, List<DataModel> list) {
        dataModels.addAll(i, list);
        notifyItemRangeChanged(i, list.size());
    }

    public class ViewHolderCoin extends RecyclerView.ViewHolder{

        @BindView(R.id.coinname) TextView coinName;
        @BindView(R.id.coint) TextView coin;
        @BindView(R.id.coinimg) ImageView imageView;


        public ViewHolderCoin(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

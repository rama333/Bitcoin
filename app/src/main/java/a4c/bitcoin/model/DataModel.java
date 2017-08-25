package a4c.bitcoin.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ramil on 24.08.2017.
 */

public class DataModel {


    @SerializedName("name")
    String nameCoin;
    @SerializedName("symbol")
    String coim;
    @SerializedName("rank")
    Integer rank;

    public String getNameCoin() {
        return nameCoin;
    }

    public void setNameCoin(String nameCoin) {
        this.nameCoin = nameCoin;
    }

    public String getCoim() {
        return coim;
    }

    public void setCoim(String coim) {
        this.coim = coim;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public DataModel(String nameCoin, String coim, Integer rank) {

        this.nameCoin = nameCoin;
        this.coim = coim;
        this.rank = rank;
    }
}

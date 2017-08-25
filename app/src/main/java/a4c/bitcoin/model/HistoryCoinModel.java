package a4c.bitcoin.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Created by Ramil on 25.08.2017.
 */

public class HistoryCoinModel {
    @SerializedName("bpi")
    Map<String, Double> history;

    public Map<String, Double> getHistory() {
        return history;
    }

    public void setHistory(Map<String, Double> history) {
        this.history = history;
    }

    public HistoryCoinModel(Map<String, Double> history) {

        this.history = history;
    }
}

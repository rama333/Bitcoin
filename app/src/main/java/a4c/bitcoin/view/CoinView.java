package a4c.bitcoin.view;

import java.util.List;

import a4c.bitcoin.model.DataModel;

/**
 * Created by Ramil on 24.08.2017.
 */

public interface CoinView {

    void showList(List<DataModel> list);
    void showError(String error);
}

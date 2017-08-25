package a4c.bitcoin.view;

import java.util.List;

/**
 * Created by Ramil on 25.08.2017.
 */

public interface CoinViewHostory {
    void showList(List<Double> list);
    void showError(String error);
}

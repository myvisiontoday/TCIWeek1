import org.graalvm.compiler.loop.MathUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {
    private List<Double> data;
    public BasicStatistic() {
        data = new ArrayList<>();
    }

    @Override
    public void addDoubleToData(Double valueToAdd){
        this.data.add(valueToAdd);
    }

    @Override
    public void clearData(){
        data.clear();
    };
	
    @Override
    public int numberOfDataItems(){
        int rv = data.size();
        return rv;
    }

    @Override
    public Double sum(){
        Double total = 0.0;
        for (Double i: data) {
            total += i;
        }
        return total;
    }

}

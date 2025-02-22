package gherkinexecutor.Feature_Examples;

import java.util.ArrayList;
import java.util.List;


public class SolutionForListOfNumber {
    private final List<LabelValueInternal> values = new ArrayList <>();
    private String filterValue = "";
    void add(LabelValueInternal value) {
        values.add(value);
    }

    void setFilterValue(String value) {
        filterValue = value;
    }

    int sum(){
        var sum = 0;
        for (LabelValueInternal element : values) {
            if (element.label.equals(filterValue))
                sum += (element.value);
        }
        return sum;
    }
}

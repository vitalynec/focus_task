package com.vitane.focustask.service.comparator.string;

import com.vitane.focustask.service.comparator.Comparator;
import com.vitane.focustask.io.reader.Reader;

public interface StringComparator extends Comparator {
    default String getValue(Reader flow) {
        String value;

        if (flow.isFlowOver()) {
            return "";
        }
        try {
            value = flow.pickCurrentItem();
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " " + "(Не удается распознать элемент)");
            value = getValue(flow);
        }
        return value;
    }
}

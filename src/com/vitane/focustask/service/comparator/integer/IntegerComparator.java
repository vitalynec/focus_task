package com.vitane.focustask.service.comparator.integer;

import com.vitane.focustask.io.reader.Reader;
import com.vitane.focustask.service.comparator.Comparator;

public interface IntegerComparator extends Comparator {

    default String getValue(Reader flow) {
        return String.valueOf(getValidInt(flow));
    }

    default int getValidInt(Reader flow) {
        int value;

        if (flow.isFlowOver()) {
            return 0;
        }
        try {
            value = Integer.parseInt(flow.pickCurrentItem());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + " " + "(Не удается распознать элемент)");
            value = getValidInt(flow);
        }
        return value;
    }
}

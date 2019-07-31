package com.vitane.focustask.io.reader;

public interface Reader {
    String getCurrentItem();
    String pickCurrentItem();
    boolean isFlowOver();
}

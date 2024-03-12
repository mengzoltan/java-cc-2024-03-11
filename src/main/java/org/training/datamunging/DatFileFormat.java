package org.training.datamunging;

public interface DatFileFormat <T>{
    boolean isProcessableRow(String line);
    T createWeather(String line);

    int getSkippingLines();

    int getComperator(T t, T t1);
}

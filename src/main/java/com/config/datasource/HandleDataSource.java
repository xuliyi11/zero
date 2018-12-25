package com.config.datasource;

public class HandleDataSource {

    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSourceType(String dataSourceType) {
        holder.set(dataSourceType);
    }

    public static String getDataSourceType() {
        return holder.get();
    }

}

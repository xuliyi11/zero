package com.config.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    //返回数据源
    protected Object determineCurrentLookupKey() {


        LOGGER.error("dataSourceType:{}", HandleDataSource.getDataSourceType());

        return HandleDataSource.getDataSourceType();
    }

}

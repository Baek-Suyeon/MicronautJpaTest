package com.ipageon.service;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.event.ApplicationStartupEvent;
import jakarta.inject.Singleton;

import javax.sql.DataSource;
import java.sql.SQLException;

@Singleton
public class DataSourceConnectService implements ApplicationEventListener<ApplicationStartupEvent> {

    private final HikariDataSource hikariDataSource;

    public DataSourceConnectService(DataSource dataSource) throws SQLException {
        this.hikariDataSource = dataSource.unwrap(HikariDataSource.class);
    }

    @Override
    public void onApplicationEvent(ApplicationStartupEvent event) {
        // HikariDataSource를 이용해 totalconnect 연결 수행
        try {
            logConnectionStatus();
        } catch (Exception e) {
            System.err.println("Error connecting to totalconnect: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void logConnectionStatus() {
        // HikariDataSource의 Pool 상태 가져오기
        HikariPoolMXBean poolMXBean = hikariDataSource.getHikariPoolMXBean();
        if (poolMXBean != null) {
            System.out.println("Active Connections: " + poolMXBean.getActiveConnections());
            System.out.println("Idle Connections: " + poolMXBean.getIdleConnections());
            System.out.println("Total Connections: " + poolMXBean.getTotalConnections());
            System.out.println("Threads Awaiting Connection: " + poolMXBean.getThreadsAwaitingConnection());
        } else {
            System.out.println("HikariPoolMXBean is not available.");
        }
    }
}
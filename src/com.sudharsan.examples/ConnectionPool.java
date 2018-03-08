package com.sudharsan.examples;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private final String userName;
    private final String url;
    private final String password;

    private final List<PoolConnection> connections;

    public ConnectionPool(final String url, final String userName, final String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
        this.connections = new ArrayList<>();
    }


    static class PoolConnection {
        protected Connection connection;

        protected long timeOpened;

        protected long timeClosed;

        protected boolean inUse;

        PoolConnection(final Connection connection) {
            this.connection = connection;
            inUse = false;

        }
    }
}


package com.grtanner.logentry.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author glen on 07/14/2021
 */
@Entity
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ipAddr;
    private String userId;
    private String username;
    private String timestamp;
    private String request;
    private String source;
    private String statusCode;
    private String bytesSent;
    private String referer;
    private String userAgent;

    // NoArg constructors makes JPA happy
    protected LogEntry() {}

    // Private constructor
    private LogEntry(LogEntryBuilder builder) {
        this.id = builder.id;
        this.ipAddr = builder.ipAddr;
        this.userId = builder.userId;
        this.username = builder.username;
        this.timestamp = builder.timestamp;
        this.request = builder.request;
        this.source = builder.source;
        this.statusCode = builder.statusCode;
        this.bytesSent = builder.bytesSent;
        this.referer = builder.referer;
        this.userAgent = builder.userAgent;
    }

    //No setters to promote immutability
    public Long getId() {
        return id;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getRequest() {
        return request;
    }

    public String getSource() {
        return source;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getBytesSent() {
        return bytesSent;
    }

    public String getReferer() {
        return referer;
    }

    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public String toString() {
        return "LogEntry: "
                + "id=" + id
                + ", ipAddr=" + ipAddr
                + ", userId=" + userId
                + ", username=" + username
                + ", timestamp=" + timestamp
                + ", request=" + request
                + ", source=" + source
                + ", statusCode=" + statusCode
                + ", bytesSent=" + bytesSent
                + ", referer=" + referer
                + ", userAgent=" + userAgent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntry logEntry = (LogEntry) o;

        if (id != null ? !id.equals(logEntry.id) : logEntry.id != null) return false;
        return username != null ? username.equals(logEntry.username) : logEntry.username == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static class LogEntryBuilder {
        // For now, ipAddr, timestamp, request, and source are mandatory
        private Long id;
        private String ipAddr;
        private String userId;
        private String username;
        private String timestamp;
        private String request;
        // By providing a request, we can parse out the endpoint
        private String source;
        private String statusCode;
        private String bytesSent;
        private String referer;
        private String userAgent;

        public LogEntryBuilder(String ipAddr, String timestamp, String source) {
            this.ipAddr = ipAddr;
            this.timestamp = timestamp;
            this.source = source;
        }

        public LogEntryBuilder ipAddress(String ipAddr) {
            this.ipAddr = ipAddr;
            return this;
        }

        public LogEntryBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public LogEntryBuilder username(String username) {
            this.username = username;
            return this;
        }

        public LogEntryBuilder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public LogEntryBuilder request(String request) {
            this.request = request;
            return this;
        }

        public LogEntryBuilder source(String source) {
            this.source = source;
            return this;
        }

        public LogEntryBuilder statusCode(String statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public LogEntryBuilder bytesSent(String bytesSent) {
            this.bytesSent = bytesSent;
            return this;
        }

        public LogEntryBuilder referer(String referer) {
            this.referer = referer;
            return this;
        }

        public LogEntryBuilder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        //Return the built LogEntry object
        public LogEntry build() {
            LogEntry record =  new LogEntry(this);
            validateLogEntryObject(record);
            return record;
        }

        private void validateLogEntryObject(LogEntry entry) {
        }
    }
}

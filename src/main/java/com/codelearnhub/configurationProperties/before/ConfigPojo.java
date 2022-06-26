package com.codelearnhub.configurationProperties.before;

import java.util.Objects;
//
//@Configuration
//@ConfigurationProperties("api")
public class ConfigPojo {

    private int numberOfThreads;
    private int timeout;


    public int getNumberOfThreads() {
        return numberOfThreads;
    }

    public void setNumberOfThreads(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof ConfigPojo)) return false;
        ConfigPojo configPojo = (ConfigPojo) o;
        return numberOfThreads == configPojo.numberOfThreads && timeout == configPojo.timeout;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfThreads, timeout);
    }

    @Override
    public String toString() {
        return "ConfigPojo{" +
                "numberOfThreads=" + numberOfThreads +
                ", timeout=" + timeout +
                '}';
    }
}

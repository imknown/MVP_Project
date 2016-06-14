package com.example.darkwh.mvp_project.entity;

/**
 * Created by darkwh on 2016/6/12.
 */
public class BaseEntity<T> {

    private boolean error;

    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}

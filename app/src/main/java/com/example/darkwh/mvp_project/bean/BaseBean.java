package com.example.darkwh.mvp_project.bean;

/**
 * Created by darkwh on 2016/6/12.
 */
public class BaseBean<T> {

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

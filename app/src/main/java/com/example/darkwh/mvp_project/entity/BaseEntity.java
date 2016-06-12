package com.example.darkwh.mvp_project.entity;

import java.util.List;

/**
 * Created by darkwh on 2016/6/12.
 */
public class BaseEntity<T> {

    private boolean error;

    private List<T> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}

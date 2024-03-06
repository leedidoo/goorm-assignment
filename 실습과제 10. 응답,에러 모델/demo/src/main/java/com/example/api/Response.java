package com.example.api;

import java.util.List;

public class Response<T> {
    private Status status;
    private Metadata metadata;
    private List<T> result;

    public Response(Status status, Metadata metadata, List<T> result) {
        this.status = status;
        this.metadata = metadata;
        this.result = result;
    }

    public Status getStatus() {
        return status;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public List<T> getResult() {
        return result;
    }
}
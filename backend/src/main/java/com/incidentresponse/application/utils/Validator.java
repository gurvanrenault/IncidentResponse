package com.incidentresponse.application.utils;

public interface Validator<T> {

    boolean isValid(T obj);
}

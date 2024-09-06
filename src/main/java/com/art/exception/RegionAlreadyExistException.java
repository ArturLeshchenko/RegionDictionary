package com.art.exception;

public class RegionAlreadyExistException extends RuntimeException {
    public RegionAlreadyExistException() {
        super("Region already exist");
    }
}

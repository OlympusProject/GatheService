package com.gathe.community.exception;

import com.gathe.community.resource.RestResource;

public class BadResourceConversionException extends RuntimeException {

    private static String MSG_PLACEHOLDER = "{_class_name_}";
    private static String EMPTY_RESOURCE_MSG = "Resource conversion failed.";
    private static String DEFAULT_MSG = "Conversion {_class_name_} resource failed.";


    // -- members ----------------------------------------------------------------------------------
    protected RestResource resource;






    // -- constructors ------------------------------------------------------------------------------
    public BadResourceConversionException() {
        super(EMPTY_RESOURCE_MSG);
    }

    public BadResourceConversionException(Throwable cause) {
        super(EMPTY_RESOURCE_MSG, cause);
    }

    public BadResourceConversionException(RestResource resource) {
        super(DEFAULT_MSG.replace(MSG_PLACEHOLDER, resource.getClass().getSimpleName()));
        this.resource = resource;
    }

    public BadResourceConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadResourceConversionException(String message, RestResource resource) {
        super(message);
        this.resource = resource;
    }

    public BadResourceConversionException(String message, RestResource resource, Throwable cause) {
        super(message, cause);
        this.resource = resource;
    }





    // -- getters & setters -------------------------------------------------------------------------
    public RestResource getResource() {
        return resource;
    }

    public void setResource(RestResource resource) {
        this.resource = resource;
    }
}

package com.ds2.pcf;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Default model to provide REST response data.
 */
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class RestResponse<T> implements Serializable {

    private static final long serialVersionUID = 1920839053060139537L;

    private String httpStatusCode;
    private String sessionID;
    private String currentTimeStamp;
    private T subject;
}

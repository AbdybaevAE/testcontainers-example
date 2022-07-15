package kz.abdybayev.testcontainersexample.testcontainersdemo.utils;

import lombok.Getter;

@Getter
public class ResponseStatus {
    private StatusCode statusCode;
    private String statusMessage;

    public static ResponseStatus ok() {
        var response = new ResponseStatus();
        response.statusCode = StatusCode.OK;
        response.statusMessage = KnownMessages.OK;
        return response;
    }
}

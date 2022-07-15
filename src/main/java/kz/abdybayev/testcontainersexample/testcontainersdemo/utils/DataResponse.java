package kz.abdybayev.testcontainersexample.testcontainersdemo.utils;

import lombok.Getter;

@Getter
public class DataResponse {
    private StatusCode statusCode;
    private String statusMessage;
    private Object data;

    private DataResponse() {

    }

    public static DataResponse ok(Object data) {
        var response = new DataResponse();
        response.statusCode = StatusCode.OK;
        response.statusMessage = KnownMessages.OK;
        response.data = data;
        return response;
    }
}

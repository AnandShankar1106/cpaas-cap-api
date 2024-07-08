package com.sinch.cpass.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseMessage {
    private Integer statusCode;
    private String error;
    private String message;
 

    public static ResponseMessage okMessage(String message) {
	ResponseMessage responseMessage = new ResponseMessage();
	responseMessage.setStatusCode(200);
	responseMessage.setMessage(message);
	return responseMessage;
    }

    public static ResponseMessage errorMessage(String error) {
	ResponseMessage responseMessage = new ResponseMessage();
	responseMessage.setError(error);
	responseMessage.setStatusCode(400);
	return responseMessage;
    }
}

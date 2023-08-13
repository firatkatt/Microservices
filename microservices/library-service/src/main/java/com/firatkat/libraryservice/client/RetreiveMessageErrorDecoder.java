package com.firatkat.libraryservice.client;

import com.firatkat.libraryservice.exception.ExceptionMessage;
import com.firatkat.libraryservice.exception.NotFoundBookException;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        ExceptionMessage message = null;
        try(InputStream body = response.body().asInputStream()){
            message = new ExceptionMessage((String) response.headers().get("date").toArray()[0],
                    response.status(),
                    HttpStatus.resolve(response.status()).getReasonPhrase(),
                    IOUtils.toString(body, StandardCharsets.UTF_8),
                    response.request().url());
        }catch(IOException exception){
            return new Exception(exception.getMessage());
        }
        switch(response.status()){
            case 404:
                throw new NotFoundBookException(message);
            default:
                return errorDecoder.decode(s,response);
        }
    }
}

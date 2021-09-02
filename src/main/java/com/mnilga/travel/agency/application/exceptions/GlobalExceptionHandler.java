package com.mnilga.travel.agency.application.exceptions;

import com.mnilga.travel.agency.application.dto.HandlerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<HandlerResponseDto> handleResourceNotFoundException(Exception e, WebRequest request) {
        HandlerResponseDto handlerResponseDto = new HandlerResponseDto();
        handlerResponseDto.setStatus(HttpStatus.NOT_FOUND.value());
        handlerResponseDto.setMessage(e.getMessage());
        handlerResponseDto.setTimestamp(LocalDateTime.now());

        LOGGER.warn("Resource not found exception: {}", e.getMessage());
        return new ResponseEntity<>(handlerResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ValidationException.class})
    public ResponseEntity<HandlerResponseDto> handleValidationException(Exception e, WebRequest request) {
        HandlerResponseDto handlerResponseDto = new HandlerResponseDto();
        handlerResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
        handlerResponseDto.setMessage(e.getMessage());
        handlerResponseDto.setTimestamp(LocalDateTime.now());

        LOGGER.warn("Validation exception: {}", e.getMessage());
        return new ResponseEntity<>(handlerResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<HandlerResponseDto> handleAnotherException(Exception ex, WebRequest request) {
        HandlerResponseDto handlerResponseDto = new HandlerResponseDto();
        handlerResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        handlerResponseDto.setMessage(ex.getMessage());
        handlerResponseDto.setTimestamp(LocalDateTime.now());

        LOGGER.error(ex.getMessage(), ex);
        return new ResponseEntity<>(handlerResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

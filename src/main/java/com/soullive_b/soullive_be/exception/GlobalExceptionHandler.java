package com.soullive_b.soullive_be.exception;

import com.soullive_b.soullive_be.exception.dto.ExceptionResponse;
import jakarta.annotation.Priority;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.soullive_b.soullive_be.exception.ExceptionContent.NOT_EMAIL;
import static com.soullive_b.soullive_be.exception.ExceptionContent.NULL_INFORMATION;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handle(CustomException exception) {
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(ExceptionResponse.of(exception.getContent()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse handle_MethodArgumentNotValidException(
            MethodArgumentNotValidException e
    ){
        return makeErrorResponse(e.getBindingResult());
    }

    private ExceptionResponse makeErrorResponse(BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            String description = bindingResult.getFieldError().getDefaultMessage();
            String bindAnnotation = bindingResult.getFieldError().getCode();

            String errorContent = description.split(" : ")[1];
            if(bindAnnotation.equals("NotBlank")){
                return makeResponse(errorContent, NULL_INFORMATION.getCode());
            }
            if(bindAnnotation.equals("Email")){
                return makeResponse(errorContent, NOT_EMAIL.getCode());
            }
        }
        return null;
    }

    /**
     * validation 어노테이션 에러 응답 만들기 메소드
     * @return
     */
    private ExceptionResponse makeResponse(String message, Integer code){

        return new ExceptionResponse(message, code);
    }
}

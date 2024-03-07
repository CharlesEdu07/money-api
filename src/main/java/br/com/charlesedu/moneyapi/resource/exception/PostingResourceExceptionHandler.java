package br.com.charlesedu.moneyapi.resource.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.charlesedu.moneyapi.exceptionhandler.MoneyApiExceptionHandler.Error;
import br.com.charlesedu.moneyapi.service.exception.InactiveOrNonExistentPersonException;

@ControllerAdvice
public class PostingResourceExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler({ InactiveOrNonExistentPersonException.class })
    public ResponseEntity<Object> handleInactiveOrNonExistentPersonException(InactiveOrNonExistentPersonException ex) {
        String userMessage = messageSource.getMessage("person.inactive-or-non-existent", null,
                LocaleContextHolder.getLocale());
        String devMessage = ex.toString();

        List<Error> errors = Arrays.asList(new Error(userMessage, devMessage));

        return ResponseEntity.badRequest().body(errors);
    }
}

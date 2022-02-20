package demo.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import demo.response.JustResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler( CustomedException.class )
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public JustResponse handleException(CustomedException exception) {
        LOGGER.warn("===> Exception captured!!");
        JustResponse r = new JustResponse("1000", "Exception captured message!!");
        return r;
    }

}

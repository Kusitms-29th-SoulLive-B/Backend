package com.soullive_b.soullive_be;

import com.soullive_b.soullive_be.exception.notfound.NotFoundException;
import com.soullive_b.soullive_be.exception.notfound.NotFoundUserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "hello!";
    }

    @GetMapping("/test_exception")
    public void testException(){
        throw new NotFoundUserException();
    }
}

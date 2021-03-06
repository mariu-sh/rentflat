package com.mariuszf.rentflat.flatroomservice.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Flat not found")
public class FlatNotFoundException extends RuntimeException {
}

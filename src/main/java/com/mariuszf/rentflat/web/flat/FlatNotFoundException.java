package com.mariuszf.rentflat.web.flat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Flat not found")
public class FlatNotFoundException extends RuntimeException {
}

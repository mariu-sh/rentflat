package com.mariuszf.rentflat.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Room not found")
public class RoomNotFoundException extends RuntimeException {
}
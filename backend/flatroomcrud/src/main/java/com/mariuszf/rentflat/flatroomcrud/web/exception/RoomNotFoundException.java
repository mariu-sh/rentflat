package com.mariuszf.rentflat.flatroomcrud.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Room not found")
public class RoomNotFoundException extends RuntimeException {
}

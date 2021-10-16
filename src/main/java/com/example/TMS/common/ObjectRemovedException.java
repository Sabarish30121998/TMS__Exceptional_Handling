package com.example.TMS.common;

import lombok.Data;

@Data
public class ObjectRemovedException extends RuntimeException{

    public ObjectRemovedException(String message)
    {
        super(message);
    }
}

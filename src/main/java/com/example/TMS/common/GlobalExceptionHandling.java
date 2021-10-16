package com.example.TMS.common;

import com.example.TMS.BaseResponse.ApiRes;
import com.example.TMS.BaseResponse.BaseResponse;
import org.hibernate.ObjectDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity gotArithematicException(ArithmeticException e)
    {
        BaseResponse baseResponse= new BaseResponse();
        baseResponse.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
        baseResponse.setStatusmessage("Oops Something wents Wrong");
        baseResponse.setData("Arithematic Exception was Thrown");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
    }


    @ExceptionHandler
    public ResponseEntity WrongRole(AccessDeniedException e)
    {
//        ApiRes apiRes= null;
//        apiRes.setStatuscode(HttpStatus.FORBIDDEN.toString());
//        apiRes.setStausmessage("Oops Something Wents Wrong");
//        apiRes.setError("This user have No permission to access to these API");
//        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(apiRes);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatuscode("403");
        baseResponse.setStatusmessage("Oops Something Wents Wrong");
        baseResponse.setData("This user have No permission to access to these API(AccessDeniedException)");
        return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(baseResponse);
    }

    @ExceptionHandler
    public ResponseEntity IdNotFoundException(UsernameNotFoundException e)
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatuscode("400");
        baseResponse.setStatusmessage("Oops something Went Wrong");
        baseResponse.setData(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse);
    }



    @ExceptionHandler
    public ResponseEntity deletedIDException(ObjectRemovedException e)
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatuscode("400");
        baseResponse.setStatusmessage("Oops something Went Wrong");
        baseResponse.setData(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(baseResponse);
    }


    @ExceptionHandler
    public ResponseEntity runException(RuntimeException e)
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatuscode("Something Wrong");
        baseResponse.setStatusmessage("Oops something Went Wrong");
        baseResponse.setData(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(baseResponse);
    }


    /*@ExceptionHandler
    public ResponseEntity genericException(Exception e)
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatuscode("Something Wrong");
        baseResponse.setStatusmessage("Oops something Went Wrong");
        baseResponse.setData("500");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(baseResponse);
    }*/

}

package com.cristian.tiusers.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing global handle exceptions")
class GlobalExceptionHandlerTest {

    @Mock
    private HttpServletRequest request;

    GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp(){
        exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    @DisplayName("Testing department not found exception")
    void testDepartmentNotFoundException() {
        var departmentNotFoundException = new DepartmentNotFoundException("Department not found");

        when(request.getRequestURI()).thenReturn("/api/departments");

        ResponseEntity<ApiError> response = exceptionHandler.departmentNotFound(departmentNotFoundException, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Department not found", Objects.requireNonNull(response.getBody()).message());
        assertEquals("/api/departments", response.getBody().path());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().statusCode());
    }

    @Test
    @DisplayName("Testing company not found exception")
    void testCompanyNotFoundException() {
        var companyNotFoundException = new CompanyNotFoundException("Company not found");
        when(request.getRequestURI()).thenReturn("/api/companies");

        ResponseEntity<ApiError> response = exceptionHandler.companyNotFound(companyNotFoundException, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Company not found", Objects.requireNonNull(response.getBody()).message());
        assertEquals("/api/companies", response.getBody().path());
    }

    @Test
    @DisplayName("Testing user not found exception")
    void testUserNotFoundException() {
        var userNotFoundException = new UserNotFoundException("User not found");
        when(request.getRequestURI()).thenReturn("/api/users");

        ResponseEntity<ApiError> response = exceptionHandler.userNotFoundException(userNotFoundException, request);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("User not found", Objects.requireNonNull(response.getBody()).message());
        assertEquals("/api/users", response.getBody().path());
    }


    @Test
    @DisplayName("Testing exception")
    void testException() {
        var exception = new Exception("Global Exception");
        when(request.getRequestURI()).thenReturn("/api/anyuri");

        ResponseEntity<ApiError> response = exceptionHandler.exception(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Global Exception", Objects.requireNonNull(response.getBody()).message());
        assertEquals("/api/anyuri", response.getBody().path());
    }



}
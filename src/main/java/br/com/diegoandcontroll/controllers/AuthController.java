package br.com.diegoandcontroll.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diegoandcontroll.dtos.AuthenticationRequest;
import br.com.diegoandcontroll.dtos.AuthenticationResponse;
import br.com.diegoandcontroll.dtos.RegisterRequest;
import br.com.diegoandcontroll.services.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthenticationService service;

  @PostMapping("/signup")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request) {
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/signin")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    service.refreshToken(request, response);
  }

}

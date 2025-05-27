package com.example.projetobd.exception;

public class FalhaDeIntegridade extends RuntimeException {
  public FalhaDeIntegridade(String message) {
    super(message);
  }
}

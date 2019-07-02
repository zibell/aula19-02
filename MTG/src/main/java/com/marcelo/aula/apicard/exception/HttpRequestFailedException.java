package com.marcelo.aula.apicard.exception;

import java.io.IOException;

import io.magicthegathering.javasdk.api.MTGAPI;

/**
 * Thrown by {@link MTGAPI} when an http request to magicthegathering.io API fails to return anything.
 * 
 * @author nniklas
 *
 */
public class HttpRequestFailedException extends RuntimeException {

	public HttpRequestFailedException(IOException e) {
		super(e);
	}

}

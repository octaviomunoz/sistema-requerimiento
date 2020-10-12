package com.sistema.requerimiento.utils;

public class Constantes {

	public static final String REQUEST_TOKEN_URL = "/login";

	public static final String AUTHORITIES_KEY = "CLAIM_TOKEN";

	public static final String SIGNING_KEY = "KEY_1234";

	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 3600 * 6; //Segundos * Horas

	public static final String ISSUER_TOKEN = "ISSUER";

	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";

	public static final String TOKEN_BEARER_PREFIX = "Bearer";

}

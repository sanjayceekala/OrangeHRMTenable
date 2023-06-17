package utils;

import java.util.Base64;

import lombok.NonNull;

public class SecurityUtil {

	/**
	 * To encrypt the string using base64 encoding
	 * @param textToEncrypt
	 * @return
	 */
	
	public static String encryptText(@NonNull String textToEncrypt) {
		byte[] bytes = Base64.getEncoder().encode(textToEncrypt.getBytes());
		return new String(bytes);
	}
	
	/**
	 * To decrypt the string using Base64 decoding
	 * @param textToDecrypt
	 * @return
	 */
	
	public static String decryptText(@NonNull String textToDecrypt) {
		
		byte[] bytes = Base64.getDecoder().decode(textToDecrypt.getBytes());
		return new String(bytes);
	}
}

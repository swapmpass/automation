package com.automation.ui.masterpass;

import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Enumeration;

import com.mastercard.sdk.core.MasterCardApiConfig;
import com.mastercard.sdk.core.models.RequestTokenResponse;
import com.mastercard.sdk.core.services.RequestTokenApi;

public class MasterPassCore {

	public static void main(String[] args) {
		PrivateKey privateKey = null;
		try {
			KeyStore ks = KeyStore.getInstance("PKCS12");
			ks.load(MasterPassCore.class.getClassLoader().getResourceAsStream("./MasterPassTest-1491198960-sandbox.p12"), "keystorepassword".toCharArray());
			Enumeration<String> aliases = ks.aliases();
			String keyAlias = "keyalias";

			while (aliases.hasMoreElements()) {
				keyAlias = (String) aliases.nextElement();
			}

			privateKey = (PrivateKey) ks.getKey(keyAlias, "keystorepassword".toCharArray());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//MasterCardApiConfig.setSandBox(false); // to use production environment
		MasterCardApiConfig.setSandBox(true); // to use sandbox environment
		MasterCardApiConfig.setConsumerKey("u0q46R3CKpCWj6nZlMb7DxZPany96qs3xyLIe7Ntb0919821!b7444550a563470d9995546ce27f560e0000000000000000");
		MasterCardApiConfig.setPrivateKey(privateKey);

		// Calling Service API
		RequestTokenResponse response = RequestTokenApi.create("https://sandbox.api.mastercard.com");
		System.out.println("OAuth Token" + response.getOauthToken());
	}

}

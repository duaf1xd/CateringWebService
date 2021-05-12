package util;
import java.io.IOException;

import org.apache.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import entity.GoogleEntity;
public class GoogleUtil {
	private static String GOOGLE_CLIENT_ID = "452337883638-22tg68p9t77us5lhaq1ah826dpr59dc7.apps.googleusercontent.com";
	private static String GOOGLE_CLIENT_SECRET = "MrqrKkxwvFC_6BiPsV9tNl-1";
	private static String GOOGLE_REDIRECT_URI = "http://localhost:8089/foodweb/homepage.jsp";
	private static String GOOGLE_LINK_TOKEN = "https://accounts.google.com/o/oauth2/token";
	private static String GOOGLE_LINK_USER_INFOR = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
	private static String GOOGLE_GRANT_TYPE = "authorization_code";
public static String getGoogleToken(final String code) throws ClientProtocolException, IOException {
	String response = Request.Post(GOOGLE_LINK_TOKEN).bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
			.add("client_secret", GOOGLE_CLIENT_SECRET)
			.add("redirect_uri", GOOGLE_REDIRECT_URI)
			.add("code", code)
			.add("grant_type", GOOGLE_GRANT_TYPE).build())
			.execute().returnContent().asString();
	JsonObject json = new Gson().fromJson(response, JsonObject.class);
	String accessToken = json.get("access_token").toString().replaceAll("\"", "");
	return accessToken;
}


public static GoogleEntity getUserInfor(final String accessToken) throws ClientProtocolException, IOException {
	String link = GOOGLE_LINK_USER_INFOR + accessToken;
	String response = Request.Get(link).execute().returnContent().asString();
	GoogleEntity google = new Gson().fromJson(response, GoogleEntity.class);
	return google;
}
}

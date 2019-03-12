package com.steamcommunity;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class SteamCommunityOpenIDTest {
	
	public static void main(String[] args) {
		final String STEAM_LOGIN = "https://steamcommunity.com/openid/login";
		List<NameValuePair> parameters = new ArrayList<>();
		parameters.add(new BasicNameValuePair("openid.ns", "http://specs.openid.net/auth/2.0"));
		parameters.add(new BasicNameValuePair("openid.mode", "checkid_setup"));
		parameters.add(new BasicNameValuePair("openid.return_to", "http://....../index.html"));
		parameters.add(new BasicNameValuePair("openid.realm", "http://......"));
		parameters.add(new BasicNameValuePair("openid.ns.sreg", "http://openid.net/extensions/sreg/1.1"));
		parameters.add(new BasicNameValuePair("openid.claimed_id", "http://specs.openid.net/auth/2.0/identifier_select"));
		parameters.add(new BasicNameValuePair("openid.identity", "http://specs.openid.net/auth/2.0/identifier_select"));
		String param = URLEncodedUtils.format(parameters, "UTF-8");
		System.out.println(STEAM_LOGIN+"?"+param);
		
		List<NameValuePair> parse = URLEncodedUtils.parse("http://....../index.html?openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&"
				+ "openid.mode=id_res&openid.op_endpoint=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Flogin&"
				+ "openid.claimed_id=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Fid%2F76561198200301613&"
				+ "openid.identity=https%3A%2F%2Fsteamcommunity.com%2Fopenid%2Fid%2F76561198200301613&"
				+ "openid.return_to=http%3A%2F%2Fpkpltest.wodeji.net%2Findex.html&"
				+ "openid.response_nonce=2018-04-11T12%3A13%3A48ZBAEWRrmjtLIuTDUyz3n3BIcgQq8%3D&openid.assoc_handle=1234567890&"
				+ "openid.signed=signed%2Cop_endpoint%2Cclaimed_id%2Cidentity%2Creturn_to%2Cresponse_nonce%2Cassoc_handle&"
				+ "openid.sig=7cLOoKAvCgre5h%2Bqhdg51naz84U%3D", Charset.forName("UTF-8"));
		
		for (NameValuePair nameValuePair : parse) {
			System.out.println(nameValuePair.getName()+":"+nameValuePair.getValue());
		}
	}
}

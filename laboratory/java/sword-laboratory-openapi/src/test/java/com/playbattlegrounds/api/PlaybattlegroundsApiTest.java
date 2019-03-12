package com.playbattlegrounds.api;

import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class PlaybattlegroundsApiTest {
	
	static String PC_AS = "pc-as";
	
	public static void main(String[] args) throws IOException{
		getPoints();
	}
	
	static void getPoints() {
		try {
			JSONObject playerData = JSON.parseObject(PlayBattleGroundsApiRequestUtil.getPlayerByPlayerName(PC_AS, "gongqingbing11"))
					.getJSONArray("data").getJSONObject(0);
			String playerId = playerData.getString("id");
			JSONArray matches = playerData.getJSONObject("relationships").getJSONObject("matches").getJSONArray("data");
			String matcheId = matches.getJSONObject(3).getString("id");
			JSONObject matchData = JSON.parseObject(PlayBattleGroundsApiRequestUtil.getMatchById(PC_AS, matcheId));
			JSONArray included = matchData.getJSONArray("included");
			JSONObject stats = PlayBattleGroundsApiRequestUtil.getParticipantFromMatchIncluded(included,playerId)
					.getJSONObject("attributes").getJSONObject("stats");
			System.out.println(stats.toJSONString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

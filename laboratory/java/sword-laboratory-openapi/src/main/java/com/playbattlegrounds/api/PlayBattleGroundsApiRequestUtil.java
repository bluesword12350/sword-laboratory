package com.playbattlegrounds.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import top.bluesword.util.network.HttpClientUtil;

/**
 * 绝地求生访问数据接口
 * @author 李林峰
 */
@Service
public class PlayBattleGroundsApiRequestUtil {
	
	private static final String TOKEN = "";
	private static final String URL = "https://api.playbattlegrounds.com/shards/";
	
	/**
	 * 发送请求到绝地求生开放平台
	 * @param service 服务器
	 * @param perUrl 接口相对地址
	 * @param paramMap 参数集合
	 * @return 返回结果
	 */
	private static String sendGetToPlayBattleGrounds(String service, String perUrl, Map<String, String> paramMap) {
		Map<String, String> headersMap = new HashMap<>(2);
		headersMap.put("accept", "application/vnd.api+json");
		headersMap.put("Authorization", TOKEN);
		return HttpClientUtil.sendGet(URL + service + perUrl, paramMap , headersMap);
	}

	/**
	 * 根据玩家游戏昵称获取玩家数据
	 * @param server 服务器名称
	 * @param playerName 玩家昵称
	 * @return 接口返回值
	 */
	public static String getPlayerByPlayerName(String server,String playerName) throws IOException {
		Map<String, String> paramMap = new HashMap<>(1);
		paramMap.put("filter[playerNames]", playerName);
		String playerData = sendGetToPlayBattleGrounds(server, "/players", paramMap);
		if (StringUtils.isBlank(playerData)) {
			throw new IOException("请求绝地求生服务器异常，返回值为空");
		}
		JSONObject parseObject = JSON.parseObject(playerData);
		if (parseObject.get("errors")!=null) {
			return null;
		}
		return playerData;
	}

	/**
	 * 根据比赛ID获取比赛
	 * @param server 服务器名称
	 * @param matchId 比赛ID
	 * @return 返回值
	 */
	public static String getMatchById(String server,String matchId) throws IOException {
		String matchData = sendGetToPlayBattleGrounds(server, "/matches/"+matchId, null);
		if (StringUtils.isBlank(matchData)) {
			throw new IOException("请求绝地求生服务器异常，返回值为空");
		}
		return matchData;
	}

	public static JSONObject getParticipantFromMatchIncluded(JSONArray included,String playerId) {
		for (int i = 0; i < included.size(); i++) {
			JSONObject items = included.getJSONObject(i);
			if (!"participant".equals(items.getString("type"))) {
				continue;
			}
			if (items.getJSONObject("attributes").getJSONObject("stats").getString("playerId").equals(playerId)) {
				return items;
			}
		}
		return null;
	}

}
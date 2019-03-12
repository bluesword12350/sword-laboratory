package top.bluesword.zjson;

import org.apache.commons.lang3.StringUtils;

public class BlueswordZjsonDemo {
	public static void main(String[] args) {
		String string = "登录：{“用户名”：“”，“验证码”：“”}";
		int indexOf = string.indexOf('：');
		System.out.println(string.substring(0,indexOf));
		String value = string.substring(indexOf+1);
		if (StringUtils.isNotBlank(value)) {
			String[] split = value.substring(1,value.length()-1).split("，");
			for (String string2 : split) {
				System.out.println(string2);
			}
		}
	}
}
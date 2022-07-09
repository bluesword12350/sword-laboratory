package com.google.gson;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class GsonBeanDemo {

	@SerializedName("Name")
	private String string;

}

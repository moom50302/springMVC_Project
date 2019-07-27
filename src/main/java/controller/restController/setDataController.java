package main.java.controller.restController;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class setDataController {
	
	@RequestMapping(value="/setData",method=RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String set(@RequestParam(value="dataArray[]") List<String> dataArray){
		
		JSONObject returnJson = new JSONObject();
		JSONArray returnColumnNameJA = new JSONArray();
		JSONArray returnDataJA = new JSONArray();
		JSONObject getJson;
		
		// get Column Name
		String [] columnName = dataArray.get(0).replace("\r", "").replace("\'", "").split(",");
		for(String s:columnName){
			getJson = new JSONObject();
			getJson.put("title", s);
			getJson.put("data", s);
			returnColumnNameJA.put(getJson);
		}
		returnJson.put("columnName",returnColumnNameJA);
		
		// get Data
		int i;
		for(i=1;i<dataArray.size();i++){
			getJson = new JSONObject();
			String [] data = dataArray.get(i).replace("\r", "").replace("\'", "").split(",");
			for(int j=0;j<columnName.length;j++){
				getJson.put(columnName[j], data[j]);
			}
			returnDataJA.put(getJson);
		}
		returnJson.put("data",returnDataJA);

		returnJson.put("status", true);
		return returnJson.toString();
	}
}

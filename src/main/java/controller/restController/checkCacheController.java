package main.java.controller.restController;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/cache", produces = "application/json")
public class checkCacheController {
	
	@GetMapping
	@ResponseBody
	public String check(){
		JSONObject returnJson = new JSONObject();
		returnJson.put("status",true);
		return returnJson.toString();
	}
}

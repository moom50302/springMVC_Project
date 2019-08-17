package main.java.controller.restController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import au.com.bytecode.opencsv.CSVReader;
import io.swagger.annotations.ApiOperation;

@RestController
public class fileProcessController {
	
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/uploadFile",method=RequestMethod.POST)
	@ApiOperation(value="Do Upload File",notes="User Can Upload Content File as CSV To Server Then Analysis.")
	public ModelAndView set(@RequestParam("uploadFile") MultipartFile file,ModelAndView modelAndView,HttpServletRequest request) {
		
		modelAndView.setViewName("fileUpload");
		
		String getFileName = file.getOriginalFilename();
		
		InputStream input;
		OutputStream output;
		String prefix =  request.getServletContext().getRealPath("/WEB-INF/uploadFolder/");
		String prefix2 = context.getRealPath("/WEB-INF/uploadFolder/");
		
		System.out.println("Path:" +prefix);
		System.out.println("Path2:" +prefix2);
		
		String result = "";
		
		try {
			input = file.getInputStream();
			File newFile = new File(prefix,getFileName);
			System.out.println("File Path:" +newFile.getAbsolutePath()+"\r\n"+newFile.getPath());
			if(!newFile.exists())
				newFile.createNewFile();
			
			output = new FileOutputStream(newFile);
			int read = 0;
			byte bytes [] = new byte[1024];
			
			while((read = input.read(bytes)) != -1) {
				output.write(bytes,0,read);
			}
		
			input.close();
			output.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			result = "Upload Fail , Error:" + e.toString();
			modelAndView.addObject("message",result);
			return modelAndView;
		}
		
		result = "Upload Success!";
		modelAndView.addObject("message",result);
		return modelAndView;
	}
	
	@RequestMapping(value="/fileContent",method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String get(@RequestParam(value="file")String fileName){
		
		JSONObject returnJson = new JSONObject();
		JSONArray returnColumnNameJA = new JSONArray();
		JSONArray returnDataJA = new JSONArray();
		JSONObject getJson;
		
		String prefix = context.getContextPath();
		List<String> dataArray = new ArrayList<String>();
		
		try {
			
			CSVReader csvReader = new CSVReader(new FileReader(prefix+"main/resources/uploadFolder/"+fileName+".csv"));
		    String[] getRecord = null;
		    while((getRecord = csvReader.readNext()) != null) {
		    	dataArray.add(getRecord.toString());
		    }
		    csvReader.close();
		    
		}catch(Exception e) {
			e.printStackTrace();
			return "Read File Fail, Error:"+e.toString();
		}
		
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

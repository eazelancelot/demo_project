package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterReq;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@SpringBootTest(classes = DemoProjectApplication.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RegisterTest {

	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	// mockMvc 是基於 webApplicationContext 所建立的物件，可以用來編寫 web 應用的整合測試
	@Autowired
	private WebApplicationContext wac;

	// 實現對 http 請求的模擬，主要是用來測試 controller
	private MockMvc mockMvc;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private RegisterDao registerDao;

	@BeforeAll
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@BeforeAll
	public void beforeAll() {
		System.out.println("Before ALL!!");
	}

	@AfterAll
	public void afterAll() {
		System.out.println("After ALL!!");
	}

	@BeforeEach
	public void beforeEach() {
		System.out.println("Before Each!!");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void registerControllerTest() throws Exception {
		// 如果 Headers 要加的參數有多個，可使用此方式;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// set request_body
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", "A99");
		map.put("pwd", "A123456");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Tainan");
		// map to string
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);

		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/register") //
				.contentType(CONTENT_TYPE) 
				// Headers 要加的參數就只有 content_type 時，可直接使用，不須透過 Headers 加入
//				.headers(headers)
				.content(mapString));
		// get response && 將 response 的內容轉成字串

//		MockHttpServletResponse httpResponse = result.andReturn().getResponse();
//		String resString = httpResponse.getContentAsString();

		String resString = result.andReturn().getResponse().getContentAsString();
		// 將得到的 response 字串 轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
		String rtnMessage = (String) resData.get("message");
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Message error!!");
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_info");
		Assert.isTrue(((String) rtnInfo.get("account")).equals("A99"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void addRoleListControllerTest() throws Exception {
		// set request_body
		Map<String, Object> map = new LinkedHashMap<>();
		List<String> roleList = new ArrayList<>();
		roleList.add("AAA");
		roleList.add("BBB");
		map.put("account", "A02");
		map.put("role_list", roleList);
		// map to string
		ObjectMapper objectMapper = new ObjectMapper();
		String mapString = objectMapper.writeValueAsString(map);
		
		System.out.println(map.toString());
		System.out.println(mapString);
		
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders
				.post("/api/add_role_list") //
				.contentType(CONTENT_TYPE) //
				.content(mapString)); //
		String resString = result.andReturn().getResponse().getContentAsString();
		// 將得到的 response 字串 轉成 Json(map)
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		Map<String, Object> resData = jsonParser.parseMap(resString);
	}

	@Test
	public void registerTest() {
		Register reg = registerService.register("A99", "123456", "Alice", 18, "Tainan");
		Assert.notNull(reg, "Result is null!");
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A99"), "Account error!");

		registerDao.delete(reg);

		Assert.isTrue(!registerDao.findById("A99").isPresent(), "reg is not null!");

		Assert.isTrue(!registerDao.existsById("A99"), "reg is not null!");

		System.out.println("Register Test!!");
	}

	@Test
	public void activeAccountTest() {
		// register new account
		Register reg = registerService.register("A99", "123456", "Alice", 18, "Tainan");
		Assert.isTrue(reg.isActive() == false, "Account is active!!"); // reg.isActive() == false --> !reg.isActive()
		// active registered account
		registerService.activeAccount("A99");
		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive() == true, "Account is inactive!!"); // reg.isActive() == true --> reg.isActive()
		registerDao.delete(newReg);

		System.out.println("Active Account!!");
	}

	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("PM");
		registerService.addRole("A02", roleList);

		System.out.println("Add Role!!");
	}
	
	@Test
	public void reqTest() {
		RegisterReq req1 = new RegisterReq("AAA", "A01", "123");
		RegisterReq req2 = new RegisterReq("BBB", "B01", "123");
		req2.setReq(req1);
		req2.show();
	}
	
	@Test
	public void updateRegisterInfoDaoTest() {
		int result = registerDao.updateRegisterInfo("Davidd", 23, "Taipei", new Date(), "A99");
		System.out.println("----->>" + result);
	}
	
	@Test
	public void doQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date);
		System.out.println(result.size());
		for(Register item : result) {
			System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void doQueryWithPageSizeTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, 2);
		System.out.println(result.size());
		for(Register item : result) {
			System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void doQueryWithStartPositionTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doQueryByExpiredRegTime(date, -1, 2);
		System.out.println(result.size());
		for(Register item : result) {
			System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void doNativeQueryTest() throws ParseException {
		String dateStr = "2022-11-10";
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		List<Register> result = registerDao.doNativeQueryByExpiredRegTime(date, -1, 2);
		System.out.println(result.size());
		for(Register item : result) {
			System.out.println(item.getAccount());
		}
	}
	
	@Test
	public void doUpdateTest() throws ParseException {
		int result = registerDao.updateAgeByName("Alice", 66);
//		int result = registerDao.updateAgeByAccount("A01", 77);
		System.out.println(result);
	}
	
	@Test
	public void doNativeUpdateTest() throws ParseException {
		int result = registerDao.nativeUpdateAgeByName("Alice", 33);
//		int result = registerDao.nativeUpdateAgeByAccount("A01", 88);
		System.out.println(result);
	}

}

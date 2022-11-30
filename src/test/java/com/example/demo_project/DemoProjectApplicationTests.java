package com.example.demo_project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.PersonService;

@SpringBootTest
class DemoProjectApplicationTests {

//	@BeforeEach
//	public void setMenu() {
//		Menu beefMenu = new Menu("beef", 100);
//		Menu porkMenu = new Menu("pork", 90);
//		Menu chickenMenu = new Menu("chicken", 80);
//		menuList.add(beefMenu);
//		menuList.add(porkMenu);
//		menuList.add(chickenMenu);
//	}

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private RegisterDao registerDao;
	
	@PersistenceContext //JPA �M�����`��
    private EntityManager entityManager;
	
	@Value("${email.password}")
	private String emailPwd;
	
	@Value("${email.passworddd:ASDF}")
	private String emailPwddd;
	
	@Test
	public void test() {
		System.out.println(emailPwd);
		System.out.println(emailPwddd);
	}

	@Test
	public void registerDaoUpdateTest() throws ParseException {
//		int result = registerDao.updateAgeByName("Alice", 99);
		int result = registerDao.updateAgeByAccount("A01", 88);
		System.out.println(result);
	}

	@Test
	public void doQueryRoleContains() throws ParseException {
		List<String> strList = Arrays.asList("DDD", "SA");
		List<Register> result = registerDao.doQueryRoleContains(strList);
		System.out.println(result.size());
	}

	@Test
	public void collectionTest() {
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		list2.add(3);
		list2.add(2);
//		System.out.println(list1.contains(list2));
		for (Integer item : list1) {
			System.out.println(list2.contains(item));
		}
//		double da = 3.22222;
//		System.out.println(Math.round(da));
//		System.out.println(Math.round(da*10.0)/10.0);
//		System.out.println(Math.round(da*100.0)/100.0);
//		System.out.println("=============================");
		// 8~12 ==> 6~7, 6~8, 7~9, 8~10, 9~11, 10~12, 11~13, 12~14, 13~15, 8~12, 7~13
//		System.out.println("===================================");
//		System.out.println("8~12 and 6~7 --> " + betweenExclude(8, 12, 6, 7));
//		System.out.println("8~12 and 6~8 --> " + betweenExclude(8, 12, 6, 8));
//		System.out.println("8~12 and 7~9 --> " + betweenExclude(8, 12, 7, 9));
//		System.out.println("8~12 and 8~10 --> " + betweenExclude(8, 12, 8, 10));
//		System.out.println("8~12 and 9~11 --> " + betweenExclude(8, 12, 9, 11));
//		System.out.println("8~12 and 10~12 --> " + betweenExclude(8, 12, 10, 12));
//		System.out.println("8~12 and 11~13 --> " + betweenExclude(8, 12, 11, 13));
//		System.out.println("8~12 and 12~14 --> " + betweenExclude(8, 12, 12, 14));
//		System.out.println("8~12 and 13~15 --> " + betweenExclude(8, 12, 13, 15));
//		System.out.println("8~12 and 8~12 --> " + betweenExclude(8, 12, 8, 12));
//		System.out.println("8~12 and 7~13 --> " + betweenExclude(8, 12, 7, 13));
//		System.out.println("===================================");

	}

	private boolean betweenExclude(int start1, int end1, int start2, int end2) {
		return start1 >= end2 || end1 <= start2; // true = ���İ�
//		return !(start1 >= end2) && !(end1 <= start2); // true = �İ�
	}

	@Test
	public void simpleDateFormatTest() throws ParseException {
		// ����ഫ���r��
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
		System.out.println(sdff.format(new Date()));
		// �ѪR���
		String dateStr = "2022-11-25";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(dateStr);
		System.out.println(newDate);
	}

	@Test
	public void dateTimeFormatterTest() {
		// ����ഫ���r��
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy�~MM��dd�� HH:mm a");
		String nowStr = now.format(format);
		System.out.println(nowStr);
		// �ѪR���(LocalDate)
		String dateStr = "2022�~11��25��";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy�~MM��dd��");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		System.out.println(date);
		// �ѪR���(LocalDateTime)
		String dateTimeStr = "2022�~11��25�� 12��30��10��";
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy�~MM��dd�� HH��mm��ss��");
		LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter1);
		System.out.println(dateTime);
	}

	@Test
	public void dateTimeFormatterTest1() {
		String dateStr = "2019/08/15";
		// ����r���ഫ��LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.parse(dateStr, formatter);
		System.out.println(localDate); // 2019-08-15
		// LocalDate�ഫ�^����r��
		dateStr = localDate.format(formatter);
		System.out.println(dateStr); // 2019/08/15
		// LocalDate�ഫ�^����r��
		dateStr = DateTimeFormatter.ofPattern("yyyy_MM_dd").format(localDate);
		System.out.println(dateStr); // 2019_08_15
	}

	@Test
	public void dateToLocalDateTest() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("ZoneId(���w�ɰ�): " + zoneId);
		// atZone(): ��^�q���w�ɰϸ� Instant �ͦ��� ZonedDateTime
		LocalDate localDate = instant.atZone(zoneId).toLocalDate();
		System.out.println("Date: " + date);
		System.out.println("LocalDate: " + localDate);
	}

	@Test
	public void localDateToDateTest() {
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate localDate = LocalDate.now();
		// atStartOfDay(zoneId): �Ыث��w�ɰϪ�����}�l�ɶ�
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(zoneId);
		System.out.println("ZonedDateTime: " + zonedDateTime);
		Date date = Date.from(zonedDateTime.toInstant());
		System.out.println("Date: " + date);
		System.out.println("LocalDate: " + localDate);
	}

	@Test
	public void twoSumTest() {
		int[] intArray = { 2, 7, 11, 15, 17, 19, 23, 29, 31, 47 };
		int[] result = twoSum(intArray, 78);
//		int[] intArray = {2, 7, 11, 15};
//		int[] result = twoSum(intArray, 26);
		for (int item : result) {
			System.out.println(item);
		}
	}

	public int[] twoSum1(int[] nums, int target) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				count++;
				int num2 = nums[j];
				if (num1 + num2 == target) {
					System.out.println(count);
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public int[] twoSum(int[] nums, int target) {// nums = [2, 7, 11, 15], target = 9
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			count++;
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				System.out.println(count);
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i); // {2, 0}, {7, 1}, {11, 3}
		}
		return null;
	}

	@Test
	public void mapTest() {
		Map<String, Object> params = new HashMap<>();
		params.put("inputId", "A01");
		params.put("inputAge", 18);	
		System.out.println(params.get("inputId"));
		System.out.println(params.get("inputAge"));
		
		String sql = "select c.name from Customers c where c.id = :inputId and c.age > :inputAge";
		
//		Query query = entityManager.createQuery(sql, Customers.class);
//		if (!CollectionUtils.isEmpty(params)) {
//			for(Parameter p : query.getParameters()) {
//				System.out.println(p);
//				System.out.println(p.getName());
//            }
//		}
	}
}

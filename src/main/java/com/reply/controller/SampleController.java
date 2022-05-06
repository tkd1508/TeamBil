package com.reply.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reply.vo.SampleVO;
import com.reply.vo.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText",produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE:"+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
	@GetMapping(value="getSample",
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(111,"스타","로드");
			}
	@GetMapping(value="getSample2")
	public SampleVO getSample2() {
		return new SampleVO(111,"로켓","라쿤");
	}
	@GetMapping(value="getList")
	public List<SampleVO> getList(){
		return IntStream.range(1, 10).mapToObj(i -> new SampleVO(i,i+"First",i+"Last"))
				.collect(Collectors.toList());
	}
	@GetMapping(value="getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<>();
		map.put("Firtst",new SampleVO(111,"그루트","주니어"));
		
		return map;
	}
	@GetMapping(value="/check",params= {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height,Double weight){
		
		SampleVO vo=new SampleVO(0,""+height,""+weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if(height<150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}else {
			result=ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping("/product/{cat}/{pid}")
	public String[]getPath(
			@PathVariable("cat") String cat,//rest api이용할때 사용 uri경로에서 값을 가져온다.
			@PathVariable("pid") Integer pid){
		return new String[] {"categoryu:"+cat, "productid:"+pid};
	}
	@PostMapping("ticket") // p.368~370
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("conver.....ticket"+ticket);
		return ticket;
	}
}

package com.tomcatTest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomcatTest.test.Tx_Insert001;
import com.tomcatTest.test.Tx_Insert002;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class TxServiceImpl implements TxService {
	
	@Setter(onMethod_ = {@Autowired})
	private Tx_Insert001 tx001;
	
	@Setter(onMethod_ = {@Autowired})
	private Tx_Insert002 tx002;
	
	
	@Override
	public void addData(String value) {
		// TODO Auto-generated method stub
		log.info("====== tx001 ====");
		tx001.insertTodo(value);
		
		log.info("====== tx002 ====");
		tx002.insertTodo(value);
		
		log.info("====== end ====");
		
	}

}

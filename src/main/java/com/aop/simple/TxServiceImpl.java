package com.aop.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
	
	@Transactional // 이걸 붙이면 둘다 실행이 안됨. 안붙이면 하나만 실행이 됨.
	@Override
	public void addData(String value) throws Exception {
		// TODO Auto-generated method stub
		try {
		log.info("====== tx001 ====");
		tx001.insertTodo(value);
		
		log.info("====== tx002 ====");
		tx002.insertTodo(value);
		
		log.info("====== end ====");
		}catch(Exception e) {e.printStackTrace();
		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}

}

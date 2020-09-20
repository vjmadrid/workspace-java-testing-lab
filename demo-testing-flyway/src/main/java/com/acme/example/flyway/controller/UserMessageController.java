package com.acme.example.flyway.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acme.example.flyway.constant.UserMessageRestApiConstant;
import com.acme.example.flyway.entity.UserMessage;
import com.acme.example.flyway.service.UserMessageService;

@RestController
@RequestMapping(UserMessageRestApiConstant.MAPPING)
@CrossOrigin(origins = "*")
public class UserMessageController {
	
	public static final Logger LOG = LoggerFactory.getLogger(UserMessageController.class);
	
	@Autowired
	private UserMessageService userMessageService;
	
	@GetMapping
	public ResponseEntity<List<UserMessage>> findAll() {
		LOG.info("Find All UserMessage");
		final List<UserMessage> userMessageList = userMessageService.findAll();
			
		if (userMessageList == null || userMessageList.isEmpty()) {
			LOG.info("userMessageList is empty");
			return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
			// Option 1 : return new ResponseEntity<List<UserMessage>>(HttpStatus.NOT_FOUND);
			// Option 2 : return HttpStatus.NO_CONTENT -> return new ResponseEntity<List<UserMessage>>(HttpStatus.NO_CONTENT)
			// Option 3 : return ResponseEntity.notFound().build();
		}

		LOG.info("RESULT :: ["+userMessageList.toString()+"]");
		
		return new ResponseEntity<List<UserMessage>>(userMessageList, HttpStatus.OK);
	}

}

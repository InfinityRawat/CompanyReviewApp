package com.Spring.CompanyMicroservice2.Entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

		private String errMsg;
		private int errorCode;
		private String errorStatus;
		private LocalDateTime timeStamp;
}

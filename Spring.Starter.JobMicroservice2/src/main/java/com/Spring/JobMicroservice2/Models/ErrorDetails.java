package com.Spring.JobMicroservice2.Models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorDetails {

		private String errMsg;
		private int errorCode;
		private String errorStatus;
		private LocalDateTime timeStamp;
}

package com.techno.mymapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseDto {
	private boolean error;
	private String message;
	private Object object;
}

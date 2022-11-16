package com.techno.ems.email;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailMessage {

	public static String getMess(String empName, String empEmailId, String empPassword) {

		String mss = "\r\n" + "Hello " + empName + ",\r\n" + "\r\n" + "Thank you for joining, your Employee emailId :  "
				+ empEmailId + "and\r your password is: "+empPassword+".\r";

		return mss;

	}

}

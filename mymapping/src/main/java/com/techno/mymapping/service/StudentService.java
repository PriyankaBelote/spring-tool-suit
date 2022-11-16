package com.techno.mymapping.service;

import com.techno.mymapping.dto.StudentDto;
import com.techno.mymapping.dto.StudentUpdateDto;
import com.techno.mymapping.entity.Student;

public interface StudentService {

	StudentDto register(StudentDto studentDto);

	void delete(String stdId);

//	StudentUpdateDto update(String stdId, StudentUpdateDto studentUpdateDto);

	StudentDto update(StudentDto studentDto);



}

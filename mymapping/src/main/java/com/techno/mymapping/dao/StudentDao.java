package com.techno.mymapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techno.mymapping.dto.StudentDto;
import com.techno.mymapping.entity.Student;

public interface StudentDao extends JpaRepository<Student, String> {

	Student findByStdId(String stdId);


}

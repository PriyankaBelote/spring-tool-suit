package com.techno.mymapping.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.mymapping.dao.StudentDao;
import com.techno.mymapping.dto.StudentDto;
import com.techno.mymapping.dto.StudentUpdateDto;
import com.techno.mymapping.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto register(StudentDto studentDto) {
		Student map = modelMapper.map(studentDto, Student.class);
		dao.save(map);
		StudentDto map2 = modelMapper.map(map, StudentDto.class);
		return map2;
	}

	@Override
	public void delete(String stdId) {
		Student findById = dao.findById(stdId).get();
		dao.delete(findById);
	}

	@Override
	public StudentDto update(StudentDto studentDto) {
		Student map = modelMapper.map(studentDto, Student.class);
		dao.save(map);
		StudentDto map2 = modelMapper.map(map, StudentDto.class);
		return map2;	
	}
	
	
	
	
	
	
	

//	@Override
//	public StudentUpdateDto update(String stdId, StudentUpdateDto studentUpdateDto) {
//		Student findById = dao.findByStdId(stdId);
//		if (findById != null) {
//			
//			Student student = modelMapper.map(studentUpdateDto, Student.class);
//			Student save = dao.save(student);
//			return modelMapper.map(save, StudentUpdateDto.class);
//		}
//		return null;
//
////		if (dao.findById(stdId).isPresent()) {
////			Student map = modelMapper.map(studentUpdateDto, Student.class);
////			Student updatedStudent = dao.save(map);
////			return this.modelMapper.map(updatedStudent, StudentUpdateDto.class);
////
////		} else {
////			return null;
////		}
//
//	}
}

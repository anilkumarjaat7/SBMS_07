package com.p1.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.p1.dto.StudentRequestDTO;
import com.p1.dto.StudentResponseDTO;
import com.p1.entity.Student;
import com.p1.repository.StudentRepository;
import com.p1.service.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    // POST
    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {

        Student student = Student.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .age(dto.getAge())
                .course(dto.getCourse())
                .fees(dto.getFees())
                .build();

        Student savedStudent = studentRepository.save(student);

        return null;
    }

	@Override
	public List<StudentResponseDTO> getAllStudents() {
//		studentRepository.findAll()
		return null;
	}

	@Override
	public StudentResponseDTO getStudentById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentResponseDTO patchStudent(Long id, StudentRequestDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentResponseDTO> getStudentsByCourse(String course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentResponseDTO> searchStudents(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

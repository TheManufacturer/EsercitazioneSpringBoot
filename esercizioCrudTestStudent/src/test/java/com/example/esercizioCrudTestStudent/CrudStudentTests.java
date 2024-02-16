package com.example.esercizioCrudTestStudent;

import com.example.esercizioCrudTestStudent.controllers.StudentController;
import com.example.esercizioCrudTestStudent.entities.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class CrudStudentTests {
	@Autowired
	private StudentController studentController;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	private Student createStudent() throws Exception {
		Student student = new Student();
		student.setName("Marco");
		student.setSurname("Benedetto");
		student.setWorking(false);

		return createStudent(student);
	}

	private Student createStudent(Student student) throws Exception {
		MvcResult result = createStudentRequest(student);
		return objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
	}

	private MvcResult createStudentRequest() throws Exception {
		Student student = new Student();
		student.setName("Marco");
		student.setSurname("Benedetto");
		student.setWorking(false);

		String studentJSON = objectMapper.writeValueAsString(student);

		return this.mockMvc.perform(post("/student/createstudent")
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	private MvcResult createStudentRequest(Student student) throws Exception {
		if (student != null) {
			String studentJSON = objectMapper.writeValueAsString(student);

			return this.mockMvc.perform(post("/student/createstudent")
							.contentType(MediaType.APPLICATION_JSON)
							.content(studentJSON)).andDo(print())
					.andExpect(status().isOk())
					.andReturn();
		} else return null;
	}

	private Student getStudentFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/student" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		try {
			String studentJSON = result.getResponse().getContentAsString();
			return objectMapper.readValue(studentJSON, Student.class);
		} catch (Exception e) {
			return null;
		}


	}

	@Test
	void StudentControllerExist() {
		assertThat(studentController).isNotNull();
	}

	@Test
	void createStudentTest() throws Exception {
		MvcResult studentRequest = createStudentRequest();
		Student studentfromResponse = objectMapper.readValue(studentRequest.getResponse().getContentAsString(), Student.class);
		assertThat(studentfromResponse.getId()).isNotNull();
	}

	@Test
	void getStudentListTest() throws Exception {
		createStudentRequest();
		createStudentRequest();
		createStudentRequest();
		MvcResult result = this.mockMvc.perform(get("/student/getall"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List studentsFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("The students in database are: " + studentsFromResponse.size());
		assertThat(studentsFromResponse.size()).isNotZero();
	}

	@Test
	void readOneStudent() throws Exception {
		Student student = createStudent();
		assertThat(student.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(get("/student/getone/" + student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentsFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);

		assertThat(studentsFromResponse.getId()).isEqualTo(student.getId());
	}

	@Test
	void updateStudent() throws Exception {
		Student student = createStudent();
		assertThat(student.getId()).isNotNull();
		String newName = "Francesco";
		student.setName(newName);
		String studentJSON = objectMapper.writeValueAsString(student);


		MvcResult result = this.mockMvc.perform(put("/student/patch/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.getName()).isEqualTo(newName);
	}

	@Test
	void updateStudentWorking() throws Exception {
		Student student = createStudent();
		assertThat(student.getId()).isNotNull();
		Boolean working = true;
		student.setWorking(working);
		String studentJSON = objectMapper.writeValueAsString(student);


		MvcResult result = this.mockMvc.perform(put("/student/patch/" + student.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(studentJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Student studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Student.class);
		assertThat(studentFromResponse.getId()).isNotNull();
		assertThat(studentFromResponse.isWorking()).isTrue();
	}

	@Test
	void deleteStudent() throws Exception {
		Student student = createStudent();
		assertThat(student.getId()).isNotNull();
		boolean working = true;
		student.setWorking(working);
		String studentJSON = objectMapper.writeValueAsString(student);


		MvcResult result = this.mockMvc.perform(delete("/student/" + student.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		boolean studentFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Boolean.class);
		assertThat(studentFromResponse).isTrue();


	}


}

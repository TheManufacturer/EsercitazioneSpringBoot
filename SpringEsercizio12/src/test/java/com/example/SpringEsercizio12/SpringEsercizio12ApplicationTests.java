package com.example.SpringEsercizio12;

import com.example.SpringEsercizio12.controller.UserController;
import com.example.SpringEsercizio12.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ControllerTest {

	@LocalServerPort
	private int port;
	@Autowired
	private UserController userController;
	@Autowired

	private MockMvc mockMvc;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;



	private User createAUser() throws Exception {
		User User = new User();
		User.setWorking(true);
		User.setName("Mario");
		User.setSurname("Rossi");
		return this.createAUser(User);
	}

	private User createAUser(User User) throws Exception {
		MvcResult result = createUserSRequest(User);
		User responseUser = this.objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		return responseUser;
	}

	private MvcResult createUserSRequest() throws Exception {
		User User = new User();
		User.setWorking(true);
		User.setName("Mario");
		User.setSurname("Rossi");

		return createUserSRequest(User);

	}

	private MvcResult createUserSRequest(User User) throws Exception {
		if (User == null) return null;

		String UserSJSON = objectMapper.writeValueAsString(User);

		return this.mockMvc.perform(post("/User/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(UserSJSON))
				.andExpect(status().isOk()).andDo(print())
				.andReturn();
	}

	private User getUserSFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/User/getUser/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		if (result.getResponse().getContentAsString().isEmpty()) {
			return null;
		}

		return objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
	}

	@Test
	void createAUserSTest() throws Exception {

		User UserSResponse = createAUser();
		assertThat(UserSResponse.getId()).isNotNull();
	}

	@Test
	void readList() throws Exception {
		createAUserSTest();
		createAUserSTest();
		createAUserSTest();
		createAUserSTest();
		MvcResult result = this.mockMvc.perform(get("/User/getList"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<User> responseUserS = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("User in database are: " + responseUserS.size());
		assertThat(responseUserS.size()).isNotZero();
	}

	@Test
	void readSingleUserS() throws Exception {
		User User = createAUser();
		assertThat(User.getId()).isNotNull();

		User responseUserS = getUserSFromId(User.getId());

		assertThat(responseUserS.getId()).isEqualTo(User.getId());
	}

	@Test
	void updateUserS() throws Exception {

		User User = createAUser();
		assertThat(User.getId()).isNotNull();


		String newName = "Antonio";
		User.setName(newName);


		String UserSJSON = objectMapper.writeValueAsString(User);


		MvcResult result = this.mockMvc.perform(put("/User/updateUser/" + User.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(UserSJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();


		User responseUser = objectMapper.readValue(result.getResponse().getContentAsString(), User.class);
		assertThat(responseUser.getId()).isEqualTo(User.getId());
		assertThat(responseUser.getName()).isEqualTo(newName);


		User responseUserGet = getUserSFromId(User.getId());
		assertThat(responseUserGet.getId()).isEqualTo(User.getId());
		assertThat(responseUserGet.getName()).isEqualTo(newName);
	}


	@Test
	void deleteUser()throws Exception{
		User User = createAUser();
		assertThat(User.getId()).isNotNull();

		this.mockMvc.perform(delete("/User/deleteUser/"+User.getId()))
				.andDo(print())
				.andExpect(status().isOk());
		User responseUser = getUserSFromId(User.getId());

		assertThat(responseUser).isNull();

	}

}
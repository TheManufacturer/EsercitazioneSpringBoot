package com.example.Unittest;

import com.example.Unittest.Controllers.UserSController;
import com.example.Unittest.Entities.UserS;
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
	private UserSController userSController;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private TestRestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;


	//creazione UserSe fisico
	private UserS createAUserS() throws Exception {
		UserS UserS = new UserS();
		UserS.setWorking(true);
		UserS.setName("Luca");
		UserS.setSurname("Rossi");
		return this.createAUserS(UserS);
	}

	private UserS createAUserS(UserS UserS) throws Exception {
		MvcResult result = createUserSRequest(UserS);
		UserS responseUserS = this.objectMapper.readValue(result.getResponse().getContentAsString(), UserS.class);
		return responseUserS;
	}

	private MvcResult createUserSRequest() throws Exception {
		UserS UserS = new UserS();
		UserS.setWorking(true);
		UserS.setName("Luca");
		UserS.setSurname("Rossi");

		return createUserSRequest(UserS);

	}

	private MvcResult createUserSRequest(UserS UserS) throws Exception {
		if (UserS == null) return null;

		String UserSJSON = objectMapper.writeValueAsString(UserS);

		return this.mockMvc.perform(post("/UserS/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(UserSJSON))
				.andExpect(status().isOk()).andDo(print())
				.andReturn();
	}

	private UserS getUserSFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/UserS/getUserS/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		if (result.getResponse().getContentAsString().isEmpty()) {
			return null;
		}

		return objectMapper.readValue(result.getResponse().getContentAsString(), UserS.class);
	}

	@Test
	void createAUserSTest() throws Exception {

		UserS UserSResponse = createAUserS();
		assertThat(UserSResponse.getId()).isNotNull();
	}

	@Test
	void readList() throws Exception {
		createAUserSTest();
		createAUserSTest();
		createAUserSTest();
		createAUserSTest();
		MvcResult result = this.mockMvc.perform(get("/UserS/getList"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<UserS> responseUserS = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("User in database are: " + responseUserS.size());
		assertThat(responseUserS.size()).isNotZero();
	}

	@Test
	void readSingleUserS() throws Exception {
		UserS UserS = createAUserS();
		assertThat(UserS.getId()).isNotNull();

		UserS responseUserS = getUserSFromId(UserS.getId());

		assertThat(responseUserS.getId()).isEqualTo(UserS.getId());
	}

	@Test
	void updateUserS() throws Exception {

		UserS UserS = createAUserS();
		assertThat(UserS.getId()).isNotNull();


		String newName = "Andrea";
		UserS.setName(newName);


		String UserSJSON = objectMapper.writeValueAsString(UserS);


		MvcResult result = this.mockMvc.perform(put("/UserS/updateUserS/" + UserS.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(UserSJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();


		UserS responseUserS = objectMapper.readValue(result.getResponse().getContentAsString(), UserS.class);
		assertThat(responseUserS.getId()).isEqualTo(UserS.getId());
		assertThat(responseUserS.getName()).isEqualTo(newName);


		UserS responseUserSGet = getUserSFromId(UserS.getId());
		assertThat(responseUserSGet.getId()).isEqualTo(UserS.getId());
		assertThat(responseUserSGet.getName()).isEqualTo(newName);
	}


	@Test
	void deleteUser()throws Exception{
		UserS UserS = createAUserS();
		assertThat(UserS.getId()).isNotNull();

		this.mockMvc.perform(delete("/UserS/deleteUserS/"+UserS.getId()))
				.andDo(print())
				.andExpect(status().isOk());
		UserS responseUserS = getUserSFromId(UserS.getId());

		assertThat(responseUserS).isNull();

	}

}
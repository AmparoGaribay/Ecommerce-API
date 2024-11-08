package org.generation.ecommerce;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.ecommerce.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc// muestra las pruebas 
class EcommerceApplicationTests {//especifico para pruebas 
	@Autowired//lo agrega en automatico 
	private MockMvc mockMvc;
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb25pYUBnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTcxMTk5OTUyMCwiZXhwIjoxNzEyMDM1NTIwfQ.dC6MRg07Fz_0RI9b6X_PuoqKbOMC2w0qMfMl-3yeBBw";

	@Test
	@DisplayName ("Se prueba el endpoint http://localhost:8080/api/products/4")
	void pruebaGET() throws Exception{
		this.mockMvc.perform(get ("/api/products/4"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("73828.gif"))
					);
	}
	
	//este metodo es el del pato lucas, solo se puede hacer una vez
	@Test
	@Disabled ("probado por primera vez, deshabilidado")// desabilita
	@DisplayName ("Se prueba borrar el producto con el id 8 http://localhost:8080/api/products/8")
	void pruebaDELETE() throws Exception{
		this.mockMvc.perform(delete ("/api/products/8").header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(
					content().string(containsString("515ftw-2.jpg"))
					);
	}
	
	@Test //este truco solo se puede hacer una vez
	@Disabled
	@DisplayName ("Se prueba crea un nuevo el producto  http://localhost:8080/api/products/8")
	void pruebaPOST() throws Exception{
		Product p = new Product();
		p.setName("lapicera negra ");
		p.setDescription("Pluma y Lapicero Zebra Z-Grip Silver Azul punto fino");
		p.setUrl_imagen("100161506.jpeg");
		p.setPrice(79);
		this.mockMvc.perform(post ("/api/products/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
					content().string(containsString("100161506.jpeg"))
					);
	}//
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
	
	
	
	@Test //este truco solo se puede hacer una vez
	@Disabled
	@DisplayName ("Se prueba actualiza el producto  http://localhost:8080/api/products/8")
	void pruebaPUT() throws Exception{
		Product p = new Product();
		p.setName("");
		p.setDescription("");
		p.setUrl_imagen("");
		p.setPrice(50.90);
		this.mockMvc.perform(put ("/api/products/8")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
					content().string(containsString("49.90")));
	}//


}// ecomerce aplication test

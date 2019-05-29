package trainingapp.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductCrudController.class)
public class ProductCrudControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductCrudService productCrudService;

    @Test
    public void getAllProducts() throws Exception {
        List<Product> products = new ArrayList<>();
        Product product = createDummyProduct();
        products.add(product);

        when(productCrudService.getAllProducts()).thenReturn(products);

        String expected = "[{\"id\":0,\"name\":\"Schnitzel\",\"fatNumber\":4.2,\"proteinNumber\":22.9,\"carbohydratesNumber\":0.0,\"kcalNumber\":129,\"type\":\"MEAT\"}]";

        MvcResult mvcResult = mockMvc.perform(get("/product")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertEquals(expected, content);

        verify(productCrudService, times(1)).getAllProducts();
    }

    @Test
    public void createProduct() throws Exception {
        Product product = createDummyProduct();

        when(productCrudService.createProduct(any())).thenReturn(product);

        String expected = "{\"id\":0,\"name\":\"Schnitzel\",\"fatNumber\":4.2,\"proteinNumber\":22.9,\"carbohydratesNumber\":0.0,\"kcalNumber\":129,\"type\":\"MEAT\"}";

        MvcResult mvcResult = mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertEquals(expected, content);

        verify(productCrudService, times(1)).createProduct(any());
    }

    private Product createDummyProduct() {
        return new Product.ProductBuilder()
                .withName("Schnitzel")
                .withCarbohydratesNumber(0)
                .withFatNumber(4.2)
                .withProteinsNumber(22.9)
                .withKcal(129)
                .withType(ProductType.MEAT)
                .build();
    }
}
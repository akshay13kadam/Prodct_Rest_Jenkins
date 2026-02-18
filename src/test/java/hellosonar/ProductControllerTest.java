package hellosonar;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import hellosonar.Product;
import hellosonar.ProductController;
import hellosonar.ProductService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.io.demo.HomeController;

//@WebMvcTest(HomeController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    
    @Autowired
    private com.io.demo.Product product;

    //    @MockBean
//    private ProductService productService;

    @Test
    void testGetProductByIdReturnsProduct() throws Exception {
        // Arrange: mock service response
        Product mockProduct = new Product(1, "Laptop", 1000.0);
        when(productService.findById(1)).thenReturn(mockProduct);

        // Act & Assert: perform GET request and verify response
        mockMvc.perform(get("/products/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id").value(1))
               .andExpect(jsonPath("$.name").value("Laptop"))
               .andExpect(jsonPath("$.price").value(1000.0));
    }

    @Test
    void testGetProductByIdNotFound() throws Exception {
        // Arrange: simulate product not found
        when(productService.findById(99)).thenThrow(new java.util.NoSuchElementException());

        // Act & Assert: expect 404
        mockMvc.perform(get("/products/99"))
               .andExpect(status().isNotFound());
    }
}
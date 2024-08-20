package ecommerce.product;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import ecommerce.product.dto.ProductRequestDto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void shouldCreateProduct() throws Exception {
        ProductRequestDto productRequest = getProductRequest();

        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(productRequest)
                .when()
                .post("/api/product")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo(productRequest.name()))
                .body("description", Matchers.equalTo(productRequest.description()))
                .body("price", Matchers.is(productRequest.price().intValueExact()));
    }

    @Test
    public void shouldGetAllProduct() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/product")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", Matchers.not(Matchers.empty()));
    }

    private ProductRequestDto getProductRequest() {
        return new ProductRequestDto("iPhone 13", "iPhone 13", BigDecimal.valueOf(1200));
    }

}

package ecommerce.order;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;

import ecommerce.order.dto.OrderRequestDto;
import ecommerce.order.stub.InventoryStubs;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    public void shouldCreateOrder() throws Exception {
        OrderRequestDto orderRequest = getOrderRequest();
        InventoryStubs.stubInventoryCall(orderRequest.skuCode(), orderRequest.quantity());
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(orderRequest)
                .when()
                .post("/api/order")
                .then()
                .log().all()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("orderNumber", Matchers.equalTo(orderRequest.orderNumber()))
                .body("skuCode", Matchers.equalTo(orderRequest.skuCode()))
                .body("price", Matchers.is(orderRequest.price().intValueExact()))
                .body("quantity", Matchers.equalTo(orderRequest.quantity()));
    }

    @Test
    public void shouldGetAllOrder() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/order")
                .then()
                .log().all()
                .statusCode(200)
                .body("$", Matchers.not(Matchers.empty()));
    }

    private OrderRequestDto getOrderRequest() {
        return new OrderRequestDto("202400001", "iphone_15", BigDecimal.valueOf(12000), 1);
    }
}

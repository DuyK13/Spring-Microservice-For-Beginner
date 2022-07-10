package c99.ams.orderservice.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/25/2021 12:47 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {

//    @Autowired
//    IOrderService orderService;
//
//    @Test
//    @DisplayName("Create cart for new user: fail exists cart")
//    void createCart1() {
//        assertThrows(BadRequestException.class, () -> orderService.createCart(new OrderDTO("1L")));
//    }
//
//    @Test
//    @DisplayName("Create cart for new user: success")
//    void createCart2() {
//        String expectedResult = "Create successful";
//        String actualResult = orderService.createCart(new OrderDTO("31L"));
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Add product to cart: new product into cart")
//    void addProduct1() {
//        Order expectedOrder = new Order(12L, "sadasda");
//        expectedOrder.setProducts(Collections.singletonList(new Product("IPhoneXS Max", 1, 1000L)));
//        expectedOrder.setOrderDates(new HashSet<>());
//        expectedOrder.setState(State.CART);
//        Order actualOrder = orderService.addProduct(new Product("IPhoneXS Max", 1, 1000L), "30L");
//        assertEquals(expectedOrder, actualOrder);
//    }
//
//    @Test
//    @DisplayName("Add product to cart: exists product into cart")
//    void addProduct2() {
//        Order expectedOrder = new Order(12L, "asdas");
//        expectedOrder.setProducts(Arrays.asList(new Product("IPhoneXS Max", 4, 1000L), new Product("IPhoneXS Max", 2,
//                1000L), new Product("IPhoneXS Max", 2,
//                1000L)));
//        expectedOrder.setOrderDates(new HashSet<>());
//        expectedOrder.setState(State.CART);
//        Order actualOrder = orderService.addProduct(new Product("IPhoneXS Max", 1, 1000L), "30L");
//        assertEquals(expectedOrder, actualOrder);
//    }
//
//
//    @Test
//    @DisplayName("Update cart: success")
//    void updateCart1() {
//        Order expectedOrder = new Order(11L, "tranthedajk@gmaisdald");
//        expectedOrder.setProducts(Collections.singletonList(new Product("IPhoneXS Max", 4, 1000L)));
//        expectedOrder.setOrderDates(new HashSet<>());
//        expectedOrder.setState(State.CART);
//        Order actualOrder = orderService.updateCart(new ProductDTO(Collections.singletonList(new Product("IPhoneXS Max", 4,
//                1000L))), 23l);
//        assertEquals(expectedOrder, actualOrder);
//    }
//
//    @Test
//    @DisplayName("Get cart: success")
//    void getCartOrOrder1() {
//        Order expectedOrder = new Order(2L, "asdsa", new HashSet<>(), State.CART, Collections.emptyList(), null);
//        Order actualOrder = orderService.getCartOrOrder(2L);
//        assertEquals(expectedOrder, actualOrder);
//    }
//
//    @Test
//    @DisplayName("Get cart: not found")
//    void getCartOrOrder2() {
//        assertThrows(NotFoundException.class, () -> orderService.getCartOrOrder(30L));
//    }
//
//    @Test
//    @DisplayName("Place order: empty cart")
//    void placeOrReceiveOrder1() {
//        assertThrows(BadRequestException.class, () -> orderService.placeOrder(1L, new OrderDTO()));
//    }
//
//    @Test
//    @DisplayName("Place order: success")
//    void placeOrReceiveOrder2() {
//        String expectedResult = "Place order successful";
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setAddress("Vũng Tàu");
//        String actualResult = orderService.placeOrder(5L, orderDTO);
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Receive order: success")
//    void receiveOrder1() {
//        String expectedResult = "Receive order successful";
//        String actualResult = orderService.receiveOrder(4L);
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Cancel order: success")
//    void cancelOrder() {
//        String expectedResult = "Cancel successful";
//        String actualResult = orderService.cancelOrder(7L);
//        assertEquals(expectedResult, actualResult);
//    }
//
//    @Test
//    @DisplayName("Remove order: success")
//    void removeProduct() {
//        Order expectedOrder = new Order();
//        expectedOrder.setId(8L);
//        expectedOrder.setEmail("trnatheduylk13@gmail.com");
//        expectedOrder.setOrderDates(new HashSet<>());
//        expectedOrder.setProducts(Collections.emptyList());
//        expectedOrder.setState(State.CART);
//        Order actualOrder = orderService.removeProduct(new Product("IPhoneXS Max", 1, 1000L), "8L");
//        assertEquals(expectedOrder, actualOrder);
//    }
}
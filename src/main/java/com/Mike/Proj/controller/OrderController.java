// package com.Mike.Proj.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.Mike.Proj.dto.checkout.CheckoutItemDto;
// import com.Mike.Proj.service.AuthenticationService;
// import com.Mike.Proj.service.OrderService;

// @RestController
// @RequestMapping("/order")
// public class OrderController {
    
//     @Autowired
//     private AuthenticationService authenticationService;

//     @Autowired
//     private OrderService orderService;

//     //stripe session checkout api
//     @PostMapping("/create-checkout-session")
//     public ResponseEntity<StripeResponse> checkoutList(@RequestBody List<CheckoutItemDto> checkoutItemDtoList)
//             throws StripeException{
//         Session session = orderService.createSession(checkoutItemDtoList);
//         StripeResponse stripeResponse = new StripeResponse(session.getId());
//         return new ResponseEntity<>(stripeResponse, HttpStatus.OK);
//     }
// }

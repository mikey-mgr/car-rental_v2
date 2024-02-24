package com.Mike.Proj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Mike.Proj.common.APIResponse;
import com.Mike.Proj.dto.cart.AddToCartDto;
import com.Mike.Proj.dto.cart.CartDto;
import com.Mike.Proj.model.User;
import com.Mike.Proj.service.AdminService;
import com.Mike.Proj.service.AuthenticationService;
import com.Mike.Proj.service.CartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:8500")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    AdminService adminService;

    //post cart api to add items
    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToCart(@RequestBody AddToCartDto addToCartDto, 
                                                @RequestParam ("token") String token){
        //authenticate user n token
        authenticationService.authenticate(token);

        //find the user
        User user = authenticationService.getUser(token);

        //add item to cart
        cartService.addToCart(addToCartDto, user);

        return new ResponseEntity<>(new APIResponse(true, "Added to cart"), HttpStatus.CREATED);

    }
    
    //get all cart items for a user
    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
        //authenticate user n token
        authenticationService.authenticate(token);

        //find the user
        User user = authenticationService.getUser(token);
        
        //return cart item
        CartDto cartDto = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    //delete a cart item for a user
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<APIResponse> deleteCartitem(@PathVariable("cartItemId") Integer itemId, 
                                                        @RequestParam("token") String token){
        //authenticate user n token
        authenticationService.authenticate(token);

        //find the user
        User user = authenticationService.getUser(token);

        //find the cart
        cartService.deleteFromCart(itemId, user);

        return new ResponseEntity<>(new APIResponse(true, "Item has been removed from cart"), HttpStatus.OK);
    }
}
package com.Mike.Proj.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Mike.Proj.common.APIResponse;
import com.Mike.Proj.dto.ProductDto;
import com.Mike.Proj.model.Product;
import com.Mike.Proj.model.User;
import com.Mike.Proj.model.Wishlist;
import com.Mike.Proj.service.AuthenticationService;
import com.Mike.Proj.service.WishlistService;

@RestController
@CrossOrigin("http://localhost:8500")
@RequestMapping("/wishlist")
public class WishlistController {
    
    @Autowired
    WishlistService wishlistService;

    @Autowired
    AuthenticationService authenticationService;

    //save products as wishlist item
    @PostMapping("/add")
    public ResponseEntity<APIResponse> addToWishlist(@RequestBody Product product, @RequestParam("token") String token){
        
        //authenticate user
        authenticationService.authenticate(token);
        //find the user
        User user = authenticationService.getUser(token);

        //save the item in wishlist
        Wishlist wishlist = new Wishlist(user, product);
        wishlistService.createWishlist(wishlist);

        APIResponse apiResponse = new APIResponse(true, "Added to wishlist");
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    // get all wishlist items for a user
    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDto>> getWishlist(@PathVariable ("token") String token){
        //authenticate the token
        authenticationService.authenticate(token);
        
        //find the user
        User user = authenticationService.getUser(token);

        List<ProductDto> productDtos = wishlistService.getWishlistForUser(user);
        return new ResponseEntity<List<ProductDto>>(productDtos, HttpStatus.OK);

    }

}

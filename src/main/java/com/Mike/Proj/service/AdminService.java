package com.Mike.Proj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mike.Proj.dto.UserDto;
import com.Mike.Proj.dto.cart.CartDto;
import com.Mike.Proj.dto.cart.CartItemDto;
import com.Mike.Proj.exceptions.AuthenticationFailException;
import com.Mike.Proj.exceptions.CustomException;
import com.Mike.Proj.model.Cart;
import com.Mike.Proj.model.User;
import com.Mike.Proj.repository.CartRepo;
import com.Mike.Proj.repository.UserRepo;

@Service
public class AdminService {
    @Autowired
    CartRepo cartRepo;

    @Autowired
    UserRepo userRepo;

    //generate booking list sorted according to date booked for
    public CartDto listCartBookings() {
        List<Cart> cartList = cartRepo.findAll();
        
        List<CartItemDto> cartItems = new ArrayList<>();

        if(Objects.isNull(cartList)){
            throw new CustomException("Cart contains no products");
        }

        double totalCost = 0;
        for(Cart cart: cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }
        CartDto cartDto = new CartDto();
        cartDto.setCartItems(cartItems);
        cartDto.setTotalCost(totalCost);

        return cartDto;
    }

    //delete cart item as admin
    public void deleteCartItem(Integer cartItemId, User user) {
        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);
        //check if cart item exists
        if(optionalCart.isEmpty()){
            throw new CustomException("Cart item is invalid: " + cartItemId);
        }
        Cart cart = optionalCart.get();

        cartRepo.delete(cart); 
    }

    public void verifyAdminUser(User user) {
        if(Objects.isNull(user.getRole())){
            throw new AuthenticationFailException("You cannot access this information");
        }
    }

    //get a list of all users
    public List<UserDto> getUsers(){
        List<User> allUsers = userRepo.findAll();

        List<UserDto> users = new ArrayList<>();

        for(User user: allUsers){
            UserDto userDto = new UserDto(user);
            users.add(userDto);
        }
        return users;
    }
}
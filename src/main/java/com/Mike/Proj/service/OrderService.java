// package com.Mike.Proj.service;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;
// import com.Mike.Proj.dto.checkout.CheckoutItemDto;

// @Service
// public class OrderService {

//     @Value("${BASE_URL}")
//     private String baseURL;

//     @Value("${STRIPE_SECRET_KEY}")
//     private String apikey;

//     public Session createSession(List<CheckoutItemDto> checkoutItemDtoList) throws StripeException{
//         //success & failure URL's
//         String successURL = baseURL + "payment/success";

//         String failureURL = baseURL + "payment/failed";

//         Stripe.apiKey = apikey;

//         List <SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();

//         for(CheckoutItemDto checkoutItemDto: checkoutItemDtoList){
//             sessionItemList.add(createSessionLineItem(checkoutItemDto));
//         }

//         SessionCreateParams params = SessionCreateParams.builder()
//                 .addPaymentMethodtype(SessionCreateParams.PaymentMethodType.CARD)
//                 .setMode(SessionCreateParams.Mode.Payment)
//                 .setCancelUrl(failureURL)
//                 .setSuccessUrl(successURL)
//                 .addLineItem(sessionItemList)
//                 .build();
//         return Session.create(params);
//     }

//     private SessionCreateParams.Lineitem createSessionLineItem(CheckoutItemDto checkoutItemDto){

//         return SessionCreateparams.LineItem.builder()
//         .setPriceData(createPriceData(checkoutItemDto))
//         .setQuantity(Long.parseLong(String.valueOf(checkoutItemDto.getQuantity())))
//         .build();
//     }

//     private SessionCreateParams.LineItem.PriceData createPriceData(CheckoutItemDto checkoutItemDto) {
//        return SessionCreateParams.LineItem.PriceData.builder()
//        .setCurrency("usd")
//        .setUnitAmount((long)(checkoutItemDto.getPrice()*100))
//        .setProductData(
//             SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                 .setName(checkoutItemDto.getProductName()
//                 .build())
//         ).build();
//     }
// }

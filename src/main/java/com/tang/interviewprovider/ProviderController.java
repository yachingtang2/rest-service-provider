package com.tang.interviewprovider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

  @GetMapping("/menu")
  public ResponseEntity<Food> getMenu() {
    Food food = new Food("French Fries");
    return new ResponseEntity<>(food, HttpStatus.OK);
  }

  @GetMapping("/menu/frenchFries")
  public ResponseEntity<Price> getFrenchFries() {
    Price price = new Price(5);
    return new ResponseEntity<>(price, HttpStatus.OK);
  }

  @GetMapping("/menu/soup")
  public ResponseEntity<Food> getSoup() {
    return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }

  @GetMapping("/order")
  public ResponseEntity<FoodOrder> getOrder(@RequestParam(defaultValue = "French Fries") String item,
                                       @RequestParam() int count) {
    Food food = new Food(item);
    FoodOrder foodOrder = new FoodOrder(food, count);
    return new ResponseEntity<>(foodOrder, HttpStatus.OK);
  }

  @GetMapping("/{favorite}/{count}")
  public ResponseEntity<FoodOrder> getFavoriteOrder(@PathVariable("favorite") String favorite,
                                                  @PathVariable("count") int count) {
    Food food = new Food(favorite);
    FoodOrder foodOrder = new FoodOrder(food, count);

    return new ResponseEntity<>(foodOrder, HttpStatus.OK);
  }

}

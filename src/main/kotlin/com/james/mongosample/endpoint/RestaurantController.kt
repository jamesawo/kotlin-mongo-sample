package com.james.mongosample.endpoint

import com.james.mongosample.document.Restaurant
import com.james.mongosample.repository.RestaurantRepo
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/restaurant")
class RestaurantController(
    val repo: RestaurantRepo
) {

    @GetMapping()
    fun countRestaurant(): Int {
        return repo.findAll().count()
    }

    @GetMapping("/{id}")
    fun findRestaurant(@PathVariable("id") id: String): ResponseEntity<Restaurant> {
        val result = repo.findByRestaurantId(id)
        return if (result != null) ResponseEntity.ok(result) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun postRestaurant(): Restaurant {
        val restaurant = Restaurant().copy( name = "sample restaurant", restaurantId = "33332")
        return repo.insert(restaurant)
    }

    @PatchMapping("/{id}")
    fun updateRestaurant(@PathVariable("id") id: String): Restaurant? {
        return repo.findByRestaurantId(id)?.let {
            return repo.save(it.copy(name = "Updated"))
        }
    }

    @DeleteMapping("/{id}")
    fun removeRestaurant(@PathVariable("id") id: String){
        repo.findByRestaurantId(id )?.let {  repo.delete(it) }
    }
}
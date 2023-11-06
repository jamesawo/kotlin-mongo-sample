package com.james.mongosample.repository

import com.james.mongosample.document.Restaurant
import org.springframework.data.mongodb.repository.MongoRepository

interface RestaurantRepo: MongoRepository<Restaurant, String> {
    fun findByRestaurantId(id: String): Restaurant?

}
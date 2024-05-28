package io.ionic.portalsecommerce.data

import android.content.Context
import io.ionic.portalsecommerce.data.model.Cart
import io.ionic.portalsecommerce.data.model.CartItem
import io.ionic.portalsecommerce.data.model.Product


class ShoppingCart private constructor(val context: Context){

    companion object {
        private var instance: ShoppingCart? = null

        fun getInstance(context: Context): ShoppingCart {
            return instance ?: synchronized(this) {
                instance ?: ShoppingCart(context.applicationContext).also { instance = it }
            }
        }
    }

    var contents : HashMap<Product, Int> = HashMap<Product, Int> ()

    fun addItem(product: Product?) {
        addItem(product, 1)
    }

    fun addItem(product: Product?, amount: Int) {
        if (amount > 0) {
            if (contents!!.containsKey(product!!)) {
                contents.put(product, contents!![product!!]!! + amount)
            } else {
                contents.put(product, amount)
            }
        }
    }

    fun removeItem(product: Product?) {
        removeItem(product, 1)
    }

    fun removeItem(product: Product?, amount: Int) {
        if (amount > 0 && contents!!.containsKey(product!!)) {
            if (contents!![product!!]!! <= amount) {
                contents.remove(product)
            } else {
                contents.put(product, contents!![product!!]!! - amount)
            }
        }
    }

    fun getCart(): Cart {
        val cart = Cart()
        cart.id = 1
        for ((product, quantity) in contents) {
            val cartItem = CartItem()
            cartItem.productId = product.id
            cartItem.quantity = quantity
            cart.subTotal += product.price * quantity
            cart.basket.add(cartItem)
        }
        return cart
    }

    fun getUniqueItemCount(): Int {
        return contents.keys.size
    }
    fun checkout(result: String) {
        if (result == "success") {
            contents.clear()
        }
    }

    fun getTotalPriceOfProductsInCart(): Float {
        var sum = 0f
        for ((key, value) in contents) {
            sum += key.price * value
        }
        return sum
    }
}
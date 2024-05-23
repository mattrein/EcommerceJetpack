package io.ionic.portalsecommerce.data.model


class Cart {
    var id: Int = 0
    var subTotal: Float = 0f
    var basket: ArrayList<CartItem> = ArrayList()
}
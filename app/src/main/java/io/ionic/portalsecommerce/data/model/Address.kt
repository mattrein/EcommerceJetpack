package io.ionic.portalsecommerce.data.model

data class Address (
    var id: Int = 0,
    var street: String? = null,
    var city: String? = null,
    var state: String? = null,
    var postal: String? = null,
    var preferred: Boolean = false
)
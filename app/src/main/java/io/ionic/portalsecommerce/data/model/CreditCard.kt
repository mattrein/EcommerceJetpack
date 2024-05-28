package io.ionic.portalsecommerce.data.model

data class CreditCard (
    var id: Int = 0,
    var company: String? = null,
    var number: String? = null,
    var expirationDate: String? = null,
    var zip: String? = null,
    var cvv: String? = null,
    var preferred: Boolean = false
)
package io.ionic.portalsecommerce.data.model


data class User (
    var id: Int = 0,
    var firstName: String? = null,
    var lastName: String? = null,
    var email: String? = null,
    var image: String? = null,
    var addresses: ArrayList<Address>? = null,
    var creditCards: ArrayList<CreditCard>? = null,
) {
    fun fullName(): String {
        return "${firstName} ${lastName}"
    }

}
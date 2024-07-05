package io.ionic.portalsecommerce.ui.cart

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.data.model.CreditCard
import io.ionic.portalsecommerce.data.model.User
import kotlin.random.Random

class CheckoutViewModel(context: Context): ViewModel() {

    private val context = context
    private val savedUser = DataService.getInstance(context).getUser()!!

    private val _user = mutableStateOf(savedUser)
    val user: State<User> get() = _user

    private val _addresses = mutableStateOf(_user.value.addresses!!)
    val addresses: ArrayList<Address> get() = _addresses.value

    private val _payments = mutableStateOf(_user.value.creditCards!!)
    val payments: ArrayList<CreditCard> get() = _payments.value

    fun onAddressSelect(selectedAddress: Address) {
        for (address in _user.value.addresses!!) {
            address.copy(preferred = address.id == selectedAddress.id)
        }

    }

    fun onPaymentSelect(selectedCreditCard: CreditCard) {
        for (creditCard in _user.value.creditCards!!) {
            creditCard.copy(preferred = creditCard.id == selectedCreditCard.id)
        }
    }
}
package io.ionic.portalsecommerce.ui.payment

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.data.model.CreditCard
import io.ionic.portalsecommerce.data.model.User

class PaymentViewModel(context: Context, paymentId: Int): ViewModel() {

    private val context = context
    private val savedUser = DataService.getInstance(context).getUser()!!

    private val _user = mutableStateOf(savedUser)
    val user: State<User> get() = _user


    private val editPayment = _user.value.creditCards!!.find  {  it.id == paymentId } ?: CreditCard()
    private val _payment = mutableStateOf(editPayment)
    val payment: State<CreditCard> get() = _payment

    fun onCardNumberChange(newCardNumber: String) {
        _payment.value = _payment.value.copy(number = newCardNumber)
    }
    fun onExpDateChange(newExpDate: String) {
        _payment.value = _payment.value.copy(expirationDate = newExpDate)
    }

    fun onCVVChange(newCVV: String) {
        _payment.value = _payment.value.copy(cvv = newCVV)
    }

    fun onZipChange(newZip: String) {
        _payment.value = _payment.value.copy(zip = newZip)
    }

    fun onPreferredChange(newPreferred: Boolean) {
        _payment.value = _payment.value.copy(preferred = newPreferred)
    }

    fun onSave() {
        if(_payment.value.id != 0) {
            val index = _user.value.creditCards!!.indexOfFirst { it.id ==_payment.value.id }
            _user.value.creditCards!![index] = _payment.value
        } else {
            _payment.value.id = _user.value.creditCards!!.count() + 1
            _user.value.creditCards!!.add(_payment.value)
        }
        if(_payment.value.preferred) {
            for (payment in _user.value.creditCards!!) {
                if(payment.id != _payment.value.id) {
                    payment.preferred = false
                }
            }
        }
    }
}
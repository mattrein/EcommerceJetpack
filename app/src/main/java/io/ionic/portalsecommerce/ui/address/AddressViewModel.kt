package io.ionic.portalsecommerce.ui.address

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.model.Address
import io.ionic.portalsecommerce.data.model.User
import kotlin.random.Random

class AddressViewModel(context: Context, addressId: Int): ViewModel() {

    private val context = context
    private val savedUser = DataService.getInstance(context).getUser()!!

    private val _user = mutableStateOf(savedUser)
    val user: State<User> get() = _user

    private val editAddress = _user.value.addresses!!.find  {  it.id == addressId } ?: Address()
    private val _adddress = mutableStateOf(editAddress)
    val address: State<Address> get() = _adddress

    fun onAddressChange(newAddress: String) {
        _adddress.value = _adddress.value.copy(street = newAddress)
    }
    fun onZipCodeChange(newZipCode: String) {
        _adddress.value = _adddress.value.copy(postal = newZipCode)
    }
    fun onCityChange(newCity: String) {
        _adddress.value = _adddress.value.copy(city = newCity)
    }
    fun onStateChange(newState: String) {
        _adddress.value = _adddress.value.copy(state = newState)
    }
    fun onPreferredChange(newPreferred: Boolean) {
        _adddress.value = _adddress.value.copy(preferred = newPreferred)
    }

    fun onSave() {
        if(_adddress.value.id != 0) {
            val index = _user.value.addresses!!.indexOfFirst { it.id ==_adddress.value.id }
            _user.value.addresses!![index] = _adddress.value
        } else {
            _adddress.value.id = _user.value.addresses!!.count() + 1
            _user.value.addresses!!.add(_adddress.value)
        }
        if(_adddress.value.preferred) {
            for (address in _user.value.addresses!!) {
                if(address.id != _adddress.value.id) {
                    address.preferred = false
                }
            }
        }
    }
}
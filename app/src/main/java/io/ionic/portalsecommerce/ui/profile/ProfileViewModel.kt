package io.ionic.portalsecommerce.ui.profile

import android.content.Context
import android.provider.ContactsContract.Data
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import io.ionic.portalsecommerce.data.DataService
import io.ionic.portalsecommerce.data.model.User

class ProfileViewModel(context: Context): ViewModel() {

    private val context = context
    private val savedUser = DataService.getInstance(context).getUser()!!

    private val _user = mutableStateOf(savedUser)
    val user: State<User> get() = _user

    val adddresses = _user.value.addresses!!
    fun onFirstNameChange(newFirstName: String) {
        _user.value = _user.value.copy(firstName = newFirstName)
        DataService.getInstance(context).setUser(_user.value)
    }
    fun onLastNameChange(newLastName: String) {
        _user.value = _user.value.copy(lastName = newLastName)
        DataService.getInstance(context).setUser(_user.value)
    }
    fun onEmailChange(newEmail: String) {
        _user.value = _user.value.copy(email = newEmail)
        DataService.getInstance(context).setUser(_user.value)
    }

}
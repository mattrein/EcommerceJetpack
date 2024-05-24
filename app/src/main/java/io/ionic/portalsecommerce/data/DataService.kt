package io.ionic.portalsecommerce.data

import android.content.Context
import com.google.gson.Gson
import io.ionic.portalsecommerce.data.model.AppData
import io.ionic.portalsecommerce.data.model.Product
import io.ionic.portalsecommerce.data.model.User


class DataService private constructor(val context: Context){

    companion object {
        private var instance: DataService? = null

        fun getInstance(context: Context): DataService {
            return instance ?: synchronized(this) {
                instance ?: DataService(context.applicationContext).also { instance = it }
            }
        }
    }

    val fileInString: String = context.assets.open("data.json").bufferedReader().use { it.readText() }
    private var appData: AppData = Gson().fromJson(fileInString, AppData::class.java)

    fun getProducts(): ArrayList<Product> {
        return appData.products!!
    }

    fun getProduct(id: Int): Product? {
        val product = appData.products?.find {  it.id == id }
        return product
    }

    fun getUser(): User? {
        return appData.user
    }

    fun setUser(user: User?) {
        appData.user = user
    }
}


//
//class DataService private constructor(context: Context) {
//    companion object {
//        @Volatile
//        private var dataService: DataService? = null
//
//        fun getInstance(context: Context): DataService {
//            dataService ?: synchronized(this) {
//                dataService ?: constructor(context).also { dataService = it }
//            }
//            return dataService!!
//        }
//
//        private fun constructor(context: Context) {
//
//        }
//    }
//
//
//
//}

//        val fileInString: String = context.assets.open("data.json").bufferedReader().use { it.readText() }
//

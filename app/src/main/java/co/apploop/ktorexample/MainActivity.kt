package co.apploop.ktorexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import co.apploop.ktorexample.model.Response
import co.apploop.ktorexample.utils.showLog
import co.apploop.ktorexample.viewmodel.ProfileViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        apiResponse {
            showLog("API RESPONSE -> ${it?.data}")
        }
    }

    private fun apiResponse(apiRes: (Response?) -> Unit) {
        lifecycleScope.launch {
            profileViewModel.responseFlow.collect { data ->
                apiRes(data)
            }
        }
    }
}
package co.apploop.ktorexample.utils

import android.util.Log

//To show the log messages
fun showLog(message: String?, tag: String = TAG) {
    message?.let {
        printFullLog(message, tag)
    }
}


private fun printFullLog(message: String, tag: String) {
    if (message.length > 3000) {
        Log.e(tag, message.substring(0, 3000))
        printFullLog(message.substring(3000), tag)
    } else {
        Log.e(tag, message)
    }
}
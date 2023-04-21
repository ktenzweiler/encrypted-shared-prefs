package com.example.encryptedsharedprefsdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.encryptedsharedprefsdemo.ui.theme.EncryptedSharedPrefsDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EncryptedSharedPrefsDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val id1 = "101"
                    val user1 = "Golden Retriever"
//
//                    val id2 = "102"
//                    val user2 = "Bob"


                    //val sharedPrefsFileName = "user_shared_prefs"
                    val sharedPrefsFileName = "dogs_shared_prefs"

                    val cryptoUtils = CryptoUtils()

                    cryptoUtils.saveToSharedPrefs(
                        sharedPrefsFileName = sharedPrefsFileName,
                        context = this, lookupAlias = id1, plainText = user1
                    )

                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EncryptedSharedPrefsDemoTheme {
        Greeting("Android")
    }
}
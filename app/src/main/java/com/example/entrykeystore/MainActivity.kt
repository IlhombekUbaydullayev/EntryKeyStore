package com.example.entrykeystore

import android.os.Build
import android.os.Bundle
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.security.KeyPairGenerator
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initViews() {
        KeyStore().generateKey()
        val pair = KeyStore().encryptData("fjerifjweiferjfewkferjfejrgjrewfherbhfrbtghebfherbfergbgberhbgrhefbehrbgfrthbgerhbferhbfergbrhgberbfherbfhgbrhebgerhfbher==")
        val decryptedData = KeyStore().decryptData(pair.first, pair.second)
        val pairTwo = KeyStore().encryptData("addfgadfdgfasdfgfsdfg")
        val decryptedDataTwo = KeyStore().decryptData(pairTwo.first, pairTwo.second)
        val encrypted = pair.second.toString(Charsets.UTF_8)
        val encryptedSecond = pairTwo.second.toString(Charsets.UTF_8)
        Log.d("DataEncrypt","Encrypted data: $encrypted")
        Log.d("DataEncrypt","Decrypted data: $decryptedData")
        Log.d("DataEncrypt","Encrypted data Second: $encryptedSecond")
        Log.d("DataEncrypt","Decrypted data Second: $decryptedDataTwo")
    }

}
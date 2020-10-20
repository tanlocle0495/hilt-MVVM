package com.loc.lt.android.mvvm.utils.security

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import java.nio.charset.Charset
import java.util.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.inject.Singleton
import kotlin.collections.HashMap

@Singleton
class SecurityUtils {

  private  fun keyGenerator() :SecretKey{
        val keyGenerator: KeyGenerator =
            KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        val keyGenParameterSpec = KeyGenParameterSpec.Builder(
            "MyKeyAlias",
            KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
        )
            .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
            .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
            .setRandomizedEncryptionRequired(true)
            .build()
        keyGenerator.init(keyGenParameterSpec)
      return  keyGenerator.generateKey()
    }

    fun storeDataExample(data:String) : HashMap<String,String>{
        val map: HashMap<String,String> = HashMap()
        val  secreckey = keyGenerator();
        val cipher:Cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES+"/"+KeyProperties.BLOCK_MODE_CBC+"/"
                +KeyProperties.ENCRYPTION_PADDING_PKCS7)
        val ivBytes = cipher.iv
        val ivSpec = IvParameterSpec(ivBytes)
        cipher.init(Cipher.DECRYPT_MODE, secreckey, ivSpec)
        val passwordByte = data.toByteArray(Charset.defaultCharset())
        val cipherPassword =cipher.doFinal(passwordByte)
        val endCodePassword =  Base64.getEncoder().encodeToString(cipherPassword)
        val endCodeIvBytes =  Base64.getEncoder().encodeToString(ivBytes)
        Log.e("password","$passwordByte")
        Log.e("encryptionIv","$ivBytes")
        map["password"] = endCodePassword
        map["encryptionIv"] =  endCodeIvBytes
    return map

    }
}
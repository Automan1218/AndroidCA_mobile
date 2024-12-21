package com.example.androidca

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.widget.Toast

class SMSReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle: Bundle? = intent.extras
            val pdus = bundle?.get("pdus") as? Array<*>
            if (pdus != null) {
                val messages = pdus.mapNotNull {
                    SmsMessage.createFromPdu(it as ByteArray)
                }

                for (message in messages) {
                    val sender = message.originatingAddress
                    val body = message.messageBody

                    // 显示短信内容
                    Toast.makeText(context, "Message from $sender: $body", Toast.LENGTH_LONG).show()

                    // 将短信内容传递到活动
                    val regex = Regex("""\b\d{4,6}\b""") // 匹配 4-6 位数字
                    val code = regex.find(body)?.value
                    if (code != null && context is RegisterActivity) {
                        // 将验证码更新到活动
                        context.updateVerificationCode(code)
                    }
                }
            }
        }
    }
}
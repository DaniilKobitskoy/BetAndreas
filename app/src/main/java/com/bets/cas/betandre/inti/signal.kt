package com.bets.cas.betandre.inti

import android.app.Application
import com.bets.cas.betandre.apsflyers
import com.onesignal.OneSignal
import org.json.JSONObject

class signal : Application() {

    override fun onCreate() {
        super.onCreate()
        try {

            OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
            OneSignal.initWithContext(this)
            OneSignal.setAppId(sharedkey.signal)
            OneSignal.setExternalUserId(apsflyers!!, object :
                OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(sfglfjdvldijkdsf: JSONObject) {
                }
                override fun onFailure(dfksvhdjkfnmds: OneSignal.ExternalIdError) {

                }
            })





        }catch (e: Exception){

        }
    }
}
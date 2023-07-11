package com.grace.makemusic.ui.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.annotation.MainThread
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.databinding.DataBindingUtil
import com.grace.makemusic.MainActivity
import com.grace.makemusic.ui.theme.BasicStateCodelabTheme
import com.grace.makemusic.R
import com.grace.makemusic.SPLASH_DELAY
import com.grace.makemusic.base.BaseActivity
import com.grace.makemusic.databinding.ActivityIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroActivity : BaseActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        // binding 세팅
       // binding = DataBindingUtil.setContentView(this, R.layout.activity_intro)
        // 현재 binding시킨 xml의 variable name
       // binding.intro = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            introDraw()
        }
        navigateToMainScreen()

    }



    @Preview (showSystemUi = true, showBackground = true )
    @Composable
    fun introDraw() {
        BasicStateCodelabTheme {
            Column(
                modifier = Modifier.padding(50.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IntroScreen()
            }
        }
    }
    private fun navigateToMainScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            val nextScreenIntent = Intent(this, MainActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }, SPLASH_DELAY.toLong())
    }
}
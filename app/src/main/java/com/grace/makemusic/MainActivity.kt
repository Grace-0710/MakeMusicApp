package com.grace.makemusic
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.grace.makemusic.base.BaseActivity
import com.grace.makemusic.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun observeViewModel() {

    }

    override fun initViewBinding() {
        // binding 세팅
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 현재 binding시킨 xml의 variable name
        binding.main = this

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)



    }
}
//hoem(shfotodtjd), 내역(검색명, 날짜, 버튼), 미정, 설정
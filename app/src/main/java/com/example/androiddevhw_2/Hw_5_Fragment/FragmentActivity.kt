package com.example.androiddevhw_2.Hw_5_Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.androiddevhw_2.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        showAFragment()
    }

    fun showAFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, StartFragment.newInstance("A Fragment  ", "Just text"))
            .addToBackStack("BackToA")
            .commit()
        println(supportFragmentManager.backStackEntryCount)
    }

    fun showBFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, FinishFragment.newInstance("B Fragment  ", "Just text"))
            .commit()
        println(supportFragmentManager.backStackEntryCount)
    }

    fun showCFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, CFragment.newInstance("C Fragment  ", "Just text"))
            .commit()
        println(supportFragmentManager.backStackEntryCount)
    }

    fun backToAFragment() {

        getSupportFragmentManager()
            .popBackStack(null, 0);
        showAFragment()
        println(supportFragmentManager.backStackEntryCount)
    }
}

/*

1) Переход по фрагментам А-В-С через fragment transaction
    - при переходе назад с фрагмента С вернуть фрагмент А

2) Используя Navigation Manager выполнить переход
    по фрагментам А-В-С и на фрагменте С выключить кнопку назад

        */
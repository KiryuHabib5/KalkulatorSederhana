package com.magangonline.kalkulatorsederhana

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression


var result : String? = ""
var op : List<Char> = listOf('x',':','+','-','.')
var strSpace = ""

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hitung.setOnClickListener(this)
        satu.setOnClickListener(this)
        dua.setOnClickListener(this)
        tiga.setOnClickListener(this)
        empat.setOnClickListener(this)
        lima.setOnClickListener(this)
        enam.setOnClickListener(this)
        tujuh.setOnClickListener(this)
        delapan.setOnClickListener(this)
        sembilan.setOnClickListener(this)
        nol.setOnClickListener(this)
        tambah.setOnClickListener(this)
        kurang.setOnClickListener(this)
        kali.setOnClickListener(this)
        bagi.setOnClickListener(this)
        titik.setOnClickListener(this)
        clear.setOnClickListener(this)
        hapus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id){
            hitung.id -> {
                if (hasil != null){
                    var userExp = hasil?.text.toString()
                    userExp = userExp.replace(":", "/")
                    userExp = userExp.replace("x", "*")
                    //userExp = userExp.replace(".", ",")
                    userExp = userExp.replace(" ", "")

                    var exp = Expression(userExp)
                    result = exp.calculate().toString()
                }


            }
            satu.id -> {
                result+=satu.text
            }
            dua.id -> {
                result+=dua.text
            }
            tiga.id -> {
                result+=tiga.text
            }
            empat.id -> {
                result+=empat.text
            }
            lima.id -> {
                result+=lima.text
            }
            enam.id -> {
                result+=enam.text
            }
            tujuh.id -> {
                result+=tujuh.text
            }
            delapan.id -> {
                result+=delapan.text
            }
            sembilan.id -> {
                result+=sembilan.text
            }
            nol.id -> {
                result+=nol.text
            }
            clear.id -> {
                result=""
            }
            hapus.id -> {
//                var n = (result?.length)
//                if (n != null) {
//                    result = result?.substring(0, n - 1)
//                } else {
//                    Toast.makeText(applicationContext, "Tidak ada yang bisa dihapus", Toast.LENGTH_SHORT).show()
//                }

                if (result != null) {
                    result = result?.dropLast(1)
                }
            }
            tambah.id -> {
                if (hasil != null){
                    if (!(hasil.text.toString().last() in op)){
                        strSpace = " "+tambah.text.toString()+" "
                        result+=strSpace
                    }
                }
            }
            kurang.id -> {
                if (hasil != null){
                    if (!(hasil.text.toString().last() in op)){
                        strSpace = " "+kurang.text.toString()+" "
                        result+=strSpace
                    }
                }
            }
            kali.id -> {
                if (hasil != null){
                    if (!(hasil.text.toString().last() in op)){
                        strSpace = " "+kali.text.toString()+" "
                        result+=strSpace
                    }
                }
            }
            bagi.id -> {
                if (hasil != null){
                    if (!(hasil.text.toString().last() in op)){
                        strSpace = " "+bagi.text.toString()+" "
                        result+=strSpace
                    }
                }
            }
            titik.id -> {
                if (hasil != null){
                    if (!(hasil.text.toString().last() in op)){
                        result+=titik.text
                    }
                }
            }
        }
        hasil.setText(result)
    }

}

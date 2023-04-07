package com.ebrar.mylibrary

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ebrar.mylibrary.databinding.ActivityMainBinding
import com.ebrar.mylibrary.databinding.ActivityNextPageBinding

class NextPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextPageBinding
    private lateinit var sharedPreferences: SharedPreferences
    var bookPreferences: String? =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setupLoadData()


    }
    fun setupBinding(){
        binding = ActivityNextPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    fun setupLoadData()
    {
        sharedPreferences = this.getSharedPreferences("com.ebrar.mylibrary", MODE_PRIVATE)
        val bookPreferences = sharedPreferences.getString("bookName","")
        if(bookPreferences==""){
            binding.saveTextView.text=""
        }
        else{
            binding.saveTextView.text="kitap {bookPreferences}"
        }
    }

   fun addAction(view: View){ // ekleme işlemi
       sharedPreferences = this.getSharedPreferences("com.ebrar.mylibrary", MODE_PRIVATE)
       val bookName = binding.booknameTextView.text.toString()
      // bookName= sharedPreferences.getString("bookName","").toString()
       if(bookName =="") {
           Toast.makeText(this,"kaydetme başarısız!", Toast.LENGTH_LONG).show()
       }
       else{
           if(binding.result1TextView.text=="") {
           binding.result1TextView.text="1.Kitap "+bookName
           sharedPreferences.edit().putString("bookname", bookName).apply()
           }
           else if (binding.result1TextView.text!="" && binding.result2TextView.text==""){
               binding.result2TextView.text="2.Kitap "+bookName
               sharedPreferences.edit().putString("bookname", bookName).apply()
           }
           else if (binding.result1TextView.text!="" && binding.result2TextView.text!="" && binding.result3TextView.text==""){
               binding.result3TextView.text="3.Kitap "+bookName
               sharedPreferences.edit().putString("bookname", bookName).apply()
           }else if (binding.result1TextView.text!="" && binding.result2TextView.text!="" && binding.result3TextView.text!="" && binding.result4TextView.text=="" ){
               binding.result4TextView.text="4.Kitap "+bookName
               sharedPreferences.edit().putString("bookname", bookName).apply()
           }else if (binding.result1TextView.text!="" && binding.result2TextView.text!="" && binding.result3TextView.text!="" &&binding.result4TextView.text!="" &&binding.result5TextView.text=="" ){
               binding.result5TextView.text="5.Kitap "+bookName
               sharedPreferences.edit().putString("bookname", bookName).apply()
           }
           Toast.makeText(this,"kitap kaydedildi!", Toast.LENGTH_LONG).show()
       }
   }
      fun deleteAction(view: View){ // silme işlemi
          sharedPreferences = this.getSharedPreferences("com.ebrar.mylibrary", MODE_PRIVATE)
          val bookName = binding.booknameTextView.text.toString()
          bookPreferences = sharedPreferences.getString("bookName","")
          val alert = AlertDialog.Builder(this)
          alert.setTitle("Delete")
          alert.setMessage("Silmek istediğinizden emin misiniz?")
          alert.setPositiveButton("Yes"){dialog, which ->
              Toast.makeText(this,"Silindi",Toast.LENGTH_LONG).show()
          }
          alert.setNegativeButton("No"){dialog,which ->
              Toast.makeText(this,"Silinmedi",Toast.LENGTH_LONG).show()
          }
          alert.show()

          if(bookPreferences !=""){
              if(binding.result1TextView.text == bookName){
                  sharedPreferences.edit().remove("bookName").apply()
              }
              else if(binding.result2TextView.text == bookName){
                  sharedPreferences.edit().remove("bookName").apply()
              }
              else if(binding.result3TextView.text == bookName){
                  sharedPreferences.edit().remove("bookName").apply()
              }
              else if(binding.result4TextView.text == bookName){
                  sharedPreferences.edit().remove("bookName").apply()
              }
              else if(binding.result5TextView.text == bookName){
                  sharedPreferences.edit().remove("bookName").apply()
              }
              else{
                  binding.saveTextView.text = "kitap bulunamadı"
              }

          }


    }
}
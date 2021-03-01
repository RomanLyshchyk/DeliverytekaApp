package com.example.deliverytekaapp

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.deliverytekaapp.api.ApiFactory
import com.example.deliverytekaapp.database.AppDatabase
import com.example.deliverytekaapp.pojo.FavouriteMedicine
import com.example.deliverytekaapp.pojo.Medicine
import com.example.deliverytekaapp.pojo.UserInfo
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MedicineViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    val medicine = db.medicineInfoDao().getMedicine()
    val favouriteMedicine = db.medicineInfoDao().getFavouriteMedicine()
    private val compositeDisposable = CompositeDisposable()
    init {
        loadDataMedicine()
    }

    private fun loadDataMedicine() {
        val disposable =ApiFactory.apiService.getListMedicine()
            .subscribeOn(Schedulers.io())
            .subscribe({
                Log.i("IMAGE",it[0].imageUrl.toString())
                db.medicineInfoDao().insertMedicineList(it)
            }, {
                Log.d("TEST_OF_LOADING_DATA", it.toString())
            })
        compositeDisposable.add(disposable)
    }


    fun insertFavouriteMedicine(medicine: List<FavouriteMedicine>) {
        db.medicineInfoDao().insertFavouriteMedicine(medicine)
    }

    fun deleteFavouriteMovie(medicine: List<FavouriteMedicine>) {
        db.medicineInfoDao().insertFavouriteMedicine(medicine)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
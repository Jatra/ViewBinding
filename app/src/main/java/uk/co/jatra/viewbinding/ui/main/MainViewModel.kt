package uk.co.jatra.viewbinding.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(var counter: Counter):  ViewModel() {
    private val _liveData: MutableLiveData<Int> = MutableLiveData()
    val liveData: LiveData<Int> = _liveData

    fun click() {
        _liveData.postValue(
            counter.increment()
        )
    }
}
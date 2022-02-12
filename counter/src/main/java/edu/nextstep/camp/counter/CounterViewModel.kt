package edu.nextstep.camp.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val _count = MutableLiveData(0)
        val count: LiveData<Int>
            get() = _count

    fun up() {
        val count = _count.value ?: return
        _count.value = count + 1
    }

    fun down() {
        val count = _count.value ?: return
        _count.value = count - 1
    }
}
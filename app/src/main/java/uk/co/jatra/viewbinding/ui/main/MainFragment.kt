package uk.co.jatra.viewbinding.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jatra.viewbinding.databinding.MainFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> MainFragmentBinding
        get() = MainFragmentBinding::inflate

    val viewModel by viewModels<MainViewModel>()

    override fun setObservers() {
        viewModel.liveData.observe(viewLifecycleOwner, Observer<Int> { update(it)} )
    }

    override fun setListeners() {
        binding.button.setOnClickListener { viewModel.click() }
    }

    private fun update(count: Int) {
        binding.message.text = "Clicked $count times"
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
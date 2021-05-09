package uk.co.jatra.viewbinding.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jatra.viewbinding.databinding.MainFragmentBinding

@AndroidEntryPoint
class MainFragment : BaseFragment<MainFragmentBinding, MainViewModel>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> MainFragmentBinding
        get() = MainFragmentBinding::inflate

    override fun setObservers() {
        with(viewModel) {
            liveData.observe(viewLifecycleOwner, Observer<Int> { update(it) })
            // and more reaction
        }
    }

    override fun setListeners() {
        with(binding) {
            button.setOnClickListener { viewModel.click() }
            //and any other input handling
        }
    }

    private fun update(count: Int) {
        binding.message.text = "Clicked $count times"
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
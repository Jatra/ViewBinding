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

    @Inject
    lateinit var counter: Counter
    val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val root = super.onCreateView(inflater, container, savedInstanceState)
        setObservers()
        binding.button.setOnClickListener { viewModel.click() }
        return root
    }

    private fun setObservers() {
        viewModel.liveData.observe(viewLifecycleOwner, Observer<Int> { update(it)} )
    }

    private fun update(count: Int) {
        binding.message.text = "Clicked $count times"
    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> MainFragmentBinding
        get() = MainFragmentBinding::inflate


    companion object {
        fun newInstance() = MainFragment()
    }
}
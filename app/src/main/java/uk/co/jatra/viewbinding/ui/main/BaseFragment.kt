package uk.co.jatra.viewbinding.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel> : Fragment() {

    val viewModel by viewModels<MainViewModel>()

    private var _binding: VB? = null

    // This property is only valid between onCreateView and onDestroyView.
    protected val binding
        get() = _binding
            ?: throw IllegalStateException("Cannot access view in after view destroyed and before view creation")

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater.invoke(inflater, container, false)
        setObservers()
        setListeners()
        return binding.root
    }

    open fun setListeners() {
    }

    open fun setObservers() {
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
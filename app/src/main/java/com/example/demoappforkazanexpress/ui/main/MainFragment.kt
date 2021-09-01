package com.example.demoappforkazanexpress.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demoappforkazanexpress.databinding.MainFragmentBinding
import com.example.demoappforkazanexpress.model.AppState
import com.example.demoappforkazanexpress.model.items.HistoryItem
import com.example.demoappforkazanexpress.model.items.WalletsItem
import com.example.demoappforkazanexpress.utils.showSnackBar
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel(){
        viewModel.dataLoadingLiveData.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.loadWalletsListFromServer()
        viewModel.loadHistoryListFromServer()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessWallets ->{
                binding.loadingLayout.visibility = View.GONE
                val walletsList = mutableListOf<WalletsItem>()
                appState.walletsEntityList.forEach { walletsList.add(WalletsItem(it)) }
                binding.walletsRecycler.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(walletsList) }
            }
            is AppState.SuccessHistories -> {
                binding.loadingLayout.visibility = View.GONE
                val historyList = mutableListOf<HistoryItem>()
                appState.historyEntityList.forEach { historyList.add(HistoryItem(it)) }
                binding.historyRecycler.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(historyList) }
            }
            is AppState.Loading ->{
                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error ->{
                binding.loadingLayout.visibility = View.GONE
                view?.showSnackBar("Ошибка: ${appState.error.message}" , "Перезагрузить", {initViewModel()} )
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
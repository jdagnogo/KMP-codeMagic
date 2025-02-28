package com.carrefour.kmpcodemagic.ui.feature.build

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrefour.kmpcodemagic.domain.models.Build
import com.carrefour.kmpcodemagic.domain.usecase.FetchBuildListUseCase
import com.carrefour.kmpcodemagic.domain.usecase.ObserveBuildListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuildViewModel(
    private val fetchBuildListUseCase: FetchBuildListUseCase,
    private val observeBuildListUseCase: ObserveBuildListUseCase
) : ViewModel() {
    private val _buildList = MutableStateFlow<List<Build>>(emptyList())
    val buildList = _buildList.asStateFlow()

    init {
        viewModelScope.launch {
            observeBuildListUseCase().collectLatest{
                _buildList.emit(it)
            }
        }
    }

    fun fetch() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                //TODO : loading
                val titi = fetchBuildListUseCase()
                titi.onSuccess {
                    //TODO : loading  = false
                }.onFailure {
                    //TODO : Toast + error
                }
            }
        }
    }

}
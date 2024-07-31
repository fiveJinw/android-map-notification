package campus.tech.kakao.map.viewmodel.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import campus.tech.kakao.map.model.search.Place
import campus.tech.kakao.map.repository.search.SavedSearchKeywordRepository
import campus.tech.kakao.map.model.search.SearchKeyword
import campus.tech.kakao.map.repository.search.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private var searchRepository: SearchRepository,
    private var savedSearchKeywordRepository: SavedSearchKeywordRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<Place>>(emptyList())
    val searchResults: StateFlow<List<Place>> get() = _searchResults
    private val _savedSearchKeywords = MutableStateFlow<List<SearchKeyword>>(emptyList())
    val savedSearchKeywords: StateFlow<List<SearchKeyword>> get() = _savedSearchKeywords

    init {
        getSavedSearchKeywords()
    }

    fun getSearchResults(searchKeyword: SearchKeyword) {
        viewModelScope.launch {
            _searchResults.value = searchRepository.search(searchKeyword)
        }
    }

    fun saveSearchKeyword(searchKeyword: SearchKeyword) {
        viewModelScope.launch {
            savedSearchKeywordRepository.saveSearchKeyword(searchKeyword)
            getSavedSearchKeywords()
        }
    }

    fun getSavedSearchKeywords() {
        viewModelScope.launch {
            _savedSearchKeywords.value = savedSearchKeywordRepository.getSavedSearchKeywords()
        }
    }

    fun delSavedSearchKeyword(searchKeyword: SearchKeyword) {
        viewModelScope.launch {
            savedSearchKeywordRepository.delSavedSearchKeyword(searchKeyword)
            getSavedSearchKeywords()
        }
    }
}
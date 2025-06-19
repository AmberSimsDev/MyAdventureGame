package presentation.viewmodel

import androidx.lifecycle.ViewModel
import data.local.source.UserNameLocalDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WelcomeScreenViewModel(private val userNameLocalDataSource: UserNameLocalDataSource):ViewModel() {

    private val _name = MutableStateFlow(userNameLocalDataSource.getName())
    val name: StateFlow<String> = _name

    fun onNameChange(newName: String) {
        _name.value = newName
        userNameLocalDataSource.setName(newName)
    }

    fun isNameValid(): Boolean {
        return _name.value.isNotBlank()
    }

}

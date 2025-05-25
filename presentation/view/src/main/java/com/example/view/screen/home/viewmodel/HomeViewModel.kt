package com.example.view.screen.home.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.GetCredentialsUseCase
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getCredentialsUseCase: GetCredentialsUseCase
) : ViewModel(){
    // ViewModel logic for Home can be added here
    // For example, you can handle fetching data, managing UI state, etc.

    // Example function to fetch home data
    fun fetchHomeData() {
        // Implement logic to fetch home data here
        // This could involve calling a repository or use case to get the necessary data
    }
}
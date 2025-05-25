package com.example.view.screen.addEntry.viewmodel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.AddCredentialUseCase
import javax.inject.Inject

class AddEntryViewModel @Inject constructor(
    private val addCredentialUseCase: AddCredentialUseCase
) : ViewModel(){
    // ViewModel logic for AddEntry can be added here
    // For example, you can handle adding entries, managing UI state, etc.

    // Example function to handle adding an entry
    fun addEntry(title: String, content: String) {
        // Implement logic to add an entry here
        // This could involve calling a repository or use case to save the entry
    }
}
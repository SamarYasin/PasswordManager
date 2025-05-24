package com.example.view.home

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.DeleteCredentialUseCase
import javax.inject.Inject

class DeleteEntryViewModel @Inject constructor(
    private val deleteCredentialUseCase: DeleteCredentialUseCase
) : ViewModel(){
    // ViewModel logic for DeleteEntry can be added here
    // For example, you can handle deleting entries, managing UI state, etc.

    // Example function to handle deleting an entry
    fun deleteEntry(id: String) {
        // Implement logic to delete an entry here
        // This could involve calling a repository or use case to remove the entry
    }
}
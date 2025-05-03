package org.example.project.utils

interface SpeechToText {
    fun startListening(onResult: (String) -> Unit)
    fun stopListening()
}

expect fun provideSpeechToTextManager(context: Any): SpeechToText

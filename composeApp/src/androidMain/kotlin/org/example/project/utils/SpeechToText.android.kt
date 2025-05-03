// androidMain/src/.../SpeechToTextProvider.kt
package org.example.project.utils

import android.app.Activity

actual fun provideSpeechToTextManager(context: Any): SpeechToText {
    return AndroidSpeechToText(context as Activity)
}

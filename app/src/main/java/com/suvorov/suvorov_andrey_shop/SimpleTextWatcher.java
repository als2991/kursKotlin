package com.suvorov.suvorov_andrey_shop;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;

public class SimpleTextWatcher implements TextWatcher {

    @NonNull
    public static TextWatcher onTextChanged(@NonNull final OnTextChangedMethod lambda) {
        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before,
                                      final int count) {
                lambda.onTextChanged(s, start, before, count);
            }
        };
    }

    @Override
    public void beforeTextChanged(final CharSequence s, final int start, final int count,
                                  final int after) {
    }

    @Override
    public void onTextChanged(final CharSequence s, final int start, final int before,
                              final int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public interface OnTextChangedMethod {

        void onTextChanged(@NonNull final CharSequence s, final int start, final int before,
                           final int count);
    }
}
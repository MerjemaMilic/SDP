package com.example.seniordesignproject;

import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.seniordesignproject.RegisterActivity.isValidEmail;
import static org.junit.Assert.*;

public class RegisterActivityTest {





    @Test
    public void passwordStrengthTestSuccess() {
            assertTrue(RegisterActivity.isStrong("emaiom123ASD#"));
    }

    @Test
    public void passwordStrengthTestFail() {
        assertFalse(RegisterActivity.isStrong("122"));
    }




}
package com.example.seniordesignproject;

import android.widget.Button;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmitFeedbackActivityTest {
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore fStore;
    String userID;
    FirebaseUser user;

    @Before
    public void setUp() throws Exception {
        mFirebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = mFirebaseAuth.getCurrentUser();
        userID = mFirebaseAuth.getCurrentUser().getUid();
    }

    @Test
    public void firebaseUserExists() {
        assertTrue(mFirebaseAuth.isSignInWithEmailLink("merjema.milic@gmail.com"));
    }
}
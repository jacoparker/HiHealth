package com.dragonnetwork.hihealth.user;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;
import androidx.test.runner.AndroidJUnit4;

import com.dragonnetwork.hihealth.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AcceptanceTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.SEND_SMS");

    /*
    This test mimics a potential user. We are testing all features as if we were a real end user.
    We tested add medication, change profile, add symptoms, send report and tested the UI.
    The app fails due to symptoms page.
     */
    @Test
    public void acceptanceTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("test5@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("0553223939"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.login_password), withText("0553223939"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.login_button), withText("Login"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction linearLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.navigation_header_container),
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.username), withText("test5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                1),
                        isDisplayed()));
        textView.check(matches(withText("test5")));

        ViewInteraction editText = onView(
                allOf(withId(R.id.email), withText("test5@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2),
                        isDisplayed()));
        editText.check(matches(withText("test5@gmail.com")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3),
                        isDisplayed()));
        editText2.check(matches(withText("Phone")));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.doc_name), withText("Doctor Name"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                4),
                        isDisplayed()));
        textView2.check(matches(withText("Doctor Name")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.doc_email), withText("Doctor Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5),
                        isDisplayed()));
        editText3.check(matches(withText("Doctor Email")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.doc_phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                6),
                        isDisplayed()));
        editText4.check(matches(withText("Phone")));

        ViewInteraction linearLayout2 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                3),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.email), withText("test5@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText4.perform(scrollTo(), replaceText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction linearLayout3 = onView(
                allOf(withContentDescription("Paste"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.RelativeLayout")),
                                        1),
                                3),
                        isDisplayed()));
        linearLayout3.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText6.perform(scrollTo(), replaceText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText8.perform(scrollTo(), click());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText9.perform(scrollTo(), click());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText10.perform(scrollTo(), click());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText11.perform(scrollTo(), click());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText12.perform(scrollTo(), click());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText13.perform(scrollTo(), click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText14.perform(scrollTo(), replaceText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"));

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.email), withText("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n<?xml version=1.0\" encoding=\"utf-8\"?>\n<androidx.constraintlayout.widget.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    xmlns:app=\"http://schemas.android.com/apk/res-auto\"\n    xmlns:tools=\"http://schemas.android.com/tools\"\n    android:id=\"@+id/container\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:background=\"@color/backGround\"\n    tools:context=\".user.LoginActivity\">\n\n    <ImageView\n        android:id=\"@+id/imageView2\"\n        android:layout_width=\"248dp\"\n        android:layout_height=\"221dp\"\n        android:layout_gravity=\"center_horizontal\"\n        android:layout_marginTop=\"64dp\"\n        android:src=\"@drawable/logo\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_email\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.496\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.0\" />\n\n    <EditText\n        android:id=\"@+id/login_email\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"60dp\"\n        android:layout_marginStart=\"24dp\"\n        android:layout_marginTop=\"12dp\"\n        android:layout_marginEnd=\"24dp\"\n        android:layout_marginBottom=\"243dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_email\"\n        android:imeActionLabel=\"@string/register_email\"\n        android:inputType=\"textEmailAddress\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/imageView2\" />\n\n    <EditText\n        android:id=\"@+id/login_password\"\n        android:layout_width=\"363dp\"\n        android:layout_height=\"60dp\"\n        android:background=\"@drawable/backgroundborder\"\n        android:hint=\"@string/register_password\"\n        android:imeActionLabel=\"@string/register_password\"\n        android:imeOptions=\"actionDone\"\n        android:inputType=\"textPassword\"\n        android:padding=\"10dp\"\n        android:selectAllOnFocus=\"true\"\n        android:textSize=\"24sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/login_button\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\"\n        app:layout_constraintTop_toBottomOf=\"@+id/login_email\"\n        app:layout_constraintVertical_bias=\"0.164\" />\n\n    <ProgressBar\n        android:id=\"@+id/loading\"\n        android:layout_width=\"0dp\"\n        android:layout_height=\"1dp\"\n        android:layout_gravity=\"center\"\n        android:layout_marginStart=\"32dp\"\n        android:layout_marginTop=\"64dp\"\n        android:layout_marginEnd=\"32dp\"\n        android:layout_marginBottom=\"64dp\"\n        android:visibility=\"gone\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"@+id/login_password\"\n        app:layout_constraintStart_toStartOf=\"@+id/login_password\"\n        app:layout_constraintTop_toTopOf=\"parent\"\n        app:layout_constraintVertical_bias=\"0.3\" />\n\n    <Button\n        android:id=\"@+id/login_button\"\n        android:layout_width=\"419dp\"\n        android:layout_height=\"68dp\"\n        android:layout_marginBottom=\"8dp\"\n        android:background=\"@color/colorTertiary\"\n        android:text=\"@string/login\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toTopOf=\"@+id/link_signup\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n    <Button\n        android:id=\"@+id/link_signup\"\n        android:layout_width=\"415dp\"\n        android:layout_height=\"70dp\"\n        android:background=\"@color/colorSecondary\"\n        android:text=\"@string/register\"\n        android:textColor=\"@color/accent\"\n        android:textSize=\"32sp\"\n        app:layout_constraintBottom_toBottomOf=\"parent\"\n        app:layout_constraintEnd_toEndOf=\"parent\"\n        app:layout_constraintHorizontal_bias=\"0.75\"\n        app:layout_constraintStart_toStartOf=\"parent\" />\n\n</androidx.constraintlayout.widget.ConstraintLayout>\n"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText15.perform(closeSoftKeyboard());

        pressBack();

  

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.navigation_header_container),
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout4.perform(click());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.email), withText("test5@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText16.perform(scrollTo(), click());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.email), withText("test5@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2)));
        appCompatEditText17.perform(scrollTo(), click());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText18.perform(scrollTo(), click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText19.perform(scrollTo(), click());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText20.perform(scrollTo(), click());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText21.perform(scrollTo(), click());

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText22.perform(scrollTo(), click());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3)));
        appCompatEditText23.perform(scrollTo(), replaceText("512"));

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.phone), withText("512"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3),
                        isDisplayed()));
        appCompatEditText24.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.doc_email), withText("Doctor Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5)));
        appCompatEditText25.perform(scrollTo(), click());

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.doc_email), withText("Doctor Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5)));
        appCompatEditText26.perform(scrollTo(), click());

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.doc_email), withText("Doctor Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5)));
        appCompatEditText27.perform(scrollTo(), replaceText("email@x.c"));

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.doc_email), withText("email@x.c"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5),
                        isDisplayed()));
        appCompatEditText28.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.doc_phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                6)));
        appCompatEditText29.perform(scrollTo(), replaceText("1"));

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.doc_phone), withText("1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText30.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.profile_edit_button), withText("Save Changes"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buttonPanel),
                                        0),
                                3)));
        appCompatButton3.perform(scrollTo(), click());

        pressBack();

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.medication_info), withText("ok - 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView3.check(matches(withText("ok - 4")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.medication_instructions), withText("44 pills taken at 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView4.check(matches(withText("44 pills taken at 4")));

        ViewInteraction imageView = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_rv),
                                        0),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.medications_rv),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        1),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.medication_info), withText("Copaxone - 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView5.check(matches(withText("Copaxone - 1")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.medication_instructions), withText("28 pills taken at 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView6.check(matches(withText("28 pills taken at 4")));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.button_add_medication), withText("Add New Medication"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_layout),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.medication_name_editText),
                        childAtPosition(
                                allOf(withId(R.id.medication_name_card),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                1)),
                                1),
                        isDisplayed()));
        appCompatEditText31.perform(replaceText("Tol"), closeSoftKeyboard());

        ViewInteraction appCompatEditText32 = onView(
                allOf(withId(R.id.total_pills_editText),
                        childAtPosition(
                                allOf(withId(R.id.medication_total_pills_card),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                2)),
                                1),
                        isDisplayed()));
        appCompatEditText32.perform(replaceText("30"), closeSoftKeyboard());

        ViewInteraction appCompatEditText33 = onView(
                allOf(withId(R.id.medication_strength_editText),
                        childAtPosition(
                                allOf(withId(R.id.medication_strength_card),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                3)),
                                1),
                        isDisplayed()));
        appCompatEditText33.perform(replaceText("2mg"), closeSoftKeyboard());

        ViewInteraction appCompatEditText34 = onView(
                allOf(withId(R.id.medication_dosage_editText),
                        childAtPosition(
                                allOf(withId(R.id.medication_dosage_card),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                4)),
                                1),
                        isDisplayed()));
        appCompatEditText34.perform(replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatCheckBox = onView(
                allOf(withId(R.id.morning_check), withText("Morning"),
                        childAtPosition(
                                allOf(withId(R.id.medication_frequency_selection),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                5)),
                                0),
                        isDisplayed()));
        appCompatCheckBox.perform(click());

        ViewInteraction appCompatRadioButton = onView(
                allOf(withId(R.id.syringe_button), withText("syringe"),
                        childAtPosition(
                                allOf(withId(R.id.medication_icon_selection),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                6)),
                                0),
                        isDisplayed()));
        appCompatRadioButton.perform(click());

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.Addbt), withText("Add Medication"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        ViewInteraction appCompatEditText35 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText35.perform(replaceText("test5@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatEditText36 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText36.perform(replaceText("0553223939"), closeSoftKeyboard());

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.login_button), withText("Login"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        2),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_rv),
                                        2),
                                0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.medication_info), withText("Tol - 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("Tol - 1")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.medication_instructions), withText("30 pills taken at 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("30 pills taken at 1")));

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction navigationMenuItemView4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        4),
                        isDisplayed()));
        navigationMenuItemView4.perform(click());

        /*ViewInteraction view = onView(
                allOf(withContentDescription("12 December 2019"),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(android.view.View.class),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(com.android.internal.widget.ViewPager.class),
                                                1)),
                                11),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction view2 = onView(
                allOf(IsInstanceOf.<View>instanceOf(android.view.View.class),
                        childAtPosition(
                                allOf(IsInstanceOf.<View>instanceOf(com.android.internal.widget.ViewPager.class),
                                        childAtPosition(
                                                withId(R.id.calendarView),
                                                0)),
                                1),
                        isDisplayed()));
        view2.check(matches(isDisplayed()));

         */

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction navigationMenuItemView5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        5),
                        isDisplayed()));
        navigationMenuItemView5.perform(click());

        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.textPhysician), withText("Text Physician"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.reports_layout),
                                        0),
                                3),
                        isDisplayed()));
        appCompatButton7.perform(click());

        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.callPhysician), withText("Call Physician"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.reports_layout),
                                        0),
                                4),
                        isDisplayed()));
        appCompatButton8.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction navigationMenuItemView6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView6.perform(click());

        ViewInteraction appCompatEditText37 = onView(
                allOf(withId(R.id.input_note),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.symptoms_layout),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText37.perform(replaceText("I am sad"), closeSoftKeyboard());

        ViewInteraction appCompatButton9 = onView(
                allOf(withId(R.id.symptoms_button), withText("Send to Physician"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.symptoms_layout),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton9.perform(click());

        ViewInteraction appCompatImageButton7 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton7.perform(click());

        ViewInteraction linearLayout6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.navigation_header_container),
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout6.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

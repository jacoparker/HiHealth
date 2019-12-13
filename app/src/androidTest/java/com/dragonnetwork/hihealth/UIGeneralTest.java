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
public class UIGeneralTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.SEND_SMS");

    /*
    This test focuses on the user interface.
    We are going over all the activities and pages to test all buttons and fields.
    Note: Due to a bug at Reports and Symptoms, we could not test these pages.
    The bug is caused after allowing or denying access to SMS. The app crashes
    after choosing the value.
     */
    @Test
    public void uIGeneralTest() {
        ViewInteraction imageView = onView(
                allOf(withId(R.id.imageView2),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction editText = onView(
                allOf(withId(R.id.login_email), withText("Email ..."),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        editText.check(matches(withText("Email ...")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.login_password), withText("Password ..."),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        editText2.check(matches(withText("Password ...")));

        ViewInteraction textView = onView(
                allOf(withText("HiHealth-Login"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("HiHealth-Login")));

        ViewInteraction button = onView(
                allOf(withId(R.id.login_button),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.link_signup),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.link_signup), withText("Sign up"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withText("HiHealth Register"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("HiHealth Register")));

        ViewInteraction imageView2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.register_name), withText("Full Name ..."),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        editText3.check(matches(withText("Full Name ...")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.register_email), withText("Email ..."),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        editText4.check(matches(withText("Email ...")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.register_dob), withText("Date of Birth ..."),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        editText5.check(matches(withText("Date of Birth ...")));

        ViewInteraction editText6 = onView(
                allOf(withId(R.id.register_password), withText("Password ..."),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        editText6.check(matches(withText("Password ...")));

        ViewInteraction editText7 = onView(
                allOf(withId(R.id.register_passwordreenter), withText("Reenter Password ..."),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        editText7.check(matches(withText("Reenter Password ...")));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.register_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        pressBack();

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
                allOf(withId(R.id.login_email), withText("test5@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("0553223939"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.login_password), withText("0553223939"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText4.perform(pressImeActionButton());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.login_button), withText("Login"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withText("Reminders"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        textView3.check(matches(withText("Reminders")));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        2),
                                0),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.missed_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.reminders_layout),
                                        0),
                                4),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.medication_info),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView4.check(matches(withText("")));

        ViewInteraction imageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton2.check(matches(isDisplayed()));

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
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.username_nav), withText("test5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_header_container),
                                        0),
                                1),
                        isDisplayed()));
        textView5.check(matches(withText("test5")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.view_profile_link), withText("View Profile and Information"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.navigation_header_container),
                                        0),
                                2),
                        isDisplayed()));
        textView6.check(matches(withText("View Profile and Information")));

        ViewInteraction checkedTextView = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        1),
                                0),
                        isDisplayed()));
        checkedTextView.check(matches(isDisplayed()));

        ViewInteraction checkedTextView2 = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        2),
                                0),
                        isDisplayed()));
        checkedTextView2.check(matches(isDisplayed()));

        ViewInteraction checkedTextView3 = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        3),
                                0),
                        isDisplayed()));
        checkedTextView3.check(matches(isDisplayed()));

        ViewInteraction checkedTextView4 = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        4),
                                0),
                        isDisplayed()));
        checkedTextView4.check(matches(isDisplayed()));

        ViewInteraction checkedTextView5 = onView(
                allOf(withId(R.id.design_menu_item_text),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        5),
                                0),
                        isDisplayed()));
        checkedTextView5.check(matches(isDisplayed()));

        ViewInteraction linearLayout2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.navigation_header_container),
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout2.perform(click());

        ViewInteraction linearLayout3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.navigation_header_container),
                                childAtPosition(
                                        withId(R.id.design_navigation_view),
                                        0)),
                        0),
                        isDisplayed()));
        linearLayout3.perform(click());

        ViewInteraction textView7 = onView(
                allOf(withText("Profile"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withId(R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        textView7.check(matches(withText("Profile")));

        ViewInteraction imageView4 = onView(
                allOf(withId(R.id.profile_avatar),
                        childAtPosition(
                                allOf(withId(R.id.profile_picture_view),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageView4.check(matches(isDisplayed()));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.username), withText("test5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                1),
                        isDisplayed()));
        textView8.check(matches(withText("test5")));

        ViewInteraction editText8 = onView(
                allOf(withId(R.id.email), withText("test5@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                2),
                        isDisplayed()));
        editText8.check(matches(withText("test5@gmail.com")));

        ViewInteraction editText9 = onView(
                allOf(withId(R.id.phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                3),
                        isDisplayed()));
        editText9.check(matches(withText("Phone")));

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.doc_name), withText("Doctor Name"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                4),
                        isDisplayed()));
        textView9.check(matches(withText("Doctor Name")));

        ViewInteraction editText10 = onView(
                allOf(withId(R.id.doc_email), withText("Doctor Email"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                5),
                        isDisplayed()));
        editText10.check(matches(withText("Doctor Email")));

        ViewInteraction editText11 = onView(
                allOf(withId(R.id.doc_phone), withText("Phone"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.profile_sv),
                                        0),
                                6),
                        isDisplayed()));
        editText11.check(matches(withText("Phone")));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.profile_edit_button),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        pressBack();

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

        ViewInteraction textView10 = onView(
                allOf(withText("Medications"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                1),
                        isDisplayed()));
        textView10.check(matches(withText("Medications")));

        ViewInteraction imageButton3 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        imageButton3.check(matches(isDisplayed()));

        ViewInteraction linearLayout4 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.medications_rv),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        0),
                        isDisplayed()));
        linearLayout4.check(matches(isDisplayed()));

        ViewInteraction imageView5 = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_rv),
                                        0),
                                0),
                        isDisplayed()));
        imageView5.check(matches(isDisplayed()));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.medication_info), withText("Copaxone - 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView11.check(matches(withText("Copaxone - 1")));

        ViewInteraction textView12 = onView(
                allOf(withId(R.id.medication_instructions), withText("28 pills taken at 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView12.check(matches(withText("28 pills taken at 4")));

        ViewInteraction linearLayout5 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.medications_rv),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        1),
                        isDisplayed()));
        linearLayout5.check(matches(isDisplayed()));

        ViewInteraction imageView6 = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_rv),
                                        1),
                                0),
                        isDisplayed()));
        imageView6.check(matches(isDisplayed()));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.medication_info), withText("ok - 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView13.check(matches(withText("ok - 4")));

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.medication_instructions), withText("44 pills taken at 4"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView14.check(matches(withText("44 pills taken at 4")));

        ViewInteraction linearLayout6 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.medications_rv),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        2),
                        isDisplayed()));
        linearLayout6.check(matches(isDisplayed()));

        ViewInteraction linearLayout7 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.medications_rv),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                        1)),
                        2),
                        isDisplayed()));
        linearLayout7.check(matches(isDisplayed()));

        ViewInteraction imageView7 = onView(
                allOf(withId(R.id.medication_icon),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_rv),
                                        2),
                                0),
                        isDisplayed()));
        imageView7.check(matches(isDisplayed()));

        ViewInteraction textView15 = onView(
                allOf(withId(R.id.medication_info), withText("Tol - 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        textView15.check(matches(withText("Tol - 1")));

        ViewInteraction textView16 = onView(
                allOf(withId(R.id.medication_instructions), withText("30 pills taken at 1"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        textView16.check(matches(withText("30 pills taken at 1")));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.button_add_medication),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_layout),
                                        0),
                                2),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button_add_medication), withText("Add New Medication"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.medications_layout),
                                        0),
                                2),
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction textView17 = onView(
                allOf(withText("Add New Medication"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                0)),
                                0),
                        isDisplayed()));
        textView17.check(matches(withText("Add New Medication")));

        ViewInteraction linearLayoutCompat = onView(
                allOf(withId(R.id.medication_name_card),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                1),
                        isDisplayed()));
        linearLayoutCompat.check(matches(isDisplayed()));

        ViewInteraction textView18 = onView(
                allOf(withText("Name:"),
                        childAtPosition(
                                allOf(withId(R.id.medication_name_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                0),
                        isDisplayed()));
        textView18.check(matches(withText("Name:")));

        ViewInteraction editText12 = onView(
                allOf(withId(R.id.medication_name_editText), withText("Enter name of prescription"),
                        childAtPosition(
                                allOf(withId(R.id.medication_name_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                1)),
                                1),
                        isDisplayed()));
        editText12.check(matches(withText("Enter name of prescription")));

        ViewInteraction editText13 = onView(
                allOf(withId(R.id.total_pills_editText), withText("Enter the total number of pills"),
                        childAtPosition(
                                allOf(withId(R.id.medication_total_pills_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                1),
                        isDisplayed()));
        editText13.check(matches(withText("Enter the total number of pills")));

        ViewInteraction textView19 = onView(
                allOf(withText("Total Pills:"),
                        childAtPosition(
                                allOf(withId(R.id.medication_total_pills_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                2)),
                                0),
                        isDisplayed()));
        textView19.check(matches(withText("Total Pills:")));

        ViewInteraction linearLayoutCompat2 = onView(
                allOf(withId(R.id.medication_total_pills_card),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        linearLayoutCompat2.check(matches(isDisplayed()));

        ViewInteraction textView20 = onView(
                allOf(withText("Strength:"),
                        childAtPosition(
                                allOf(withId(R.id.medication_strength_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                3)),
                                0),
                        isDisplayed()));
        textView20.check(matches(withText("Strength:")));

        ViewInteraction editText14 = onView(
                allOf(withId(R.id.medication_strength_editText), withText("Enter strength (e.g. 25 mg)"),
                        childAtPosition(
                                allOf(withId(R.id.medication_strength_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                3)),
                                1),
                        isDisplayed()));
        editText14.check(matches(withText("Enter strength (e.g. 25 mg)")));

        ViewInteraction linearLayoutCompat3 = onView(
                allOf(withId(R.id.medication_strength_card),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        linearLayoutCompat3.check(matches(isDisplayed()));

        ViewInteraction textView21 = onView(
                allOf(withText("Dosage:"),
                        childAtPosition(
                                allOf(withId(R.id.medication_dosage_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                4)),
                                0),
                        isDisplayed()));
        textView21.check(matches(withText("Dosage:")));

        ViewInteraction editText15 = onView(
                allOf(withId(R.id.medication_dosage_editText), withText("Enter number of doses"),
                        childAtPosition(
                                allOf(withId(R.id.medication_dosage_card),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                4)),
                                1),
                        isDisplayed()));
        editText15.check(matches(withText("Enter number of doses")));

        ViewInteraction linearLayoutCompat4 = onView(
                allOf(withId(R.id.medication_dosage_card),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        linearLayoutCompat4.check(matches(isDisplayed()));

        ViewInteraction linearLayoutCompat5 = onView(
                allOf(withId(R.id.medication_frequency_selection),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                5),
                        isDisplayed()));
        linearLayoutCompat5.check(matches(isDisplayed()));

        ViewInteraction checkBox = onView(
                allOf(withId(R.id.morning_check),
                        childAtPosition(
                                allOf(withId(R.id.medication_frequency_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                5)),
                                0),
                        isDisplayed()));
        checkBox.check(matches(isDisplayed()));

        ViewInteraction checkBox2 = onView(
                allOf(withId(R.id.afternoon_check),
                        childAtPosition(
                                allOf(withId(R.id.medication_frequency_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                5)),
                                1),
                        isDisplayed()));
        checkBox2.check(matches(isDisplayed()));

        ViewInteraction checkBox3 = onView(
                allOf(withId(R.id.evening_check),
                        childAtPosition(
                                allOf(withId(R.id.medication_frequency_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                5)),
                                2),
                        isDisplayed()));
        checkBox3.check(matches(isDisplayed()));

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.syringe_button),
                        childAtPosition(
                                allOf(withId(R.id.medication_icon_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                6)),
                                0),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));

        ViewInteraction radioButton2 = onView(
                allOf(withId(R.id.inhaler_button),
                        childAtPosition(
                                allOf(withId(R.id.medication_icon_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                6)),
                                1),
                        isDisplayed()));
        radioButton2.check(matches(isDisplayed()));

        ViewInteraction radioButton3 = onView(
                allOf(withId(R.id.pills_button),
                        childAtPosition(
                                allOf(withId(R.id.medication_icon_selection),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class),
                                                6)),
                                2),
                        isDisplayed()));
        radioButton3.check(matches(isDisplayed()));

        ViewInteraction radioGroup = onView(
                allOf(withId(R.id.medication_icon_selection),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                6),
                        isDisplayed()));
        radioGroup.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.Addbt),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        pressBack();

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
                        5),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());
        
        // The app crashed here because I tried to access symptopms page
        // TODO: Fix this bug

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.login_email),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.login_email), withText("test"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText6.perform(click());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.login_email), withText("test"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("test5@gmail.com"));

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.login_email), withText("test5@gmail.com"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatEditText8.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.login_password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText9.perform(replaceText("0553223939"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.login_button), withText("Login"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        appCompatButton4.perform(click());

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

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());

        ViewInteraction appCompatImageButton6 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.tool_bar),
                                        childAtPosition(
                                                withClassName(is("android.widget.RelativeLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton6.perform(click());

        ViewInteraction navigationMenuItemView3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView3.perform(click());
        
        
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
